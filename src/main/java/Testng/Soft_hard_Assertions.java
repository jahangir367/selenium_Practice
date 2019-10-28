package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_hard_Assertions {
	
	/*Soft Assert: Soft Assert collects errors during @Test. Soft Assert does not throw an exception when an assert fails 
	   and would continue with the next step after the assert statement.
	Hard Assert: Hard Assert throws an AssertExceptionimmediately when an assert statement fails and test suite continues 
	with next @Test.
              */
	
	@Test
	public void testCaseOne() {
		System.out.println("*** hard test case one started ***");
		Assert.assertEquals(5, 5, "First hard assert failed");
		System.out.println("hard assert success....");
		// test case fails here and do not proceed next step
		Assert.assertTrue("Hello".equals("hello"), "Second hard assert failed");
		System.out.println("*** test case one executed successfully ***");
	}
	@Test
	public void testCasetwo() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("*** soft test case one started ***");
		softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
		System.out.println("soft assert success....");
		// test case fails here and then proceed to next step
		softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
		softAssert.assertTrue("Welcome".equals("Welcome"), "Third soft assert failed");
		System.out.println("*** test case two executed successfully ***");
		softAssert.assertAll();
	}}
