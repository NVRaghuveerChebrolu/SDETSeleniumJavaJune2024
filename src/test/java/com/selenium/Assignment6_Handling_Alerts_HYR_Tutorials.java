package com.selenium;

import org.testng.annotations.Test;

import com.POM.HYRTutorialsPOM;
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

public class Assignment6_Handling_Alerts_HYR_Tutorials extends BasePage
{
  @Test(priority=0)
  public void LaunchHYRTutorialsSite() 
  {
	  System.out.println("inside LaunchHYRTutorialsSite");
	  driver.get(objProp.getProperty("HYRTutorialsUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("HYRTutorialsTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateDisplayAlertBox() throws Exception
  {
	  System.out.println("inside ValidateDisplayAlertBox");
	  HYRTutorialsPOM hyrPOM = new HYRTutorialsPOM(driver);
	  hyrPOM.alertBoxBtn.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(4000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("TextInsideAlertBox"));
	  objAlert.accept();
	  ScrollTillTheElement(hyrPOM.alertPopUp);
	  boolean alertPopUpMessageDisplayed = hyrPOM.alertPopUp.isDisplayed();
	  Assert.assertEquals(alertPopUpMessageDisplayed, true);
  }
  
  @Test(priority=2,enabled=false)
  public void ValidateDisplayConfirmAlertBox() throws Exception
  {
	  System.out.println("inside ValidateDisplayConfirmAlertBox");
	  HYRTutorialsPOM hyrPOM = new HYRTutorialsPOM(driver);
	  hyrPOM.confirmAlertBox.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(4000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("TextInsideConfirmAlertBox"));
	  objAlert.dismiss();
	  ScrollTillTheElement(hyrPOM.alertPopUp);
	  boolean confirmAlertMessageDisplayed = hyrPOM.alertPopUp.isDisplayed();
	  Assert.assertEquals(confirmAlertMessageDisplayed, true);
  }
  
  @Test(priority=3)
  public void ValidateDisplayPromptAlertBox() throws Exception
  {
	  System.out.println("inside ValidateDisplayPromptAlertBox");
	  HYRTutorialsPOM hyrPOM = new HYRTutorialsPOM(driver);
	  ScrollTillTheElement(hyrPOM.promptAlertBox);
	  hyrPOM.promptAlertBox.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(4000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("TextInsidePromptAlertBox"));
	  objAlert.sendKeys(objProp.getProperty("PromptAlertMessageEntered"));
	  objAlert.accept();
	  String PromptAlertResultMessageDisplayed = hyrPOM.alertPopUp.getText();
	  Assert.assertEquals(PromptAlertResultMessageDisplayed, objProp.getProperty("PopupBoxOutput"));
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
