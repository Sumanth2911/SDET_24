package com.vtiger.objectrepositorylib;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CreateOrganizationsPage {

		@FindBy(name="accountname")
		private WebElement OrgNameTxtfd;
		
		@FindBy(name="industry")
		private WebElement IndDropdown;
		
		@FindBy(name="accounttype")
		private WebElement TypeDropdown;
		
		@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/input[1]")
		private WebElement saveButton;
		
		public CreateOrganizationsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getOrgNameTxtfd() {
			return OrgNameTxtfd;
		}

		public WebElement getIndDropdown() {
			return IndDropdown;
		}

		public WebElement getTypeDropdown() {
			return TypeDropdown;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		
	}

