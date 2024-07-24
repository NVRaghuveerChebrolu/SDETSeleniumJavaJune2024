package com.selenium;

import org.testng.annotations.Test;

import com.Utility.BasePage;
import com.Utility.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment4_Launch_And_Validate_Ecommerce_Website extends BasePage
{
  @Test(priority=0)
  public void ValidateAmazonBrowserTitle() 
  {
	  System.out.println("inside ValidateAmazonBrowserTitle");
	  driver.get(objProp.getProperty("AmazonUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("AmazonTitle"));
  }
  
  @Test(priority=1)
  public void ValidateFlipkartBrowserTitle() 
  {
	  System.out.println("inside ValidateAmazonBrowserTitle");
	  driver.get(objProp.getProperty("FlipkartUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("FlipkartTitle"));  
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("inside afterTest");
	  driver.close();
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("inside beforeSuite");
	  try 
	  {
		ReadBasePageFiles();
	} catch (IOException e) 
	{
		e.printStackTrace();
	}
	  
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("inside afterSuite");
  }

}
