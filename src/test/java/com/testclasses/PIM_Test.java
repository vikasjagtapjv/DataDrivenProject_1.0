package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.POM.PIM_Pom;
import com.base.BaseClass;
import com.utility.Utility_1;

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

	@Test(dataProvider="pimTestData")
	public void pimTest(String user,String pass,String userName,String id,String SupName,String MiddleNm,String lastname,String reportname ) throws InterruptedException
	{
		LoginPom lp=new LoginPom();

		lp.setUserN(user);
		lp.setPass(pass);
		lp.clickOnLogin();
		PIM_Pom pp=new PIM_Pom();
		pp.click_OnPim();
		pp.enterEmployeeNm(userName);
		pp.setEmpID(id);
		pp.setEmpStatus();
		pp.listOfStatus();
		pp.includeEmp();
		pp.includeEmpList();
		pp.enterSupName(SupName);
		pp.job_Title();
		pp.enterJobTitle();
		pp.sub_unit();
		pp.enterSubUnit();
		pp.clickOn_Save();
		pp.click_On_addEmp();
		pp.setEmployeefn(userName);
		pp.setEmployeeMN(MiddleNm);
		pp.setEmployeeLN(lastname);
		pp.setEmpID(id);
		pp.clickOnSave();
		pp.enterOnReport();
		pp.enterReportName(reportname);
		pp.click_On_Search();
		pp.clickON_Report();
		pp.click_forLogout();
		pp.click_On_Logout();
	}
	@DataProvider(name="pimTestData")
	public Object[][]getData() throws IOException
	{
		String path="C:\\Users\\Vikas\\eclipse-workspace\\DataDrivenProject\\src\\main\\resources\\excelData\\OrangeHRM.xlsx";
		Utility_1 eUtil=new Utility_1(path);
		int totalRows=eUtil.getRowCount("Sheet2");
		int totalcols=eUtil.getCellCount("Sheet2",1);
		Object data[][]=new Object[totalRows][totalcols];
		for (int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				data[i-1][j]=eUtil.getCellData("Sheet2", i, j);
			}
		}
		return data;
				


	}
	


}
