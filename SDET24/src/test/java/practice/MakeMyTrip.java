package practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
 
	@Test
	public void bookticket() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com");;
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	driver.findElement(By.className("langCardClose")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@for='fromCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumb");
	driver.findElement(By.xpath("//p[contains(text(),'Mum')]")).click();
	try{driver.findElement(By.xpath("//label[@for='toCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
	driver.findElement(By.xpath("//p[contains(text(),'Delhi')]")).click();}
	catch (Exception e) {
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//p[contains(text(),'Delhi')]")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		Date dateobj=new Date();
		String todaydate= dateobj.toString();
		String[] s=todaydate.split(" ");
		String day= s[0];
		String month= s[1];
		String date= s[2];
		String year= s[5];
		
		String xpathDate= day +" "+ month +" "+ date + " "+ year;
		driver.findElement(By.xpath("//div[@aria-label = '"+xpathDate+"']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath(("//div[@aria-label='Mon Jan 17 2022']"))).click();
		
		
	}
	
	
	
}
}