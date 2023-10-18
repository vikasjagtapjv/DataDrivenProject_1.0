package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseClass;

public class Utility extends BaseClass {
	public static void implicitWait()
	{
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public Sheet getSheet(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./excelData/OrangeHRM.xlsx");
		Sheet sheet=WorkbookFactory.create(fis).getSheet(sheetName);
		return sheet;
	}
	
	public static void getSingleData(int cellNum,int rowNum,Sheet sheet)
	{
		if(sheet.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("String"))
		{
			sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
		else
		{
			sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		}
		
	}
	public void getAllExcelData(Sheet sheet)
	{
		HashMap<String, String>hm=new HashMap<String ,String>();
		for (int r=0;r<sheet.getLastRowNum();r++)
		{
			int cellNum=sheet.getRow(r).getLastCellNum();
			for(int c=0;c<cellNum;c++)
			{
				
				hm.put(sheet.getRow(r).getCell(c).getStringCellValue(),sheet.getRow(r).getCell(c).getStringCellValue());
			}
		}
		//By using for each loop
		for(Map.Entry<String, String>e:hm.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		//By using Iterator
		 Iterator<Entry<String,String> > iterator= hm.entrySet().iterator();
	        
	        while(iterator.hasNext())
	        {
	        	Map.Entry<String,String> e1=(Map.Entry<String, String>)iterator.next();
	        	
	        	System.out.println(e1.getKey()+" "+e1.getValue());
	        }

		
	}
	
	

}
