package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.POM.DataDrivenPOM;
import com.POM.FramesPOM;
import com.POM.MouseOperationPOM;
import com.POM.WebTablePOM;
import com.POM.WindowsPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateDataDriven extends Library {
	public HashMap<String,String> TestDataHashMap = new HashMap<String,String>();

	@Test(priority=1)
	public void ValidateAutomationRegistrationWebSiteLaunched() {
		System.out.println("inside ValidateAutomationRegistrationWebSiteLaunched");
		ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("AutomationDemoSite"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		Assert.assertEquals(driver.getTitle(), objProp.getProperty("TitleOfRegisterWebSite"));
	}
	
	@Test(priority=2)
	public void ValidateDrivenFromExcel() {
		System.out.println("inside ValidateDrivenFromExcel");
		ExtTest=ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		try {
		File objTestDataFile = new File(System.getProperty("user.dir")+"//src//test//resources//TestData//AutomationDemoSite.xlsx");
		FileInputStream objInputStream =new FileInputStream(objTestDataFile);
		//If excel file extension is .xlsx 
		XSSFWorkbook objXSSFWorkBook= new XSSFWorkbook(objInputStream);
		XSSFSheet objXSSSheet = objXSSFWorkBook.getSheet("TestData");
		int NumberOfRows = objXSSSheet.getLastRowNum();
		System.out.println("NumberOfRows:"+NumberOfRows);
	
		for(int row=1;row<=NumberOfRows;row++) {
			System.out.println("Data from row:"+row);
			TestDataHashMap=ReadTestDataExcel(row,objXSSSheet);
			//System.out.println(TestDataHashMap.get("FirstName"));
			//System.out.println(TestDataHashMap.get("PhoneNumber"));
			//driver.findElement(By.xpath("")).sendKeys(TestDataHashMap.get("FirstName"));
			DataDrivenPOM objDataDrovemPOM = new DataDrivenPOM();
			objDataDrovemPOM.AutoDemoSiteFirstName.clear();
			objDataDrovemPOM.AutoDemoSiteFirstName.sendKeys(TestDataHashMap.get("FirstName"));
			
			objDataDrovemPOM.AutoDemoSiteLastName.clear();
			objDataDrovemPOM.AutoDemoSiteLastName.sendKeys(TestDataHashMap.get("LastName"));
			
			ClearingDataIntextBox(objDataDrovemPOM.AutoDemoSiteAdress);
			EnterDataInTextBox(objDataDrovemPOM.AutoDemoSiteAdress,TestDataHashMap.get("Address"));
			
			ClearingDataIntextBox(objDataDrovemPOM.AutoDemoSiteEmail);
			EnterDataInTextBox(objDataDrovemPOM.AutoDemoSiteEmail,TestDataHashMap.get("Email"));
			
			ClearingDataIntextBox(objDataDrovemPOM.AutoDemoSitePhone);
			EnterDataInTextBox(objDataDrovemPOM.AutoDemoSitePhone,TestDataHashMap.get("PhoneNumber"));
			
			if(TestDataHashMap.get("Gender").equals(objProp.getProperty("AutoDemoSiteGender"))) {
				objDataDrovemPOM.AutoDemoSiteGenderMale.click();
			}else {
				objDataDrovemPOM.AutoDemoSiteGenderFeMale.click();
			}
			
			if(TestDataHashMap.get("Hobbies").equals("Cricket")) {
				objDataDrovemPOM.AutoDemoSiteCricket.click();
			}else if(TestDataHashMap.get("Hobbies").equals("Movies")) {
				objDataDrovemPOM.AutoDemoSiteMovies.click();
			}else {
				objDataDrovemPOM.AutoDemoSiteHocky.click();
			}
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod(ITestResult result ) {
		UpdatingResultInExtentReport(result);
	}

	@BeforeClass
	public void beforeClass() {
		StartExtentReport();
	}

	@AfterClass
	public void afterClass() {
		FlushReport();
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
