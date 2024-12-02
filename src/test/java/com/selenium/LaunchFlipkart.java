package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFlipkart {
	static WebDriver driver;
	public static void main(String[] args) {
		// single line comment

		/*
		 * Multi line comments this is my firat java program
		 * 
		 */
		System.out.println("inisde main method");
		System.out.println("inside LaunchFlipkart");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("samsung mobiles");
		driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();
		//driver.close();
	}
}
