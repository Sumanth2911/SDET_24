
		
package com.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

  
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgNameVerify;
	
	
	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}
	
}
