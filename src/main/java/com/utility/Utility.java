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
	public HashMap<String, String> getAllExcelData(Sheet sh)
	{
		int rowCount = sh.getLastRowNum();
		HashMap<String, String>hm=new HashMap<String ,String>();
		Object[][] dataprovider =new Object[rowCount][2];
		for (int r=1;r<=sh.getLastRowNum();r++)
		{
			int cellNum=sh.getRow(r).getLastCellNum();
			for(int c=0;c<cellNum;c++)
			{

				hm.put(sh.getRow(r).getCell(c).getStringCellValue(),sh.getRow(r).getCell(++c).getStringCellValue());
			}
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
	public Object[][] getData(Sheet sh) {

		int rowCount = sh.getLastRowNum();

		Map<String, Object> finalData = new HashMap<>();

		Object[][] excelData = new Object[rowCount][1];


		for(int i=0; i<rowCount; i++) {

			Map<String, Object> data = new HashMap<>();

			int colNum = sh.getRow(i).getLastCellNum();

			for(int j=0; j<colNum; j++) {

				if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric")){
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getNumericCellValue());
				}
				else {
					System.out.println("cell type not match..");
				}

			}

			excelData[i][0] = data;



			data.forEach(finalData::put);


		}

		return excelData;
	}



}
