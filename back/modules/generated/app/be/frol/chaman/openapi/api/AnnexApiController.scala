package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Annex
import play.api.libs.Files.TemporaryFile

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class AnnexApiController @Inject()(cc: ControllerComponents, api: AnnexApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * POST /api/item/:uuid/annex
    */
  def uploadFile(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Annex] = {
      val file = request.body.asMultipartFormData.flatMap(_.file("file").map(_.ref: TemporaryFile))

      api.uploadFile(uuid, file)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  private def splitCollectionParam(paramValues: String, collectionFormat: String): List[String] = {
    val splitBy =
      collectionFormat match {
        case "csv" => ",+"
        case "tsv" => "\t+"
        case "ssv" => " +"
        case "pipes" => "|+"
      }

    paramValues.split(splitBy).toList
  }
}
