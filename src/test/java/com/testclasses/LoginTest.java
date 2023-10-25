package com.testclasses;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.base.BaseClass;
import com.myexception.UserNotFoundException;
import com.utility.Utility;
import com.utility.Utility_1;
@Listeners(MyListner.class);
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
@Test(dataProvider="lgData")
public void loginTest(Map<String, String>data) throws InterruptedException
{
	lp=new LoginPom();
	lp.setUserN(data.get("UserName"));
	lp.setPass(data.get("Password"));
	lp.clickOnLogin();
	String Actual=driver.getCurrentUrl();
	try {
	 throw new UserNotFoundException();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	String Expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	Assert.assertEquals(Actual, Expected);
}
@DataProvider(name="lgData")
public Object[][] getExcelData() throws EncryptedDocumentException, IOException
{
	Utility utility=new Utility();
	Sheet sheet=utility.getSheet("Sheet1");
	Object[][]data=utility.getData(sheet);
	return data;
}
@Test
public void testUser() throws EncryptedDocumentException, IOException, InterruptedException {
	lp=new LoginPom();
	Utility utility=new Utility();
	Sheet sh=utility.getSheet("Sheet1");
	getDataFromExcel();
	String key= (String)utility.getSingleData(1, 0, sh);
	String value=(String) utility.getSingleData(1, 1, sh);
	

	lp.setUserN(key);
	lp.setPass(value);
	
	Utility.implicitWait();
	lp.clickOnLogin();
	
}
public void getDataFromExcel() throws EncryptedDocumentException, IOException
{
	Utility utility=new Utility();
	Sheet sh=utility.getSheet("Sheet1");
	utility.getAllExcelData(sh);

//	String key= (String)utility.getSingleData(1, 0, sh);
//	String value=(String) utility.getSingleData(1, 1, sh);
	
	
}
@Test(dataProvider="loginData")
public void loginTest(String UserName,String Password)
{   
	lp=new LoginPom();
	lp.setUserN(UserName);
	lp.setPass(Password);
	lp.clickOnLogin();
	String actualTitle=driver.getTitle();
	String expectedTitle="OrangeHRM";
	Assert.assertEquals(actualTitle, expectedTitle);

}
@DataProvider(name="loginData")
public Object[][] getData() throws IOException
{
	String path="C:\\Users\\Vikas\\eclipse-workspace\\DataDrivenProject\\src\\main\\resources\\excelData\\OrangeHRM.xlsx";
	Utility_1 eUtil=new Utility_1(path);
	int totalRows=eUtil.getRowCount("Sheet1");
	int totalcols=eUtil.getCellCount("Sheet1",1);
	
	Object data[][]=new Object[totalRows][totalcols];
	
	for (int i=1;i<=totalRows;i++)
	{
		for(int j=0;j<totalcols;j++)
		{
			data[i-1][j]=eUtil.getCellData("Sheet1", i, j);
		}
	}
	return data;
			
			
}

}
