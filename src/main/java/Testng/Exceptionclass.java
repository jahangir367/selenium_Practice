package Testng;

import org.testng.annotations.Test;

public class Exceptionclass {
	
	   @Test(expectedExceptions = ArithmeticException.class)
	   public void testPrintMessage() {	
	      System.out.println("Inside testPrintMessage()");   
	      int i =0 ;
	      int n = 5/0;
	      System.out.println(n);
	      
	      
	   }


}
