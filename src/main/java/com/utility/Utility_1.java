package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility_1 {
	public FileInputStream fis;
	public FileOutputStream fio;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path=null;
	 public Utility_1(String path)
	{
		this.path=path;
	}
	public int getRowCount(String sheetName) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return  rowcount;
	}
	public int getCellCount(String sheetName,int rownum)throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
		data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
		
	}
	public void setCellData(String sheetName,int rowcount,int cellcount,String data) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowcount);
		cell=row.getCell(cellcount);
		cell.setCellValue(data);
		
		fio=new FileOutputStream(path);
		workbook.write(fio);
		workbook.close();
		fis.close();
		fio.close();
		
	}
	public void fillGreencolor(String sheetName,int rownum,int cellnum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fio);
		workbook.close();
		fis.close();
		fio.close();
	}
	public void fillRedColor(String sheetName,int rownum,int cellnum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fio);
		workbook.close();
		fis.close();
		fio.close();
		
	}
	public  static void   takeScreenshot(String fileName) throws IOException
	{
		//String path=C:\Users\Vikas\eclipse-workspace\DataDrivenProject\Screenshots
		TakesScreenshot driver = null;
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Vikas\\eclipse-workspace\\DataDrivenProject\\Screenshots\\image01.png");
		FileHandler.copy(sourcefile, destination);
	}
		

}
