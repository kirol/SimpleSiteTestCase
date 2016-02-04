package com.pkg.pa;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="DataProvider")
	public static Object[][] DataProviderMethod() throws IOException{
		
		
		/*return new Object[][]{
			{"1","","","as"},
			{"1","minhqlrt","password","as"},
		};*/
		
		
		
		FileInputStream in = new FileInputStream("D:\\eclipseee\\workplace\\SimpleSiteTestCase\\testdata.xls");
		Workbook workbook = new HSSFWorkbook(in);
		Sheet sheet = workbook.getSheet("Sheet1");
		Object[][] ob = new Object[sheet.getLastRowNum()][5];
		int i=0;
		for(int excelRow=1;excelRow<sheet.getLastRowNum()+1;excelRow++){
			Row row = sheet.getRow(excelRow); 
			int j=0;
			for(int excelCell=0;excelCell<row.getLastCellNum();excelCell++){
				ob[i][j] = row.getCell(excelCell).getStringCellValue();
				j++;
			}
			i++;
		}
		workbook.close();
		return ob;
	}
}
	
