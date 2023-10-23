package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AdminPom extends BaseClass {
	{
		PageFactory.initElements(driver,this);
	}

	//click on admin
	@FindBy(xpath="(//span[contains(@class,'oxd-text')])[1]")
	private WebElement admin;

	//------------------------SEARCH USER------------------------

	@FindBy(xpath="(//input[contains(@class,'oxd-input')])[2]")
	private WebElement searchUserName;

	@FindBy(xpath="(//div[contains(text(),'Select')])[1]")
	private WebElement searchUserRole;

	@FindBy(xpath="(//div[contains(@role,'option')])")
	private List<WebElement>userRoles;

	@FindBy(xpath="//input[contains(@placeholder,'Type')]")
	private WebElement eName;

	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-o')]")
	private WebElement hint;

	@FindBy(xpath="(//div[contains(@class,'oxd-select-text-input')])[2]")
	private WebElement selectStatus;

	@FindBy(xpath="(//div[contains(@role,'option')])")
	private List<WebElement>userStatus;

	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement search;

	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement reset;


	//__________---------Add User---------------

	//click on add user
	@FindBy(xpath="(//button[contains(@class,'oxd-button ')])[3]")
	private WebElement add;
	//user role
	@FindBy(xpath="(//div[contains(text(),'Select')])[1]")
	private WebElement UserRole;
	@FindBy(xpath="//div[contains(@role,'option')]")
	private List<WebElement>addUserRoles;
	//enter status
	@FindBy(xpath="(//div[contains(@class,'oxd-select-text-input')])[2]")
	private WebElement selectAddUserStatus;

	@FindBy(xpath="(//div[contains(@role,'option')])")
	private List<WebElement>userAddStatus;
	@FindBy(xpath="//input[contains(@placeholder,'Type')]")
	private WebElement eAddName;

	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-o')]")
	private WebElement addHint;
	//select userName
	@FindBy(xpath="(//input[contains(@class,'oxd-input')])[2]")
	private WebElement addUserName;
	//enter password
	@FindBy(xpath="(//input[contains(@type,'password')])[1]")
	private WebElement Password;
	//confirm password
	@FindBy(xpath="(//input[contains(@type,'password')])[2]")
	private WebElement confirmPassword ;
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement addSave;



	//Action method for search user-----
	public void clickOnAdmin()
	{
		admin.click();
	}


	public void setUserNm(String sUName)
	{
		searchUserName.sendKeys(sUName);

	}


	public void clickOnUserRole()
	{
		//searchUserRole.click();
		Actions act=new Actions(driver);
		act.clickAndHold(searchUserRole).build().perform();

	}
	public void usersRoles()
	{
		for(WebElement ele:userStatus)
		{
			if(ele.getText().equals("Admin"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("ESS"))
				{
					ele.click();
					break;
				}
			}


		}

	}

	public void enterEmployeeName(String EName)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(eName).sendKeys(EName).perform();
		act.moveToElement(hint).click().perform();
		//act.click(hint).perform();
	}

	public void setStatus()
	{
		//selectStatus.click();
		Actions act=new Actions(driver);
		act.clickAndHold(selectStatus).perform();

	}

	public void clickUsersStatus()
	{
		for(WebElement ele:userRoles)
		{
			if(ele.getText().equals("Enabled"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("Disabled"))
				{
					ele.click();
					break;
				}
			}


		}


	}

	public void clickOnSearch()
	{
		search.click();
	}

	public void reset() {
		reset.click();

	}
	//Action method for add user


	public void clickOnAddUsers(){
		add.click();
	}
	public void userRole()
	{
		//UserRole.click();
		Actions act=new Actions(driver);
		act.clickAndHold(UserRole).build().perform();
	}
	public void usersAddRoles()
	{
		for(WebElement ele:addUserRoles)
		{
			if(ele.getText().equals("Admin"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("ESS"))
				{
					ele.click();
					break;
				}
			}


		}

	}
	public void clickOnStatus()
	{
		//selectAddUserStatus.click();
		Actions act=new Actions(driver);
		act.clickAndHold(selectAddUserStatus).perform();

	}
	public void addUsersStatus()
	{
		for(WebElement ele:userAddStatus)
		{
			if(ele.getText().equals("Enabled"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("Disabled"))
				{
					ele.click();
					break;
				}
			}


		}


	}

	public void addEmployeeName(String hintName)
	{
		//eAddName.sendKeys(hintName);
		Actions act=new Actions(driver);
		act.clickAndHold(eAddName).sendKeys(hintName).perform();
		act.moveToElement(addHint).click().perform();
	}
	public void enterUserName(String UserN) {
		addUserName.sendKeys(UserN);
	}

	public void enterPassword(String pass)
	{
		//Password.sendKeys(pass);
		Actions act=new Actions(driver);
		act.clickAndHold(Password).sendKeys(pass).perform();
	}
	public void enterConfirmPassword(String confirmPass)
	{
		//confirmPassword.sendKeys(confirmPass);
		Actions act=new Actions(driver);
		act.clickAndHold(confirmPassword).sendKeys(confirmPass).perform();
	}

	public void clickOnSaveButton()
	{
		addSave.click();
	} 




}
