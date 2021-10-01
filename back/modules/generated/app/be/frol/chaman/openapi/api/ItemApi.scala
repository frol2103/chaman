package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Item
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait ItemApi {
  /**
    * create an item
    */
  def createItem(item: Item)(implicit request:Request[AnyContent]): Future[Item]


  /**
    * delete a item
    */
  def deleteItem(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * get a item
    */
  def getItem(uuid: String)(implicit request:Request[AnyContent]): Future[Item]


  /**
    * Get all items
    */
  def getItems()(implicit request:Request[AnyContent]): Future[List[Item]]


  /**
    * update a item
    */
  def updateItem(uuid: String, item: Item)(implicit request:Request[AnyContent]): Future[Item]

}
