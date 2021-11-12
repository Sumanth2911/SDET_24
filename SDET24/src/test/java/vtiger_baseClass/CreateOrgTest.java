package vtiger_baseClass;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericutilities.BaseClass;
import com.vtiger.objectrepositorylib.CreateOrganizationsPage;
import com.vtiger.objectrepositorylib.Homepage;
import com.vtiger.objectrepositorylib.OrganizationsInfoPage;
import com.vtiger.objectrepositorylib.OrganizationsPage;

public class CreateOrgTest extends BaseClass{
	
	@Test(groups="SmokeTest")
	public void createOrg() throws Exception{
		String orgname =eu.getData("Sheet1", 1, 2)+"_"+ju.getRandomNum();
		
		Homepage hp=new Homepage(driver);
 		hp.getOrganizationsTab().click();
 		
 		
 		OrganizationsPage op=new OrganizationsPage(driver);
 		op.getCreateOrgButton().click();
 		
 		CreateOrganizationsPage c1= new CreateOrganizationsPage(driver);
 		c1.getOrgNameTxtfd().sendKeys(orgname);
 	    
 	    c1.getSaveButton().click();
 	    Thread.sleep(3000);
 	    OrganizationsInfoPage oip= new OrganizationsInfoPage(driver);
 	    if((oip.getOrgNameVerify().getText()).contains(orgname))
 	    {
 	    	System.out.println("organization is created===>pass");
 	    }else{
 	    	System.out.println("organization is not created===>fail");
 	    }
 	    
 		
		
	}



@Test(groups="RegressionTest")
public void OrgWithIndustries() throws Exception{
	String orgname =eu.getData("Sheet1", 1, 2)+"_"+ju.getRandomNum();
	String industryName=eu.getData("Sheet1", 1, 4);
	String typeName=eu.getData("Sheet1", 1, 5);
	
		
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
}
}    

