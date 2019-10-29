package Selenium.Practice.com.Nisum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import org.testng.annotations.Test;


public class hasmap {
	
	@Test
    public  void hasmaptest() {
		 HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
     map.put(0, null);

     map.put(1, 50);
     map.put(2, 70);
     map.put(3, 30);
     map.put(4, 60);
     map.put(5, 60);
       System.out.println(map);
     int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
     for (Entry<Integer, Integer> entry : map.entrySet()) {  // Itrate through hashmap
         if (entry.getValue()==maxValueInMap) {
             System.out.println("HER IS  MAX VALUE  " +entry.getValue() + entry.getKey());     // Print the key with max value
         }

}}}

