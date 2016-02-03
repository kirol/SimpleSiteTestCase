package com.pkg.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.po.LogInPage;


public class LogInTest {
	
	
	@Test
	public void LogInTestMethod() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:3080/SimpleSite/");
		
		FileInputStream in = new FileInputStream("testdata.xls");
		Workbook workbook = new HSSFWorkbook(in);
		Sheet sheet = workbook.getSheet("Sheet1");
		String cell = null;
		for(int i=1;i<sheet.getLastRowNum()+1;i++){
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				cell = row.getCell(j).getStringCellValue();
				if(j==0){
					System.out.println("Test case: " + cell);
				}
				else if(j==1){
					LogInPage.username(driver).sendKeys(cell);
				}else if(j==2){
					LogInPage.password(driver).sendKeys(cell);
				}
			}
			LogInPage.submit(driver).click();
			Assert.assertEquals(LogInPage.errormsg(driver).getText(), cell);
			System.out.println("Passed");
			
		}
		workbook.close();
		
		
	
	}

}
