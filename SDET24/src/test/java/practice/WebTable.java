package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericutilities.BaseClass;
import com.vtiger.objectrepositorylib.CreateOrganizationsPage;
import com.vtiger.objectrepositorylib.Homepage;
import com.vtiger.objectrepositorylib.OrganizationsPage;

public class WebTable extends BaseClass{
	@Test
	public void createOrg() throws Exception{
		String orgname =eu.getData("Sheet1", 1, 2)+"_"+ju.getRandomNum();
		
		Homepage hp=new Homepage(driver);
 		hp.getOrganizationsTab().click();
 		
 		//click all checkboxes
 		List<WebElement> all = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
 		for(int i=1;i<all.size();i++)
 		{
 			all.get(i).click();
 			
 		}
 		
 		//uncheck last checkbox
 		all.get(all.size()-1).click();
 		
 		//get text from organizations td
 		List<WebElement> allorgname = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
 		for(int i=1;i<all.size();i++)
 		{
 		   String name=allorgname.get(i).getText();
 		   System.out.println(name);
 		   
 			
 		}
 		
 		//uncheck fifth checkbox
 		
 		all.get(4).click();
 		
	}
}
 		
 		
 	