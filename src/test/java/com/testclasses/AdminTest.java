package com.testclasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POM.AdminPom;
import com.POM.LoginPom;
import com.base.BaseClass;

public class AdminTest extends BaseClass {
	
	
	@BeforeClass
	public void setup() throws IOException {
		
		launchWeb();
	}
	@AfterClass
	
	public void tearDown()
	{
		
		driver.quit();
	}
	@Test
	public void adminTest() throws InterruptedException
	{
		LoginPom lp=new LoginPom();
		
		lp.setUserN(lp.getUserName());
		lp.setPass(lp.getPass().trim());
		
		AdminPom ap=lp.clickOnLogin();
		
	    ap.clickOnAdmin();
		ap.setUserNm(ap.getUserName());
		ap.clickOnUserRole();
		ap.click_On_Admin();
		ap.setEmployeeName(ap.getEmployeeName());
		ap.setStatus();
		ap.click_On_Enabled();
		ap.clickOnSearch();
		ap.clickOnEdit();
		ap.reset();
		//add user
		ap.clickOnAddUsers();
		ap.userRole();
		ap.AdminSelect();
		ap.clickOnStatus();
		ap.getEnabled();
		ap.enterEmployeeNameHint("Viraj");
		ap.enterUserName("VirajJ");
		ap.enterPassword("admin1234");
		ap.enterConfirmPassword("admin1234");
		ap.clickOnSaveButton();
		
		
		
	}

}
