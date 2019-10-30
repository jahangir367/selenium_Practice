package Selenium.Practice.com.Nisum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;


public class hasmap {
	  int count = 0;

	  @Test(timeOut = 10000, invocationCount = 6, successPercentage = 100)
	  public void successRate() {
		 int i=5;
		 while (i>2){
		 try{

		 System.out.println(i);
		 Thread.sleep(1000);
		 i--;
		 }
		 catch(Exception e)
		 {
		 System.out.println(e);
		 }}
	 }
	  /*  System.out.println("repeat..." + (++count));
	    if (count > 15) {
	      Assert.fail("fail with count > 15");
	    } }*/
	
	@Test
    public  void hasmaptest() {
		 HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
     map.put(1, 50);
     map.put(2, 70);
     map.put(3, 30);
     map.put(4, 60);
     map.put(5, 60);
       System.out.println(map);
     int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
     for (Entry<Integer, Integer> entry : map.entrySet()) {  // Itrate through hashmap
         if (entry.getValue()==maxValueInMap) {
             System.out.println("HER IS  MAX VALUE  " +entry.getValue() + " = " +entry.getKey()); 
             // Print the key with max value
         }

}}}

