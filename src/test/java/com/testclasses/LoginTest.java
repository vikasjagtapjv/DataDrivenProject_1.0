package com.testclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.base.BaseClass;
import com.utility.Utility;

public class LoginTest extends BaseClass{
	LoginPom lp;
@BeforeMethod
public void setup() throws IOException {
	
	launchWeb();
}
@AfterMethod
public void tearDown()
{
	driver.close();
	driver.quit();
}
@Test
public void loginTest() throws InterruptedException
{
	lp=new LoginPom();
	lp.setUserN(lp.getUserName());
	lp.setPass(lp.getPass());
	Thread.sleep(5000);

	lp.click();
	String Actual=driver.getCurrentUrl();
	String Expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	Assert.assertEquals(Actual, Expected);
}
@Test
public void testUser() throws EncryptedDocumentException, IOException, InterruptedException {
	lp=new LoginPom();
	Utility utility=new Utility();
	Sheet sh=utility.getSheet("Sheet1");
	getDataFromExcel();
	String key= (String)utility.getSingleData(1, 0, sh);
	String value=(String) utility.getSingleData(1, 1, sh);
	Thread.sleep(5000);

	lp.setUserN(key);
	lp.setPass(value);
	Thread.sleep(5000);
	Utility.implicitWait();
	lp.click();
	Thread.sleep(5000);
}
public void getDataFromExcel() throws EncryptedDocumentException, IOException
{
	Utility utility=new Utility();
	Sheet sh=utility.getSheet("Sheet1");
	utility.getAllExcelData(sh);

//	String key= (String)utility.getSingleData(1, 0, sh);
//	String value=(String) utility.getSingleData(1, 1, sh);
	
	
}

}
