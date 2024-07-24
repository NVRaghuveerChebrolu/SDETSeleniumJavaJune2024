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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment9_Handling_MouseOperations extends BasePage
{
  @Test(priority=0,enabled=false)
  public void LaunchDemoQAButtonsSite() 
  {
	  System.out.println("inside LaunchDemoQAButtonsSite");
	  driver.get(objProp.getProperty("DemoQAButtonsUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DemoQAButtonsTitle"));
  }
  
  @Test(priority=1,enabled=false)
  public void ValidateDoubleClick()
  {
	  System.out.println("inside ValidateDoubleClick");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.doubleClickBtn);
	  Actions objAtions = new Actions(driver);
	  objAtions.doubleClick(objAlertPOM.doubleClickBtn).build().perform();
	  //Thread.sleep(4000);
	  boolean doubleClickMessageDisplayed = objAlertPOM.doubleClickMessage.isDisplayed();
	  Assert.assertEquals(doubleClickMessageDisplayed, true);
  }
  
  @Test(priority=2,dependsOnMethods = {"LaunchDemoQAButtonsSite"},enabled=false)
  public void ValidateRightClick()
  {
	  System.out.println("inside ValidateRightClick");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.rightClickBtn);
	  Actions objAtions = new Actions(driver);
	  objAtions.contextClick(objAlertPOM.rightClickBtn).build().perform();
	  //Thread.sleep(4000);
	  boolean rightClickMessageDisplayed = objAlertPOM.rightClickMessage.isDisplayed();
	  Assert.assertEquals(rightClickMessageDisplayed, true);
  }
  
  @Test(priority=3,dependsOnMethods = {"LaunchDemoQAButtonsSite"},enabled=false)
  public void ValidateDynamicClick()
  {
	  System.out.println("inside ValidateDynamicClick");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.dynamicClickBtn);
	  Actions objAtions = new Actions(driver);
	  objAtions.doubleClick(objAlertPOM.dynamicClickBtn).build().perform();
	  //Thread.sleep(4000);
	  boolean dynamicClickMessageDisplayed = objAlertPOM.dynamicClickMessage.isDisplayed();
	  Assert.assertEquals(dynamicClickMessageDisplayed, true);
  }
  
  @Test(priority=4,enabled=false)
  public void LaunchInternerherokuAppSite() 
  {
	  System.out.println("inside LaunchInternerherokuAppSite");
	  driver.get(objProp.getProperty("InternertHerokuUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("InternertHerokuTitle"));
  }
  
  @Test(priority=5,enabled=false)
  public void ValidateDragAndDrop()
  {
	  System.out.println("inside ValidateDragAndDrop");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  Actions objAtions = new Actions(driver);
	  objAtions.dragAndDrop(objAlertPOM.dragBox, objAlertPOM.dropBox).build().perform(); 
  }
  
  @Test(priority=6)
  public void LaunchDemoGuru99Site() 
  {
	  System.out.println("inside LaunchDemoGuru99Site");
	  driver.get(objProp.getProperty("DemoGuruUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DemoGuruTitle"));
  }
  
  @Test(priority=7,enabled=false)
  public void ValidateRightClickBtn() throws Exception
  {
	  System.out.println("inside ValidateRightClickBtn");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  Actions objAtions = new Actions(driver);
	  ScrollTillTheElement(objAlertPOM.rightClick);
	  objAtions.contextClick(objAlertPOM.rightClick).build().perform();
	  objAlertPOM.copyOption.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("RightClickAlertText"));
	  Thread.sleep(3000);
	  objAlert.accept();
  }
  
  @Test(priority=8)
  public void ValidateDoubleClickBtn() throws Exception
  {
	  System.out.println("inside ValidateDoubleClickBtn");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.doubleClick);
	  Actions objAtions = new Actions(driver);
	  objAtions.doubleClick(objAlertPOM.doubleClick).build().perform();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String alertText = objAlert.getText();
	  Assert.assertEquals(alertText, objProp.getProperty("DoubleClickAlertText"));
	  Thread.sleep(3000);
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
