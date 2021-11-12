package com.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutilities.FileUtility;

public class Loginpage{
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="user_name")
	private WebElement usernameTxtfd;

	@FindBy(name="user_password")
	private WebElement userPasswordtxtfd;



	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//[@id='submitButton']")})
	private  WebElement loginbtn;



	public WebElement getUsernameTxtfd() {
		return usernameTxtfd;
	}



	public WebElement getUserPasswordtxtfd() {
		return userPasswordtxtfd;
	}



	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public void loginToApp() throws Exception
	{
		FileUtility fis= new FileUtility();
		String userName = fis.getPropertyKeyValue("un");
		String password=fis.getPropertyKeyValue("pw"); 	   	
		usernameTxtfd.sendKeys(userName);
		userPasswordtxtfd.sendKeys(password);
		loginbtn.click();
	}




}
