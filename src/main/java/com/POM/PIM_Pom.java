package com.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class PIM_Pom  extends BaseClass {
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[text()='PIM']")
	private WebElement clickPIM;

	// -----SEARCH EMPLOYEE-------//

	@FindBy(xpath="(//input[contains(@placeholder,'Type')])[1]")private WebElement employeeNm;
	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-o')]")
	private WebElement hint;

	@FindBy(xpath="(//input[contains(@class,'oxd-input oxd-input--active')])[2]")private WebElement empId;

	@FindBy(xpath="(//div[contains(text(),'Select')])[1]")
	private WebElement employmentStatus;
	@FindBy(xpath="(//div[contains(@role,'option')])")
	private List<WebElement>listOfStatus;
	@FindBy(xpath="//div[contains(text(),'Current Employees Only')]")
	private WebElement include;
	@FindBy(xpath="//div[contains(@role,'option')]")
	private List<WebElement>list_Of_Include;
	@FindBy(xpath="(//input[contains(@placeholder,'Type for hints')])[2]")
	private WebElement supervisorNm;
	@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-o')]")
	private WebElement supervisorNmHint;
	@FindBy(xpath="(//div[contains(@class,'oxd-select-text-i')])[3]")
	private WebElement jobTitle;
	@FindBy(xpath="//div[contains(@role,'option')]")
	private List<WebElement>list_Of_jobTitle;
	@FindBy(xpath="(//div[contains(@class,'oxd-select-text-input')])[4]")
	private WebElement subUnit;
	@FindBy(xpath="//div[contains(@role,'option')]")
	private List<WebElement>list_Of_subUnit;
	@FindBy(xpath="(//button[contains(@class,'oxd-button oxd-button--medium oxd-button--seconda')])[1]")
	private WebElement button_Save;


	//---------ADD EMPLOYEE----------------------//
	@FindBy(xpath="(//button[contains(@class,'oxd-button ')])[3]")
	private WebElement addEmp;

	@FindBy(xpath="//input[contains(@name,'firstName')]")private WebElement firstNm;

	@FindBy(xpath="//input[contains(@name,'middleName')]")private WebElement mddleNm;

	@FindBy(xpath="//input[contains(@name,'lastName')]")private WebElement lastNm;

	@FindBy(xpath="(//input[contains(@class,'oxd-inp')])[5]")private WebElement e_Id;

	@FindBy(xpath="//button[contains(@type,'submit')]")private WebElement Click_save;

	//-----------REPORTS------------------------//

	@FindBy(xpath="//li//a[contains(text(),'Reports')]")private WebElement Reports;

	@FindBy(xpath="//input[contains(@placeholder,'Type for hint')]")private WebElement ReportNm;


	@FindBy(xpath="//div/span[contains(text(),'PIM Sample Report')]")private WebElement hint_name;

	@FindBy(xpath="//button[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")private WebElement search;

	@FindBy(xpath="//button[@type='button']//i[@class='oxd-icon bi-file-text-fill']")private WebElement select_report_file;
	@FindBy(xpath="//p[contains(@class,'oxd-userdropdown-name')]")private WebElement clickUser;
	@FindBy(xpath="//a[contains(text(),'Logout')]")private List<WebElement>logout;


	// ---- ACTION METHOD OF -SEARCH EMPLOYEE-------//
	
	public void click_OnPim()
	{
		clickPIM.click();
	}


	public void enterEmployeeNm(String nm)
	{
		//employeeNm.sendKeys(nm);
		Actions act=new Actions(driver);
		act.clickAndHold(employeeNm).sendKeys(nm).perform();
		act.moveToElement(hint).click().perform();

	}
	public void setEmpID(String Id)
	{
		empId.sendKeys(Id);
	}
	public void setEmpStatus() {
		Actions act=new Actions(driver);
		act.clickAndHold(employmentStatus).build().perform();
	}
	public void listOfStatus()
	{
		for(WebElement ele:listOfStatus)
		{
			if(ele.getText().equals("Freelance"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("Full-Time Permanent"))
				{
					ele.click();
					break;
				}
			}


		}
	}
	public void includeEmp()
	{
		Actions act=new Actions(driver);
		act.clickAndHold(include).perform();
	}
	public void includeEmpList()
	{
		for(WebElement ele:list_Of_Include)
		{
			if(ele.getText().equals("Current and Past Employees"))
			{
				ele.click();
				break;
			}
			else
			{
				if(ele.getText().equalsIgnoreCase("Past Employees Only"))
				{
					ele.click();
					break;
				}
			}


		}
		
	}
	
public void enterSupName(String supNm)
{
	Actions act=new Actions(driver);
	act.clickAndHold(supervisorNm).sendKeys(supNm).perform();
	act.moveToElement(supervisorNmHint).click().perform();
}
public void job_Title() {
	Actions act=new Actions(driver);
	act.clickAndHold(jobTitle).perform();
	
}
public void enterJobTitle()
{
	for(WebElement ele:list_Of_jobTitle)
	{
		if(ele.getText().equals("QA Engineer"))
		{
			ele.click();
			break;
		}
		else
		{
			if(ele.getText().equalsIgnoreCase("Software Engineer"))
			{
				ele.click();
				break;
			}
		}


	}
}
public void sub_unit()
{
	Actions act=new Actions(driver);
	act.clickAndHold(subUnit).perform();
}
public void enterSubUnit()
{
	for(WebElement ele:list_Of_subUnit)
	{
		if(ele.getText().equals("OrangeHRM"))
		{
			ele.click();
			break;
		}
		else
		{
			if(ele.getText().equalsIgnoreCase("Quality Assurance"))
			{
				ele.click();
				break;
			}
		}


	}
}
	
	
	public void clickOn_Save()
	{
		button_Save.click();
	}


	//-------ACTION METHODS OF--ADD EMPLOYEE----------------------//
	
	public void click_On_addEmp()
	{
		addEmp.click();
	}

	public void setEmployeefn(String eFNm)
	{
		firstNm.sendKeys(eFNm);
	}
	public void setEmployeeMN(String eMNm)
	{
		mddleNm.sendKeys(eMNm);
	}

	public void setEmployeeLN(String eLNm)
	{
		lastNm.sendKeys(eLNm);
	}
	public void setEmployeeID(String eID)
	{
		e_Id.sendKeys(eID);
	}
	public void clickOnSave() {
		Click_save.click();
	}

	//-ACTION METHOD-OF---------REPORTS------------------------//
	

	public void enterOnReport()
	{
		Reports.click();
	}
	
	public void enterReportName(String RName)
	{
		//ReportNm.sendKeys(RName);
		Actions act=new Actions(driver);
		act.clickAndHold(ReportNm).sendKeys(RName).perform();
		
		act.moveToElement(hint_name).click().perform();
	}
	
	public void click_On_Search() {
		search.click();
	}
	public void clickON_Report()
	{
		select_report_file.click();
	}
	public void click_forLogout()
	{
		//clickUser.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(clickUser));
		Actions act=new Actions(driver);
		act.clickAndHold(clickUser);
		
	}
	public void click_On_Logout()
	{
		for(WebElement ele:logout)
		{
			if(ele.getText().equals("Logout"))
			{
				ele.click();
				break;
			}
			
         }
		
		}

}
