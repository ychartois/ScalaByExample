package patterns

import scala.concurrent._
import ExecutionContext.Implicits.global

object Lifting_pattern {

  // Definition:
  // The lifting pattern is used to lift a normal value (say T)
  // to an other one (like a Monad of T, for example Future[T])
  
  // Haskell Def:
  // The lifting pattern is to float bindings to a higher level in the program.
  // link: http://www.haskell.org/haskellwiki/Lifting_pattern
  
  // Application:
  // You have a method wich return a Future[T], but in some case your
  // are able to return the value directly (from the cache for example)
  // You want to promote tis value to a Future to respect the method signature
  
  // Source: Principles of Reactive Programming - Coursera
  
  /*************************************
  * 								CODE
  **************************************/	
  // We define the function that lift the value
  implicit class FutureCompanionOps[T](val f: Future.type) extends AnyVal {
    def always[T](value: T): Future[T] = future { value } // <-- Returns a future that is always completed with `value`.
  }
  
  // We define a fake cache and a fake http server request
  val cache = List("1")                           //> cache  : List[String] = List(1)
  def askServer( request: String ) = "A http request that can take some times"
                                                  //> askServer: (request: String)String
  
  // If the value is in the cache, we return the value from the cache which is lifted
  // by the "always" method
  // Otherwise we return the Future which will have the server return
  def query(request: String): Future[String] =
  	if ( cache.contains(request) ) Future.always( cache.head )
  	else Future { askServer(request) }        //> query: (request: String)scala.concurrent.Future[String]
}