package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPom extends BaseClass {
	//Object Block created
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Username : Admin']")
	private WebElement username;
	@FindBy(xpath="//input[@name='username']")
	private WebElement Name;
	@FindBy(xpath="//p[text()='Password : admin123']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='password']")
	 private WebElement Pass;
	@FindBy(xpath="//button[text()=' Login ']")
	 private WebElement button;
	
	@FindBy(xpath="//p[text()='Forgot Your Password? ']")
	private WebElement forgetPass;
	
	
	public String getUserName()
	{
		String uName=username.getText();
		return uName.substring(uName.indexOf(':'),uName.length()-1);
		
	}
	public String getPass()
	{
		String pass=password.getText();
		return pass.substring(pass.indexOf(':'));
	}
	public void setUserN(String name)
	{
		Name.sendKeys(name);
	}
	public void setPass(String password)
	{
		Pass.sendKeys(password);
	}
	public void click()
	{
		button.click();
	}

}
