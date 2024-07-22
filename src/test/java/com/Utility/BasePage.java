package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage 
{
	public static WebDriver driver;
	public static Properties objProp;
	
	public static void ReadBasePageFiles() throws IOException
	{
		try 
		{
			File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//Config.Properties");
			FileInputStream objInputFile = new FileInputStream(objFile);
			objProp = new Properties();
			objProp.load(objInputFile);
			System.out.println(objProp.getProperty("browser"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser()
	{
		String launchBrowser = objProp.getProperty("browser");
		switch (launchBrowser.toLowerCase())
		{
		case "chrome" :
			driver = new ChromeDriver();
			break;
			
		case "firefox" :
			driver = new FirefoxDriver();
			break;
			
		case "edge" :
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please provide valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWaitTimeOut));
	}
	
	public void WaitTillPageLoad(int seconds)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public void ScrollTillTheElement(WebElement webelement)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", webelement);
	}

}
