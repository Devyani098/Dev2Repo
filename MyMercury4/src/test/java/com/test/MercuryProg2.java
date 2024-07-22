package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryProg2 
{
	WebDriver driver;
	
	@BeforeSuite
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\CJC\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void enterURL()
	{
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	
	@BeforeClass
	public void maximizebrowser()
	{
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void getCookies()
	{
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Cookie size : "+cookies.size());
	}
	
	@Test
	public void login()
	{
		driver.findElement(By.name("userName")).sendKeys("Devyani");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		//driver.findElement(By.linkText("SIGN-OFF")).click();
		System.out.println("Test Pull");
	}
	
	@Test
	public void register()
	{
		//driver.navigate().back();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Devyani");
		driver.findElement(By.name("lastName")).sendKeys("Test");
		driver.findElement(By.name("phone")).sendKeys("3287446813");
		driver.findElement(By.name("userName")).sendKeys("devyani@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Pune");
		driver.findElement(By.name("city")).sendKeys("Pune");
		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.name("postalCode")).sendKeys("563778");
		
		Select s=new Select(driver.findElement(By.name("country")));
		s.selectByValue("ANTARCTICA");
		
		driver.findElement(By.name("email")).sendKeys("devyani@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
	}
	
	@AfterMethod
	public void captureScreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("D:\\CJC\\Selenium\\SS\\TestNG"));
	}
	
	@AfterClass
	public void deleteCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void dbclose()
	{
		System.out.println("Database closed");
	}
	
	@AfterSuite
	public void closebrowser()
	{
		driver.close();
	}
}
