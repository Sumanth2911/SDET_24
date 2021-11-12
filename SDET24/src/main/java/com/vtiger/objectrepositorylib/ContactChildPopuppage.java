package com.vtiger.objectrepositorylib;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ContactChildPopuppage {
	   
		@FindBy(xpath="//input[@name='search_text']")
		private WebElement searchTxtfd;
		
		@FindBy(xpath="//input[@name='search']")
		private WebElement serachBtn;
		
		public ContactChildPopuppage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getSearchTxtfd() {
			return searchTxtfd;
		}

		public WebElement getSerachBtn() {
			return serachBtn;
		}
		
	}

