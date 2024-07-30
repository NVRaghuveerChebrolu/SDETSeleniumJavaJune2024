package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Library {
	public static WebDriver driver;
	public static Properties objProp;
	
	public static ExtentHtmlReporter ExtHtmlReporter ;
	public static ExtentReports ExtReports;
	public static ExtentTest ExtTest;
	public HashMap<String,String> TestDataHashMap = new HashMap<String,String>();
	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */
	
	public void StartExtentReport() {
		// TODO Auto-generated method stub
		File objFile = new File(System.getProperty("user.dir")+"//test-output//ExtentReportV4.html");
		ExtentHtmlReporter objExtentHtmlReporter = new ExtentHtmlReporter(objFile);
		objExtentHtmlReporter.config().setDocumentTitle("Automation Report");
		objExtentHtmlReporter.config().setReportName("Extent Report");
		objExtentHtmlReporter.config().setTheme(Theme.STANDARD);
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(objExtentHtmlReporter);
		
		ExtReports.setSystemInfo("TesterName", "Raghuveer");
		ExtReports.setSystemInfo("Broswer", objProp.getProperty("browser"));
		ExtReports.setSystemInfo("Environment", objProp.getProperty("Environment"));
		
	}
	
	public void UpdatingResultInExtentReport(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case Passed is "+result.getName());
		}else if(result.getStatus()==ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed due to "+result.getThrowable());
			try {
				ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	/* Author : Raghuveer
	 * This method is used to take screen shot and store the screen shots in side ScreenShot folder
	 */
	public static String TakeScreenShot(String testcaseName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName+"captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}
	
	public void FlushReport() {
		ExtReports.flush();
	}

	public static void ReadPropertiesFile() throws IOException {
		try {
			File ObjFile = new File(System.getProperty("user.dir") + "//src//test//resources//Config.Properties");
			FileInputStream objFileInput = new FileInputStream(ObjFile);
			objProp = new Properties();
			objProp.load(objFileInput);
			System.out.println(objProp.getProperty("browser"));
			System.out.println(objProp.getProperty("GmoOnLineAppURL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser() {
		String browserFromPropFile = objProp.getProperty("browser");
		switch(browserFromPropFile.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "ie":
			driver=new InternetExplorerDriver();
			break;	
		default:
			System.out.print("Please provide broswer name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	}
	
	public void PageLoadTimeOut(int seconds) {
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public void ScrollIntoWebElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//js.executeScript("window.scrollBy(0,250)", "");// to perform scroll down operation by 250 pixels 
		//js.executeScript("window.scrollBy(0,-340)", "");// to perform scroll up operation by 340 pixels 
		//js.executeScript("window.scrollBy(250,0)", "");// to perform scroll right operation by 250 pixels 
		//js.executeScript("window.scrollBy(-550,0)", "");// to perform scroll left operation by 550 pixels 
		
	}

	public void DocumentReadyStateComplete() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("return document.readyState").toString().equals("complete");
	}
	
	public int randomCalenderDayvalue() {
		Random random = new Random();   
		// Generates random integers 0 to 31 
		int x = random.nextInt(32); 
		if(x==0) {
			x=1;
		}
		System.out.println("random day generated is:"+x);
		return x;
	}
	
	public HashMap<String, String> ReadTestDataExcel(int row, XSSFSheet objXSSSheet) {
		// TODO Auto-generated method stub
		DataFormatter objDataFormatter = new DataFormatter();				 													
		TestDataHashMap.put("RunMode", objXSSSheet.getRow(row).getCell(0).getStringCellValue());
		TestDataHashMap.put("TestCaseName", objXSSSheet.getRow(row).getCell(1).getStringCellValue());
		TestDataHashMap.put("FirstName", objXSSSheet.getRow(row).getCell(2).getStringCellValue());
		TestDataHashMap.put("LastName", objXSSSheet.getRow(row).getCell(3).getStringCellValue());
		TestDataHashMap.put("Address", objXSSSheet.getRow(row).getCell(4).getStringCellValue());
		TestDataHashMap.put("Email", objXSSSheet.getRow(row).getCell(5).getStringCellValue());
		
		TestDataHashMap.put("PhoneNumber", objDataFormatter.formatCellValue(objXSSSheet.getRow(row).getCell(6)));
		
		TestDataHashMap.put("Gender", objXSSSheet.getRow(row).getCell(7).getStringCellValue());
		TestDataHashMap.put("Hobbies", objXSSSheet.getRow(row).getCell(8).getStringCellValue());
		TestDataHashMap.put("Languages", objXSSSheet.getRow(row).getCell(9).getStringCellValue());
		TestDataHashMap.put("Skills", objXSSSheet.getRow(row).getCell(10).getStringCellValue());
		TestDataHashMap.put("Country", objXSSSheet.getRow(row).getCell(11).getStringCellValue());
		TestDataHashMap.put("SelectCountry", objXSSSheet.getRow(row).getCell(12).getStringCellValue());
		
		TestDataHashMap.put("DOB_YY", objDataFormatter.formatCellValue(objXSSSheet.getRow(row).getCell(13)));
		
		TestDataHashMap.put("DOB_MM", objXSSSheet.getRow(row).getCell(14).getStringCellValue());
		
		TestDataHashMap.put("DOB_DD", objDataFormatter.formatCellValue(objXSSSheet.getRow(row).getCell(5)));
		
		TestDataHashMap.put("Password", objXSSSheet.getRow(row).getCell(16).getStringCellValue());
		TestDataHashMap.put("confirm Password", objXSSSheet.getRow(row).getCell(17).getStringCellValue());
		
		return TestDataHashMap;
	}

	
}
