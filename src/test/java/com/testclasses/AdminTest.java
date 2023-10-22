package com.testclasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POM.AdminPom;
import com.POM.LoginPom;
import com.POM.PIM_Pom;
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
	@Test(priority=1)
	public void pimTest() throws InterruptedException
	{

		LoginPom lp=new LoginPom();
		
	PIM_Pom pp=new PIM_Pom();
		
	lp=new LoginPom();
	lp.setUserN(lp.getUserName());

	lp.setPass(lp.getPass());
	lp.clickOnLogin();
		// -----SEARCH EMPLOYEE WITH AVAILABLE INFORMATION -------//
		pp.click_OnPim();
		pp.setEmployeeNm(pp.getEmployeeNm());
		pp.clickOnEmp();
		pp.setEmpID(pp.getEmpID());
		pp.clickOn_Save();
		
		//--ADD EMPLOYEE----------------------//
		pp.click_On_addEmp();
		pp.setEmployeefn("scott");
		pp.setEmployeeMN("edword");
		pp.setEmployeeLN("decort");
		pp.setEmployeeID("0698");
		pp.clickOnSave();
		
		//---REPORTS--------------
		pp.enterOnReport();
		pp.setReportName(pp.getReportName());
		pp.enterOnHint();
		pp.click_On_Search();
		pp.clickON_Report();
		
		}


}
