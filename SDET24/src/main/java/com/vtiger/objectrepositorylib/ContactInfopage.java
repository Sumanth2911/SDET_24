package com.vtiger.objectrepositorylib;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ContactInfopage {
	   
		@FindBy(xpath="//span[contains(text(),'Contact Information')]")
	    private WebElement conNameVerify;
	   
	   public ContactInfopage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getConNameVerify() {
		return conNameVerify;
	}
	   
	}
	


