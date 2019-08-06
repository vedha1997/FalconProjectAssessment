package com.falcon.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.falcon.constants.Constants;
import com.falcon.utils.ReadLocatorsfile;

public class TestBase {
public WebDriver driver;
	Properties baseClass;
	String url;
	String browser;

	@BeforeClass
	public void intitailizeBrowser() throws IOException {
		baseClass = ReadLocatorsfile.loadProperty(Constants.CONFIG_FILE);
		
		url = baseClass.getProperty("URL");
		browser= baseClass.getProperty("chromeBrowser");
		System.out.println("browser is "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_FILE);
		driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_FILE);
			driver = new FirefoxDriver();
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BasicConfigurator.configure();

	}
	
	
	 /* public static void main(String[] args) throws IOException { 
		  BaseClass b = new BaseClass(); 
		  b.intitailizeBrowser(); 
		  
	  }*/
	 
	@AfterClass
	public void endTest()
	{
		/*
		 * driver.close();
		 */		driver.quit();
	}
}
