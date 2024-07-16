package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.POM.FramesPOM;
import com.POM.MouseOperationPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperationsInSeleneium extends Library{
  
	@Test(priority=1)
	public void ValidateLoadingOfJqueryApp(){
		System.out.println("iniside ValidateLoadingOfJqueryApp");
		driver.get(objProp.getProperty("mouseOpeartionRightClick"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title= driver.getTitle();
		Assert.assertEquals(title, objProp.getProperty("JQeryTitle"));
	}
	
	@Test(priority=2)
	public void ValidateRightClickOperation() throws InterruptedException {
		System.out.println("iniside ValidateRightClickOperation");
		Actions objActions = new Actions(driver);
		MouseOperationPOM objMouseOpPOM= new MouseOperationPOM();
		objActions.contextClick(objMouseOpPOM.RightClickMeButton).build().perform();
		objMouseOpPOM.PasteOption.click();
		Alert objAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		String TextMessageOfAlert=objAlert.getText();
		Assert.assertEquals(TextMessageOfAlert, objProp.getProperty("mouseOpeartionRightclick_PateOptionAlertText"));
		objAlert.accept();
	}

  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
