package com.selenium;

import org.testng.annotations.Test;

import com.POM.DemoQAPOM;
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

public class Assignment7_Handling_Frames_DemoQA extends BasePage
{
  @Test(priority=0,enabled=false)
  public void LaunchDemoQAFramesSite() 
  {
	  System.out.println("inside LaunchDemoQAFramesSite");
	  driver.get(objProp.getProperty("DemoQAFramesUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DemoQAFramesTitle"));
  }
  
  @Test(priority=1,dependsOnMethods = {"LaunchDemoQAFramesSite"},enabled=false)
  public void ValidateDemoQAFrames() throws Exception
  {
	  System.out.println("inside ValidateDemoQAFrames");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.iFrame);
	  driver.switchTo().frame(objAlertPOM.iFrame);
	  Thread.sleep(4000);
	  String textInsideIFrame = objAlertPOM.textInsideIFrame.getText();
	  Assert.assertEquals(textInsideIFrame, objProp.getProperty("TextInsideIFrame"));
  }
  
  @Test(priority=2)
  public void LaunchDemoQANestedFrames() 
  {
	  System.out.println("inside LaunchDemoQAFrames");
	  driver.get(objProp.getProperty("DemoQANestedFramesUrl"));
	  WaitTillPageLoad(Constants.pageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DemoQANestedFramesTitle"));
  }
  
  @Test(priority=3,dependsOnMethods = {"LaunchDemoQANestedFramesSite"})
  public void ValidateDemoQAParentAndChildFrames() throws Exception
  {
	  System.out.println("inside ValidateDemoQAParentAndChildFrames");
	  DemoQAPOM objAlertPOM = new DemoQAPOM(driver);
	  ScrollTillTheElement(objAlertPOM.parentFrame);
	  driver.switchTo().frame(objAlertPOM.parentFrame);
	  Thread.sleep(4000);
	  String textInsideParentIFrame = objAlertPOM.parentFrameText.getText();
	  Assert.assertEquals(textInsideParentIFrame, objProp.getProperty("TextInsideParentIFrame"));
	  driver.switchTo().frame(objAlertPOM.childFrame);
	  Thread.sleep(4000);
	  String textInsideChildIFrame = objAlertPOM.childFrameText.getText();
	  Assert.assertEquals(textInsideChildIFrame, objProp.getProperty("TextInsideChildIFrame"));
	  driver.switchTo().defaultContent();
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
