package com.selenium;

import org.testng.annotations.Test;

import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateGmoOnlineSunGlassesFlow extends Library{
 
  @Test
  public void ValidateLaunchOfGmoOnlineApplication() {
	  System.out.println("inside ValidateLaunchOfGmoOnlineApplication");
	  driver.get(objProp.getProperty("GmoOnLineAppURL"));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PageLoadTimeOut));
	  String titleOfGMO_OnlineApp=driver.getTitle();
	  Assert.assertEquals(titleOfGMO_OnlineApp,objProp.getProperty("TitleOfGmoOnlineHomePage"));
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
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inisde afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inisde beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inisde afterSuite");
  }
}
