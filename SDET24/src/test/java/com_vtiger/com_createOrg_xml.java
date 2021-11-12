package com_vtiger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class com_createOrg_xml {
	@Test
	public void sample(XmlTest xml) {
		
		Random r = new Random();
		int range = r.nextInt(100);

		String url = xml.getParameter("url");
		String browser=xml.getParameter("browser");
		String username = xml.getParameter("username");
		String password = xml.getParameter("password");
		String name =xml.getParameter("name");
		WebDriver driver =null;
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
			
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name +"_"+range);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String act = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(act);
		
		if (act.contains(name)) {
			System.out.println(name + " organization is created");
		} else {
			System.out.println(name + " organization is not created");
		}

		driver.close();

	}

}
