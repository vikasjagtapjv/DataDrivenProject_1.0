package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Utility;

public class BaseClass {
	public static  WebDriver driver;
	FileInputStream fis;
	public static String projectPath=System.getProperty("user.dir");
	 
	public void launchWeb() throws IOException
	{
		fis=new FileInputStream(projectPath+"\\src\\main\\resources\\Property\\config.properties");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Properties pro=new Properties();
		
		pro.load(fis);
	
		pro.getProperty("WebUrl");
		
			
	     driver.get(pro.getProperty("WebUrl"));
	    Utility.implicitWait();
		 
		
	}

}
