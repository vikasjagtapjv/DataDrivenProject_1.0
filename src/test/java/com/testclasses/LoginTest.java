package com.testclasses;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.LoginPom;
import com.base.BaseClass;

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
	
}

}
