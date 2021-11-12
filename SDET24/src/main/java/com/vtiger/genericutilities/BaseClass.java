package com.vtiger.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectrepositorylib.Homepage;
import com.vtiger.objectrepositorylib.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public FileUtility fui=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public ExcelUtility eu=new ExcelUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public WebDriver driver;



	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void configBS()
	{
		System.out.println("===connect to Database===");

	}
	//@Parameters(value="BROWSER")		
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void configBC() throws Exception
	{

		String BROWSER =fui.getPropertyKeyValue("browser");
		System.out.println("===launch the browser===");
		if(BROWSER.equals("firefox")){
			
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}
		String url=fui.getPropertyKeyValue("url");

		System.out.println(url);
		driver.get(url);	


	}

	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void configBM() throws Exception
	{
		System.out.println("===Login to application===");
		Loginpage lp=new Loginpage(driver);
		lp.loginToApp();
	}

	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void configAM()
	{
		System.out.println("===Logout of application");
		Homepage hp=new Homepage(driver);
		hp.logOutAppln();
	}

	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void configAC()
	{
		System.out.println("===close the browser===");
		driver.quit();
	}

	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void configAS() throws Exception
	{
		System.out.println("===close the database connection===");

	}

}
