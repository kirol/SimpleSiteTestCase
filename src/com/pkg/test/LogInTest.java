package com.pkg.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.po.LogInPage;


public class LogInTest {
	
	
	@Test(dataProvider="DataProvider",dataProviderClass=com.pkg.pa.DataProviderClass.class)
	public void LogInTestMethod(String iTestCase, String iUsername, String iPassword, String iExpected, String flow) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:3080/SimpleSite/");
		LogInPage.username(driver).sendKeys(iUsername);
		LogInPage.password(driver).sendKeys(iPassword);
		LogInPage.submit(driver).click();
		if(flow.equals("Alt")){
			String actual = LogInPage.errormsg(driver).getText();
		Assert.assertEquals(actual, iExpected);
		}else if(flow.equals("Normal")){
			String actual = driver.getCurrentUrl();
			Assert.assertEquals(actual, iExpected);
		}
		
		
			
		
		
		
	
	}

}
