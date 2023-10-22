package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.POM.PIM_Pom;
import com.base.BaseClass;

public class PIM_Test extends BaseClass{
	LoginPom lp;
	@BeforeClass
	public void setup() throws IOException {
		
		launchWeb();
	}
	@AfterClass
	
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	//@Test(priority=0)
	public void loginTest() throws InterruptedException
	{
		
		
		String Actual=driver.getCurrentUrl();
		String Expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=1)
	public void pimTest() throws InterruptedException
	{

		lp=new LoginPom();
		
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
