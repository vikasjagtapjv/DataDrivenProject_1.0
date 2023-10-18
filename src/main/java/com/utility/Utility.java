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
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
	}
	public Sheet getSheet(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Vikas\\eclipse-workspace\\DataDrivenProject\\src\\main\\resources\\excelData\\OrangeHRM.xlsx");
		Sheet sheet=WorkbookFactory.create(fis).getSheet(sheetName);
		return sheet;
	}
	
	public Object getSingleData(int rowNum,int cellNum,Sheet sheet)
	{
		if(sheet.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))
		
			return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		else
		
			return sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		
		 
	
		
		
	}
	public Object getAllExcelData(Sheet sh)
	{
		HashMap<String, String>hm=new HashMap<String ,String>();
		for (int r=1;r<=sh.getLastRowNum();r++)
		{
			int cellNum=sh.getRow(r).getLastCellNum();
			for(int c=0;c<cellNum;c++)
			{
				
				hm.put(sh.getRow(r).getCell(c).getStringCellValue(),sh.getRow(r).getCell(++c).getStringCellValue());
			}
		}
		//By using for each loop
		for(Map.Entry<String, String>e:hm.entrySet())
		{
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		return hm;
		
		//By using Iterator
//		 Iterator<Entry<String,String> > iterator= hm.entrySet().iterator();
//	        
//	        while(iterator.hasNext())
//	        {
//	        	Map.Entry<String,String> e1=(Map.Entry<String, String>)iterator.next();
//	        	
//	        	System.out.println(e1.getKey()+" "+e1.getValue());
//	        }

		
	}
	
	

}
