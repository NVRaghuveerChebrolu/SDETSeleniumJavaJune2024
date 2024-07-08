package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotations {
  @Test(priority=3)
  public void testCase1() {
	  System.out.println("inisde testCase1");
  }
  
  @Test(priority=0)
  public void testCase2() {
	  System.out.println("inisde TestCase2");
  }
  
  @Test
  public void TestCase5() {
	  System.out.println("inisde TestCase5");
  }
  
  @Test(priority=-7)
  public void Testcase3() {
	  System.out.println("inisde TestCase3");
  }
  
  @Test(priority=-4)
  public void testCase4() {
	  System.out.println("inisde testCase4");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inisde beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inisde AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inisde beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inisde afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inisde beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inisde afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inisde beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inisde afterSuite");
  }

}
