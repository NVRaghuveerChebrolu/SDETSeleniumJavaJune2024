package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BasePage;

public class AutomationDemoSitePOM extends BasePage
{
	public AutomationDemoSitePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Alert with OK ']")
	public WebElement alertWithOkBtn;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	public WebElement alertBoxWithOk;
	
	@FindBy(xpath="//a[text()='Alert with OK & Cancel ']")
	public WebElement alertWithOkAndCancelBtn;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement confirmAlertBox;
	
	@FindBy(id="demo")
	public WebElement confirmAlertResult;
	
	@FindBy(xpath="//a[text()='Alert with Textbox ']")
	public WebElement alertWithTextBox;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	public WebElement promptAlertTextBox;
	
	@FindBy(id="demo1")
	public WebElement promptAlertResult;
	
}
