package basics

object Tail_recursion {
  
  // Goal:
 	// A way to increase performance when using recursion
 	
 	// Source:
 	// Functional Programming Principles in Scala - Coursera
  
  /*************************************
  * 		The non-tail recursive way
  **************************************/
  def factorial(n: Int): Int = {
  	if ( n == 0 ) 1 else n * factorial( n - 1 )
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res0: Int = 24
  // 4 * factorial(3)
  // 4 * 3 * factorial(2)
  // 4 * 3 * 2 * factorial(1)
  // 4 * 3 * 2 * factorial(0)
  // 24
  // => We have to store the result to compute the final result ! We can't reuse the same
  // Stack Frame and for big number you have a risk of StackOverflow Exception
   
  
  /*************************************
  * 		The tail recursive way
  **************************************/
  def fact(n: Int): Int = {
  	def loop( acc: Int, n: Int): Int =
  		if (n == 0) acc else loop(n * acc, n - 1)
  	
  	loop(1,n)
  }                                               //> fact: (n: Int)Int
  
  fact(4)                                         //> res1: Int = 24
  // loop(1, 4)
  // loop(4, 3)
  // loop(12, 2)
  // loop(24, 1)
  // 24
}