package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	public static WebDriver driver;
	public static Properties objProp;

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
	
}
