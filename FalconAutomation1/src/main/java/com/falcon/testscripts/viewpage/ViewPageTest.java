package com.falcon.testscripts.viewpage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.falcon.constants.Constants;
import com.falcon.logreports.LogReports;
import com.falcon.pages.Help;
import com.falcon.testbase.TestBase;
import com.falcon.utils.ReadLocatorsfile;
import com.falcon.utils.Utils;
import com.falcon.validatetest.ValidateTestResult;

public class ViewPageTest extends TestBase {
	Help help = new Help();

	LogReports log = new LogReports();
	
	  String customerName;
	 String moduleName; 
	 String status; 
	 static String page;
	  String testCaseName; int passTests; int failTests; int skipTests; static
	  String listOfTestCaseNames;
	  //getting xpath of resentruns page ;
	  List<String> name3; String viewPass; String clickDashBoardToggle; static
	 String viewFail; static String clickTestCaseNames; static String
	  getTheNumberOfTestCases;
	 
	/*
	 * public static void main(String[] args) { Help help = new Help();
	 * System.out.println(help.page); }
	 */ 
	@Test(priority=1)
	public  void getPassTestResults() throws IOException, InterruptedException {
		
		  Properties prop = ReadLocatorsfile.loadProperty(Constants.VIEW_FILE);
		  String recenRunPage= 
			 prop.getProperty("recenRunPage"); 
		  page = prop.getProperty("viewPage"); customerName =
		  prop.getProperty("customerName"); moduleName =
		  prop.getProperty("moduleName"); status = prop.getProperty("testStatus");	   
		  viewPass =prop.getProperty("viewPass"); listOfTestCaseNames =
		  prop.getProperty("listOfTestCaseNames"); clickTestCaseNames =
		  prop.getProperty("clickTestCaseNames"); getTheNumberOfTestCases =
		  prop.getProperty("getTheNumberOfTestCases");
		 
		Utils.ignoreClickInterceptAndClickOnElement(driver,page);
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, customerName, "Falcon");
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, moduleName, "createFalconPosts");
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, status, "Pass");

		List<WebElement> element = driver.findElements(By.xpath(viewPass));//viewPass
		passTests = element.size();
		log.info("pass Tests are" + passTests);
		ValidateTestResult.verifyBoolean(passTests, 9, "the pass tests  match the actual results");
		//Assert.assertEquals(passTests, 9, "the pass tests  match the actual results");
		log.info("The pass test is matching the actual results");
	}
	@Test(priority=2)
	public void getFailTestResults() throws IOException, InterruptedException {
		Properties prop = ReadLocatorsfile.loadProperty(Constants.VIEW_FILE);
		page = prop.getProperty("viewPage");
		status = prop.getProperty("testStatus");
		viewFail = prop.getProperty("viewfail");
		Utils.ignoreClickInterceptAndClickOnElement(driver,page);
     	Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, status,"Fail");
		List<WebElement> failTestList = driver.findElements(By.xpath(viewFail));//viewFail
		failTests = failTestList.size();
		log.info("failed Tests are" + failTests);
		ValidateTestResult.verifyBoolean(failTests, 1, "the pass tests  match the actual results");
		//Assert.assertEquals(failTests, 1, "the fail tests does not match the actual results");
		log.info("The fail test is matching the actual results");
	}
	//@Test(priority=3)
	public void getSkippedTestResults(){
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, status, "Skip");
		//yet to find logic it is empty
	}
	

}
