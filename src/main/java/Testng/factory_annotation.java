package Testng;

import org.testng.annotations.Factory;

public class factory_annotation {

	
	
	public class TestNGFactory {
    //TestNG Factory is useful when you want to run multiple test classes through a single test class.
		@Factory()
		public Object[] getTestClasses() {
			Object[] tests = new Object[2];
			tests[0] = new Priority_testng();
			tests[1] = new data_provider();
			return tests;
		}
		
	}
}
