package com.selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.POM.GmoOnlinePOM;
import com.Utility.Constants;
import com.Utility.Library;

public class GmoOnlineWithPOMandPropertiesFile extends Library{

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ReadPropertiesFile();
		LaunchBrowser();
		driver.get(objProp.getProperty("GmoOnLineAppURL"));
		GmoOnlinePOM objGmoOnlinePOM = new GmoOnlinePOM(driver);
		objGmoOnlinePOM.EnterGmoOnline.click();
		
		objGmoOnlinePOM.Glacier_Sun_Glasses.clear();
		Thread.sleep(3000);
		objGmoOnlinePOM.Glacier_Sun_Glasses.sendKeys(Constants.Glacier_Sun_Glasses_QTY);
		Thread.sleep(3000);
		objGmoOnlinePOM.PlaceAnOrder.click();
		
		String titleOfPlaceOrderPage=driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		String unitPriceFromApp = objGmoOnlinePOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp:"+unitPriceFromApp);
		String ActualUnitPriceFromAppWithoutDoller=unitPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("ActualUnitPriceFromAppWithoutDoller:"+ActualUnitPriceFromAppWithoutDoller);
		float floatValueOfUnitPrice =  Float.parseFloat(ActualUnitPriceFromAppWithoutDoller);
		float calculatedValueOfUnitPrice = floatValueOfUnitPrice*Integer.parseInt(Constants.Glacier_Sun_Glasses_QTY);
		System.out.println("calculatedValueOfUnitPrice:"+calculatedValueOfUnitPrice);
		
		String TotalPriceFromApp = objGmoOnlinePOM.totalPrimeFromApp.getText();
		System.out.println("TotalPriceFromApp:"+TotalPriceFromApp);
		String ActualTotalPriceFromAppWithoutDoller=unitPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("ActualTotalPriceFromAppWithoutDoller:"+ActualTotalPriceFromAppWithoutDoller);
		float CalculatedFloatValueOfTotalPriceFromApp =  Float.parseFloat(ActualTotalPriceFromAppWithoutDoller);
		System.out.println("CalculatedFloatValueOfTotalPriceFromApp:"+CalculatedFloatValueOfTotalPriceFromApp);
		
		Assert.assertEquals(calculatedValueOfUnitPrice, CalculatedFloatValueOfTotalPriceFromApp);
		driver.close();
	}

}
