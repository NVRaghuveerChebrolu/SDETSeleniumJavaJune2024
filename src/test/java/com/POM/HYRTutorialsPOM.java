package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BasePage;

public class HYRTutorialsPOM extends BasePage
{
	public HYRTutorialsPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "alertBox")
	public WebElement alertBoxBtn;
	
	@FindBy(id = "output")
	public WebElement alertPopUp;
	
	@FindBy(id = "confirmBox")
	public WebElement confirmAlertBox;
	
	@FindBy(id = "promptBox")
	public WebElement promptAlertBox;
}
