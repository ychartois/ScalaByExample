package basics

object CallByName_CallByValue {
 	// http://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
 	
 	def test() = {
 		println("Print something")
 	  1 // return value
 	}                                         //> test: ()Int
 	
 	def callByValue( x: Int ) = {
 		println("x1=" + x)
 		println("x2=" + x)
 	}                                         //> callByValue: (x: Int)Unit
 	
 	def callByName( x: => Int ) = {
 		println("x1=" + x)
 		println("x2=" + x)
 	}                                         //> callByName: (x: => Int)Unit
 	
 	callByValue( test() )                     //> Print something
                                                  //| x1=1
                                                  //| x2=1
 	callByName( test() )                      //> Print something
                                                  //| x1=1
                                                  //| Print something
                                                  //| x2=1
}