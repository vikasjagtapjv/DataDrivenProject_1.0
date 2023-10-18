package com.testclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.base.BaseClass;
import com.utility.Utility;

public class LoginTest extends BaseClass{
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
public void loginTest()
{
	LoginPom lp=new LoginPom();
	lp.setUserN(lp.getUserName());
	lp.setPass(lp.getPass());
	lp.click();
}
public void testUser() {
	LoginPom lp=new LoginPom();
	
}
public void getDataFromExcel() throws EncryptedDocumentException, IOException
{
	Utility utility=new Utility();
	Sheet sh=utility.getSheet("Sheet1");
	utility.getAllExcelData(sh);
}

}
