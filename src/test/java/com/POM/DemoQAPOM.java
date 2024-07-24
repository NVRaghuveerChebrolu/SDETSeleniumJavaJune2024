package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BasePage;

public class DemoQAPOM extends BasePage
{
	public DemoQAPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "showSmallModal")
	public WebElement showSmallModalBtn;
	
	@FindBy(id = "showLargeModal")
	public WebElement showLargeModalBtn;
	
	@FindBy(id = "frame1")
	public WebElement iFrame;
	
	@FindBy(id = "sampleHeading")
	public WebElement textInsideIFrame;
	
	@FindBy(id = "frame1")
	public WebElement parentFrame;
	
	@FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
	public WebElement childFrame;
	
	@FindBy(xpath = "//body[text()='Parent frame']")
	public WebElement parentFrameText;
	
	@FindBy(xpath = "//p[text()='Child Iframe']")
	public WebElement childFrameText;
	
	@FindBy(id = "doubleClickBtn")
	public WebElement doubleClickBtn;
	
	@FindBy(id = "rightClickBtn")
	public WebElement rightClickBtn;
	
	@FindBy(xpath = "//button[text()='Click Me']")
	public WebElement dynamicClickBtn;
	
	@FindBy(id = "doubleClickMessage")
	public WebElement doubleClickMessage;
	
	@FindBy(id = "rightClickMessage")
	public WebElement rightClickMessage;
	
	@FindBy(id = "dynamicClickMessage")
	public WebElement dynamicClickMessage;
	
	@FindBy(id = "column-a")
	public WebElement dragBox;
	
	@FindBy(id = "column-b")
	public WebElement dropBox;
	
	@FindBy(xpath = "//span[@class='context-menu-one btn btn-neutral']")
	public WebElement rightClick;
	
	@FindBy(xpath = "//button[text()='Double-Click Me To See Alert']")
	public WebElement doubleClick;
	
	@FindBy(xpath = "//span[text()='Copy']")
	public WebElement copyOption;
}
