package com.selenium;

import org.testng.annotations.Test;

import com.POM.TestingAlertsPOM;
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

public class Assignment6_Handling_Alerts_Testing_Alerts extends BasePage
{
  @Test(priority=0)
  public void LaunchTestingAlertSite() 
  {
	  System.out.println("inside LaunchTestingAlertSite");
	  driver.get(objProp.getProperty("TestAlertsUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAlertsTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void AlertInIFrame() throws Exception
  {
	  System.out.println("inside AlertInIFrame");
	  TestingAlertsPOM objTestingAlertPOM = new TestingAlertsPOM(driver);
	  ScrollTillTheElement(objTestingAlertPOM.iFrameWithAlert);
	  driver.switchTo().frame(objTestingAlertPOM.iFrameWithAlert);
	  Thread.sleep(3000);
	  objTestingAlertPOM.alertInFrame.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("TextInsideAlert"));
	  objAlert.accept();
  }
  
  @Test(priority=2)
  public void AlertOnNewPage() throws Exception
  {
	  System.out.println("inside AlertOnNewPage");
	  TestingAlertsPOM objTestingAlertPOM = new TestingAlertsPOM(driver);
	  ScrollTillTheElement(objTestingAlertPOM.openPageWithOnloadAlertLink);
	  Thread.sleep(4000);
	  objTestingAlertPOM.openPageWithOnloadAlertLink.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(4000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("TextInsideAlertInNewPage"));
	  objAlert.accept();
	  boolean text = objTestingAlertPOM.textInsideBody.isDisplayed();
	  Thread.sleep(4000);
	  Assert.assertEquals(text, true);
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
