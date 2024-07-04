package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.POM.GmoOnlinePOM;
import com.Utility.Library;

public class GmoOnlineWithPOM extends Library{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		GmoOnlinePOM objGmoOnlinePOM = new GmoOnlinePOM(driver);
		objGmoOnlinePOM.EnterGmoOnline.click();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		objGmoOnlinePOM.Glacier_Sun_Glasses.clear();
		Thread.sleep(3000);
		objGmoOnlinePOM.Glacier_Sun_Glasses.sendKeys("3");
		Thread.sleep(3000);
		objGmoOnlinePOM.PlaceAnOrder.click();
		
		String titleOfPlaceOrderPage=driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		String unitPriceFromApp = objGmoOnlinePOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp:"+unitPriceFromApp);
		String ActualUnitPriceFromAppWithoutDoller=unitPriceFromApp.substring(2);
		System.out.println("ActualUnitPriceFromAppWithoutDoller:"+ActualUnitPriceFromAppWithoutDoller);
		float floatValueOfUnitPrice =  Float.parseFloat(ActualUnitPriceFromAppWithoutDoller);
		float calculatedValueOfUnitPrice = floatValueOfUnitPrice*3;
		System.out.println("calculatedValueOfUnitPrice:"+calculatedValueOfUnitPrice);
		
		String TotalPriceFromApp = objGmoOnlinePOM.totalPrimeFromApp.getText();
		System.out.println("TotalPriceFromApp:"+TotalPriceFromApp);
		String ActualTotalPriceFromAppWithoutDoller=unitPriceFromApp.substring(2);
		System.out.println("ActualTotalPriceFromAppWithoutDoller:"+ActualTotalPriceFromAppWithoutDoller);
		float CalculatedFloatValueOfTotalPriceFromApp =  Float.parseFloat(ActualTotalPriceFromAppWithoutDoller);
		System.out.println("CalculatedFloatValueOfTotalPriceFromApp:"+CalculatedFloatValueOfTotalPriceFromApp);
		
		Assert.assertEquals(calculatedValueOfUnitPrice, CalculatedFloatValueOfTotalPriceFromApp);
		driver.close();
	}

}
