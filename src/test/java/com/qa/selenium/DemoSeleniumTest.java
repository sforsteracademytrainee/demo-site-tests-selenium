package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.utils.Cfg;

public class DemoSeleniumTest {
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	public void test_TheDemoSite_AddUser() throws InterruptedException {
		driver.get("https://www.thedemosite.co.uk");
		WebElement targ = driver.findElement(By.xpath("//small/a[3]")); // add a user button
		targ.click();
		targ = driver.findElement(By.name("username"));
		targ.sendKeys("guest");
		targ = driver.findElement(By.name("password"));
		targ.sendKeys("guest");
		targ = driver.findElement(By.name("FormsButton2"));
		targ.click();
		targ = driver.findElement(By.xpath("//blockquote/blockquote/blockquote"));
		assertEquals("The username: guest\nThe password: guest", targ.getText());
	}
	
	@Test
	public void test_TheDemoSite_Login() throws InterruptedException {
		driver.get("https://www.thedemosite.co.uk");
		WebElement targ = driver.findElement(By.xpath("//small/a[4]")); // log in button
		targ.click();
		targ = driver.findElement(By.name("username"));
		targ.sendKeys("guest");
		targ = driver.findElement(By.name("password"));
		targ.sendKeys("guest");
		targ = driver.findElement(By.name("FormsButton2"));
		targ.click();
		targ = driver.findElement(By.xpath("//big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", targ.getText());
	}
	
	@Test
	public void test_AutoSite() throws InterruptedException{
		driver.get("http://www.automationpractice.com/index.php?id_category=5&controller=category");
		Thread.sleep(1000);
		WebElement targ = driver.findElement(By.className("left-block"));
		targ.click();
		
		Thread.sleep(5000);
	}
	
	
	@AfterAll
	public static void cleanUp() {
		driver.quit();	
		System.out.println("The Selenium driver has been cleaned up.");
	}
}
