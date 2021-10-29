package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Field
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.openapi.model.ItemDescr

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait ItemApi {
  /**
    * create an item
    */
  def createItem()(implicit request:Request[AnyContent]): Future[ItemDescr]


  /**
    * delete a item
    */
  def deleteItem(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * delete an item field
    */
  def deleteItemField(uuid: String, uuidField: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * get a item
    */
  def getItem(uuid: String)(implicit request:Request[AnyContent]): Future[Item]


  /**
    * Get all items
    */
  def getItems()(implicit request:Request[AnyContent]): Future[List[ItemDescr]]


  /**
    * update an item field
    */
  def updateItemField(uuid: String, uuidField: String, field: Field, subReferenceUuid: Option[String])(implicit request:Request[AnyContent]): Future[Field]

}
