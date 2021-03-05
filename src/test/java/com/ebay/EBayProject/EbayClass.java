package com.ebay.EBayProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EbayClass {
	
	public static WebDriver driver;
	@BeforeSuite
	public static void environmentSetup() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://www.paypal.com");
	}
	
	@Test
	public void testTitle() {
		
		String expectedTitle = "International shopping made easy. This and more with PayPal";
				
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
	}
	
	
	public void verifyPaypalLinkText() {
		WebElement l = driver.findElement(By.linkText("PayPal"));
		l.isDisplayed();
	}
	
	public void tearDown() {
		driver.close();
	}
}
