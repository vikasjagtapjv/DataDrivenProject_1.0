package com.POM;

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
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	private WebElement admin;


	@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell']//div)[3]")
	private WebElement searchUserName;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement enterUserName;

	@FindBy(xpath="(//div[contains(text(),'-- Select --')])[1]")
	private WebElement searchUserRoll;

	@FindBy(xpath="(//div[@class='oxd-select-option']//span)[1]")
	private WebElement selectAdmin;
	@FindBy(xpath="(//div[@class='oxd-select-option']//span)[2]")
	private WebElement selectEss;

	@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell'])[4]")
	private WebElement eName;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement EmployeeName;
	@FindBy(xpath="(//div[@class='oxd-autocomplete-dropdown --positon-bottom'])[1]")
	private WebElement dropdownHint;

	@FindBy(xpath="//div[contains(text(),'-- Select --')]")
	private WebElement selectStatus;

	@FindBy(xpath="(//div[@class='oxd-select-option']//span)[3]")
	private WebElement selectEnabled;
	@FindBy(xpath="(//div[@class='oxd-select-option']//span)[4]")
	private WebElement selectDisabled;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement search;

	@FindBy(xpath="//i[@class='oxd-icon bi-pencil-fill']")
	private WebElement editUser;

	@FindBy(className="oxd-button oxd-button--medium oxd-button--ghost")
	private WebElement reset;

	@FindBy(xpath="//button[ text()=' Add ']")
	private WebElement add;
	//user role
	@FindBy(xpath="(//div[contains(@class,'oxd-select-text')]//div[text()='-- Select --'])[1]")
	private WebElement UserRole;
	//select adminOption
	@FindBy(xpath="//div[@role='option']//span[text()='Admin']")
	private WebElement adminOption;
	//select ess
	@FindBy(xpath="//div[contains(text(),'ESS')]")
	private WebElement ess;
	//enter status
	@FindBy(xpath="(//div[contains(@class,'oxd-select-text')]//div[text()='-- Select --'])[2]")
	private WebElement status;
	//select enabled
	@FindBy(xpath="//div[contains(@class,'oxd-select-text')]//div[text()='Enabled']")
	private WebElement enabled;
	//select disabled
	@FindBy(xpath="//div[contains(@class,'oxd-select-text')]//div[text()='Disabled']")
	private WebElement disabled;
	//enter eName
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement employeeName;
	//select userName
	@FindBy(xpath="//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	private WebElement userName;
	//enter password
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement Password;
	//confirm password

	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement confirmPassword;
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement clickOnSave;
	//Action method for search user-----
	public void clickOnAdmin ()
	{
		admin.click();
	}
	public String getUserName() {
		return searchUserName.getText();
	}

	public void setUserNm(String sUName) {
		enterUserName.sendKeys(sUName);

	}
	//			public String getUserRole()
	//			{
	//				return textEss.getText();
	//			}
	public void clickOnUserRole()
	{
		searchUserRoll.click();	
	}
	public void click_On_Admin() {

		selectAdmin.click();
	}
	public void click_On_Ess() {
		selectEss.click();
	}

	public String getEmployeeName()
	{
		return eName.getText();
	}
	public void setEmployeeName(String EName)
	{
		EmployeeName.sendKeys(EName);
	}

	//			public String getStatus()
	//			{
	//				return sEnabled.getText();
	//			}
	public void setStatus()
	{
		selectStatus.click();
	}

	public void click_On_Enabled()
	{
		selectEnabled.click();
	}
	public void click_On_Disabled()
	{
		selectDisabled.click();
	}
	public void clickOnSearch()
	{
		search.click();
	}
	public void clickOnEdit()
	{
		editUser.click();
	}
	public void reset() {
		reset.click();

	}
	//Action method for add user


	public void clickOnAddUsers() {
		add.click();
	}
	public void userRole()
	{
		Actions act=new Actions(driver);
		act.clickAndHold(UserRole);

	}
	public void AdminSelect()
	{
		adminOption.click();
	}
	public void Ess()
	{
		ess.click();
	}
	public void clickOnStatus()
	{
		Actions act=new Actions(driver);
		act.clickAndHold(status);

	}
	public void getEnabled()
	{
		enabled.click();
	}
	public String getdisbled()
	{
		return disabled.getText();
	}
	public void enterEmployeeNameHint(String hintName)

	{

		employeeName.sendKeys(hintName);
		explicitWait(hintName);
	}
	public void enterUserName(String UserN) {
		userName.sendKeys(UserN);
		explicitWait(UserN);
	}
	public void enterPassword(String pass)
	{
		Password.sendKeys(pass);
		explicitWait(pass);

	}
	public void enterConfirmPassword(String confirmPass)
	{
		confirmPassword.sendKeys(confirmPass);
	}
	public void clickOnSaveButton()
	{
		clickOnSave.click();


	}

}
