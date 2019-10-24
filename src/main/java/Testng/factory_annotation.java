package Testng;

import org.testng.annotations.Factory;

public class factory_annotation {

	
	
	public class TestNGFactory {

		@Factory()
		public Object[] getTestClasses() {
			Object[] tests = new Object[2];
			tests[0] = new Priority_testng();
			tests[1] = new data_provider();
			return tests;
		}
		
	}
}
