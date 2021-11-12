package com_pom_vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericutilities.ExcelUtility;
import com.vtiger.genericutilities.FileUtility;
import com.vtiger.genericutilities.JavaUtility;
import com.vtiger.genericutilities.WebDriverUtility;
import com.vtiger.objectrepositorylib.ContactChildPopuppage;
import com.vtiger.objectrepositorylib.ContactInfopage;
import com.vtiger.objectrepositorylib.Contactspage;
import com.vtiger.objectrepositorylib.CreateContactspage;
import com.vtiger.objectrepositorylib.CreateOrganizationsPage;
import com.vtiger.objectrepositorylib.Homepage;
import com.vtiger.objectrepositorylib.Loginpage;
import com.vtiger.objectrepositorylib.OrganizationsInfoPage;
import com.vtiger.objectrepositorylib.OrganizationsPage;

public class CreateContactWithOrgTest {
     @Test
     public void createContact()throws Exception
     {
        FileUtility fui=new FileUtility();
 	  	JavaUtility ju=new JavaUtility();
 	  	ExcelUtility eu=new ExcelUtility();
 	    WebDriverUtility wu= new WebDriverUtility();

 	
 	  	String orgname =eu.getData("Sheet1", 1, 2)+"_"+ju.getRandomNum();
     	String conname=eu.getData("Sheet1", 1, 3)+"_"+ju.getRandomNum();
     	String BROWSER =fui.getPropertyKeyValue("browser");
     	String industryName=eu.getData("Sheet1", 1, 4);
     	String typeName=eu.getData("Sheet1", 1, 5);
     	WebDriver driver=null;
 		if(BROWSER.equals("firefox")){
 			driver=new FirefoxDriver();
 		}else if(BROWSER.equals("chrome")){
 			driver=new ChromeDriver();
 		}
 		
 		Loginpage lp=new Loginpage(driver);
 		lp.loginToApp();
 		
 		Homepage hp=new Homepage(driver);
 		hp.getOrganizationsTab().click();
 		
 		OrganizationsPage op=new OrganizationsPage(driver);
 		op.getCreateOrgButton().click();
 		
 	    CreateOrganizationsPage c1= new CreateOrganizationsPage(driver);
 		c1.getOrgNameTxtfd().sendKeys(orgname);
 		WebElement ind = c1.getIndDropdown();
 		
 	    wu.select(c1.getIndDropdown(),industryName);
 	    wu.select(c1.getTypeDropdown(),typeName);
 	    
 	    c1.getSaveButton().click();
 	    Thread.sleep(3000);
 	    OrganizationsInfoPage oip= new OrganizationsInfoPage(driver);
 	    if((oip.getOrgNameVerify().getText()).contains(orgname))
 	    {
 	    	System.out.println("organization is created===>pass");
 	    }else{
 	    	System.out.println("organization is not created===>fail");
 	    }
 	    
 	    wu.waitForElementVisibility(driver, hp.getContactsTab());
 	    hp.getContactsTab().click();
 	    
 	    Contactspage cp= new Contactspage(driver);
 	    cp.getCreateContactButton().click();
 	    
 	    CreateContactspage ccp=new CreateContactspage(driver);
 	    ccp.getLastNametxtfd().sendKeys(conname);
 	    ccp.getOrgNamelookup().click();
 	    
 	    wu.switchToWindow(driver, "Accounts&action");
 	    ContactChildPopuppage ccpg=new ContactChildPopuppage(driver);
 	    ccpg.getSearchTxtfd().sendKeys(orgname);
 	    ccpg.getSerachBtn().click();
 	    driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
 	    
 	    wu.switchToWindow(driver, "Contacts&action");
 	    ccp.getSaveButton().click();
 	    
 	    ContactInfopage cip=new ContactInfopage(driver);
 	    if((cip.getConNameVerify().getText()).contains(conname))
 	    {
 	    	System.out.println(conname+" is created===>pass");
 	    }else{
 	    	System.out.println(conname+" is not created===>failed");
 	    }
 	    
 	    hp.logOutAppln();
 	
 	driver.close();
     }
}