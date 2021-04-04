package be.frol.chaman

import be.frol.chaman.api._
import be.frol.chaman.openapi.api._
import play.api.inject.{Binding, Module => PlayModule}
import play.api.{Configuration, Environment}

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
class Module extends PlayModule {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    bind[FieldApi].to[FieldApiImpl],
    bind[DatatypesApi].to[DatatypesApiImpl],
    bind[TemplateApi].to[TemplateApiImpl],
  )
}
