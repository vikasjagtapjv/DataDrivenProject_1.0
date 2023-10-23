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
		lp.clickOnLogin();

		AdminPom ap=new AdminPom();
		ap.clickOnAdmin();
		ap.setUserNm("Virat");
		ap.clickOnUserRole();
		ap.usersRoles();
		ap.enterEmployeeName("Virat");
		ap.setStatus();
		ap.clickUsersStatus();
		ap.clickOnSearch();
		//add user
		ap.clickOnAddUsers();
		ap.userRole();
		ap.usersAddRoles();
		ap.clickOnStatus();
		ap.addUsersStatus();
		ap.addEmployeeName("Kohli");
		ap.enterUserName("Ronaldo");
		ap.enterPassword("admin1234");
		ap.enterConfirmPassword("admin1234");
		ap.clickOnSaveButton();

	


	}
	


}
