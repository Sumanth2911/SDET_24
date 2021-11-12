package com.vtiger.objectrepositorylib;
 import org.openqa.selenium.WebDriver;
	 import org.openqa.selenium.WebElement;
	 import org.openqa.selenium.support.FindBy;
	 import org.openqa.selenium.support.PageFactory;
	 

	 public class CreateContactspage {
	    
	 	@FindBy(xpath="//img[@alt='Create Contact...']")
	 	private WebElement createContactButton;
	 	
	 	@FindBy(name="lastname")
	 	private WebElement lastNametxtfd;
	 	
	 	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	 	private WebElement orgNamelookup;

	 	public WebElement getSaveButton() {
	 		return saveButton;
	 	}

	 	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/input[1]")
	 	private WebElement saveButton;
	 	
	 	public CreateContactspage(WebDriver driver)
	 	{
	 		PageFactory.initElements(driver, this);
	 	}

	 	public WebElement getCreateContactButton() {
	 		return createContactButton;
	 	}

	 	public WebElement getLastNametxtfd() {
	 		return lastNametxtfd;
	 	}

	 	public WebElement getOrgNamelookup() {
	 		return orgNamelookup;
	 	}
	 	
	 }

