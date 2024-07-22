package com.selenium;

import org.testng.annotations.Test;

import com.POM.DemoQAPOM;
import com.Utility.BasePage;
import com.Utility.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment6_Handling_Alerts_DemoQA extends BasePage
{
  @Test(priority=0)
  public void LaunchDemoQASite() 
  {
	  System.out.println("inside LaunchDemoQASite");
	  driver.get(objProp.getProperty("DemoQAUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DemoQATitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void smallModalDialog() throws Exception
  {
	  System.out.println("inside smallModalDialog");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.showSmallModalBtn);
	  objAlertPOM.showSmallModalBtn.click();
	  Thread.sleep(5000);
	  Alert objAlert = driver.switchTo().alert();
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("SmallModalAlert"));
	  objAlert.accept();
  }
  
  @Test(priority=2)
  public void largeModalDialog() throws Exception
  {
	  System.out.println("inside largeModalDialog");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.showLargeModalBtn);
	  objAlertPOM.showLargeModalBtn.click();
	  Thread.sleep(3000);
	  Alert objAlert = driver.switchTo().alert();
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("LargeModalAlertText"));
	  objAlert.accept();
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
	  //driver.close();
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
