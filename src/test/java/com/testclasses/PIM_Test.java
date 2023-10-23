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
	public void pimTest()
	{
		LoginPom lp=new LoginPom();

		lp.setUserN(lp.getUserName());
		lp.setPass(lp.getPass().trim());
		lp.clickOnLogin();
		PIM_Pom pp=new PIM_Pom();
		pp.click_OnPim();
		pp.enterEmployeeNm("virat");
		pp.setEmpID("0249");
		pp.setEmpStatus();
		pp.listOfStatus();
		pp.includeEmp();
		pp.includeEmpList();
		pp.enterSupName("virat");
		pp.job_Title();
		pp.enterJobTitle();
		pp.sub_unit();
		pp.enterSubUnit();
		pp.clickOn_Save();
		pp.click_On_addEmp();
		pp.setEmployeefn("Mat");
		pp.setEmployeeMN("santer");
		pp.setEmployeeLN("john");
		pp.setEmpID("0268");
		pp.clickOnSave();
		pp.enterOnReport();
		pp.enterReportName("PIM Sample Report");
		pp.click_On_Search();
		pp.clickON_Report();
	}


}
