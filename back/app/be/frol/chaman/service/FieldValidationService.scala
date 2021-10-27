package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.error.ValidationError
import be.frol.chaman.openapi.model.{Field, Item}
import be.frol.chaman.utils.OptionUtils.{enrichedObject, enrichedOption}
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.{JsNull, Json, Writes}

import javax.inject.Inject
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

class FieldValidationService @Inject()(
                                        val dbConfigProvider: DatabaseConfigProvider,
                                        val fieldService: FieldService,
                                      )(
                                        implicit val executionContext: ExecutionContext
                                      ) extends DbContext {

  import api._

  def validateFields(input: List[Field]): DBIO[List[Field]] = {
    fieldService.getFieldsDefinition(input.flatMap(_.uuid)).map { fieldDefs =>
      input.map { f =>
        val fieldDef = fieldDefs.get(f.uuid.get).getOrThrowM("Cannot find field " + f.reference)
        Try(
          f.value.getOrElse(Nil).map(v => v.copy(value = v.value.map(fieldDef.parseAndFormat(_))))
        ) match {
          case Success(value) => f.copy(value = value.toOpt(), errorMessages = None)
          case Failure(e) => f.copy(errorMessages = List(e.getMessage).toOpt())
        }
      }
    }
  }

  def assertValidFields(input:List[Field]) : DBIO[List[Field]] = {
    assertValidFieldsMap[List[Field]](input, v => v, (i, v) => v)
  }
  def assertValidField(input:Field) : DBIO[Field] = {
    assertValidFieldsMap[Field](input, v => List(v), (i, v) => v.head)
  }

  def assertValidFieldsItem(input:Item) : DBIO[Item] = {
    assertValidFieldsMap[Item](input, v => v.content.getOrElse(Nil), (i, v) => i.copy(content = v.toOpt()))
  }
  def assertValidFieldsMap[T](input:T,getFIelds :  T => List[Field], outputCreator : (T, List[Field])=>T)(implicit w:Writes[T]) : DBIO[T] = {
    validateFields(getFIelds(input)).map{ validatedFields =>
      if(!validatedFields.flatMap(_.errorMessages.getOrElse(Nil)).isEmpty){
        throw new ValidationError("error in fields", Json.toJson(outputCreator(input, validatedFields)))
      } else {
        outputCreator(input, validatedFields)
      }
    }
  }
}

