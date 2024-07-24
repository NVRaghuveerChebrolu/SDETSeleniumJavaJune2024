package com.selenium;

import org.testng.annotations.Test;

import com.POM.AutomationDemoSitePOM;
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

public class Assignment6_Handling_Alerts_Automation_Demo_Site extends BasePage
{
  @Test(priority=0)
  public void LaunchAutomationDemoSite() 
  {
	  System.out.println("inside LaunchAutomationDemoSite");
	  driver.get(objProp.getProperty("AutomationDemoSiteUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("AutomationDemoSiteTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateAlertWithOk() throws Exception
  {
	  System.out.println("inside ValidateAlertWithOk");
	  AutomationDemoSitePOM objAlertPOM = new AutomationDemoSitePOM(driver);
	  objAlertPOM.alertWithOkBtn.click();
	  objAlertPOM.alertBoxWithOk.click();
	  Alert objAlert = driver.switchTo().alert();
	  String alertText = objAlert.getText();
	  Thread.sleep(3000);
	  Assert.assertEquals(alertText, objProp.getProperty("AlertBoxWithText"));
	  objAlert.accept();
  }
  
  @Test(priority=2,enabled=false)
  
 public void ValidateAlertWithOkAndCancel() throws Exception
 {
	  System.out.println("inside ValidateAlertWithOkAndCancel");
	  AutomationDemoSitePOM objAlertPOM = new AutomationDemoSitePOM(driver);
	  objAlertPOM.alertWithOkAndCancelBtn.click();
	  objAlertPOM.confirmAlertBox.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String confirmAlertText = objAlert.getText();
	  Assert.assertEquals(confirmAlertText, objProp.getProperty("ConfirmAlertBoxWithText"));
	  objAlert.accept();
	  boolean confirmAlertResultText = objAlertPOM.confirmAlertResult.isDisplayed();
	  Assert.assertEquals(confirmAlertResultText, true);
 }
  
  @Test(priority=3)
  public void ValidateAlertWithTextBox() throws Exception
  {
	  System.out.println("inside ValidateAlertWithTextBox");
	  AutomationDemoSitePOM objAlertPOM = new AutomationDemoSitePOM(driver);
	  objAlertPOM.alertWithTextBox.click();
	  objAlertPOM.promptAlertTextBox.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textMessage = objAlert.getText();
	  Assert.assertEquals(textMessage, objProp.getProperty("TextMessageOfPromptBoxAlert"));
	  objAlert.sendKeys(objProp.getProperty("PromptBoxMessageEntered"));
	  objAlert.accept();
	  String PromptBoxResultMessageDisplayed = objAlertPOM.promptAlertResult.getText();
	  Assert.assertEquals(PromptBoxResultMessageDisplayed, objProp.getProperty("PromptBoxResultMessage"));
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
