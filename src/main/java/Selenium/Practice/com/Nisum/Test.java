package Selenium.Practice.com.Nisum;

public class Test {
	
	//You can overload the main() method, but only public static void main(String[] args) will be used when your class is launched by the JVM. For example:
	
	 
	    /*public static void main(String arg1) {
	        System.out.println("main(String arg1)");
	    }
	    public static void main(String[] args) {
	        System.out.println("main(String[] args)");
	    }
	    public static void main(String arg1, String arg2) {
	        System.out.println("main(String arg1, String arg2)");
	    }	
	    //---------output = main(String[] args)------------
	    */
	
	
	    public static void main(int a){  
	    	  System.out.println(a);  
	    	  }  

	    	  public static void main(String args[]){  
	    	  System.out.println("main() method invoked");  
	    	  main(10);  
	    	  } 
	  	    //---------output = main() method invoked  10------------

	
	
	/*public static void main(String[] args) throws InterruptedException
	{
		System.out.println("main A");
	}
	
	public static void main(int args) throws InterruptedException
	{
		
		System.out.println("main B");

	}*/
//output = main A

}
