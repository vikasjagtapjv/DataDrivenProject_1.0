package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.AdminPom;
import com.POM.LoginPom;
import com.base.BaseClass;

public class AdminTest extends BaseClass {
	AdminPom ap;
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
	public void adminTest()
	{
		lp=new LoginPom();
		ap=new AdminPom();
		
		lp.setUserN(lp.getUserName());
		lp.setPass(lp.getPass());
		lp.click();
		String Actual=driver.getCurrentUrl();
		String Expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(Actual, Expected);
		ap.clickOnAdmin();
		ap.setUserNm(ap.getUserName());
		ap.clickOnUserRole();
		ap.click_On_Admin();
		ap.setEmployeeName(ap.getEmployeeName());
		ap.setStatus();
		ap.click_On_Enabled();
		ap.clickOnSearch();
	}

}
