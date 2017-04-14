package fr.sogeti.verticles

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.ext.web.Router
import io.vertx.core.Handler
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.scala.ext.web.handler.BodyHandler
import fr.sogeti.rest.{ProductResource, SupplierResource, CategoryResource}
import fr.sogeti.services.{SupplierService, ProductService, CategoryService}

class HttpServerVerticle extends ScalaVerticle {
  override def start() : Unit = {
    val router : Router = Router.router(vertx)
    
    router.route.handler( BodyHandler.create )
    
    val productResource : ProductResource = new ProductResource( router, new ProductService )
    val categoryResource : CategoryResource = new CategoryResource( router, new CategoryService )
    val supplierResource : SupplierResource = new SupplierResource( router, new SupplierService )
    
    vertx.createHttpServer.requestHandler( new Handler[HttpServerRequest]() {
      override def handle( request : HttpServerRequest ) : Unit = {
        router.accept(request)
      }
    } ).listen( 8080 )
  }
}