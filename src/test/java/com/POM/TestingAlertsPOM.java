package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BasePage;

public class TestingAlertsPOM extends BasePage
{
	public TestingAlertsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "iframeWithAlert")
	public WebElement iFrameWithAlert;
	
	@FindBy(id = "alertInFrame")
	public WebElement alertInFrame;
	
	@FindBy(id = "open-page-with-onload-alert")
	public WebElement openPageWithOnloadAlertLink;
	
	@FindBy(xpath = "//body")
	public WebElement textInsideBody;
	
}
