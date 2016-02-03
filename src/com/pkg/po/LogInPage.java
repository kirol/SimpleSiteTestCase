package com.pkg.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	public static WebElement element = null;
	
	public static WebElement username(WebDriver driver){
		element = driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement password(WebDriver driver){
		element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement submit(WebDriver driver){
		element = driver.findElement(By.name("submitButton"));
		return element;
	}
	
	public static WebElement errormsg(WebDriver driver){
		element = driver.findElement(By.id("errorMessage"));
		return element;
	}
}
