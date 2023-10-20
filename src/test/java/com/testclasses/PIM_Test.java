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
	@Test(priority=0)
	public void loginTest() throws InterruptedException
	{
		lp=new LoginPom();
		lp.setUserN(lp.getUserName());
		Thread.sleep(5000);
		lp.setPass(lp.getPass());
		Thread.sleep(5000);
		lp.click();
		Thread.sleep(5000);
		String Actual=driver.getCurrentUrl();
		String Expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=1)
	public void pimTest() throws InterruptedException
	{
		PIM_Pom pp=new PIM_Pom();
		
		// -----SEARCH EMPLOYEE WITH AVAILABLE INFORMATION -------//
		Thread.sleep(5000);
		pp.click_OnPim();
		Thread.sleep(5000);
		pp.setEmployeeNm(pp.getEmployeeNm());
		Thread.sleep(5000);
		pp.clickOnEmp();
		Thread.sleep(5000);
		pp.setEmpID(pp.getEmpID());
		Thread.sleep(5000);
		pp.clickOn_Save();
		
		//--ADD EMPLOYEE----------------------//
		Thread.sleep(5000);
		pp.click_On_addEmp();
		Thread.sleep(5000);
		pp.setEmployeefn("scott");
		Thread.sleep(5000);
		pp.setEmployeeMN("edword");
		Thread.sleep(5000);
		pp.setEmployeeLN("decort");
		Thread.sleep(5000);
		pp.setEmployeeID("0698");
		Thread.sleep(5000);
		pp.clickOnSave();
		
		//---REPORTS--------------
		pp.enterOnReport();
		pp.setReportName(pp.getReportName());
		pp.enterOnHint();
		pp.click_On_Search();
		pp.clickON_Report();
		
		}

}
