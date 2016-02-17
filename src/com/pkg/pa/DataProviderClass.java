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
		
//Whatever
		
		
		FileInputStream in = new FileInputStream("./testdata.xls");
		Workbook workbook = new HSSFWorkbook(in);
		Sheet sheet = workbook.getSheet("Sheet1");
		// getLastRowNum returns a number with a count starts from 0
		Object[][] ob = new Object[sheet.getLastRowNum()][5];
		int i=0;
		for(int excelRow=1;excelRow<sheet.getLastRowNum()+1;excelRow++){
			Row row = sheet.getRow(excelRow); 
			System.out.println(row.getLastCellNum());
			int j=0;
			// getLastCellNum returns a number with a count starts from 1
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
	
