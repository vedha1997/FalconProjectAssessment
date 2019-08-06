package com.falcon.testscripts.viewpage;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.falcon.constants.Constants;
import com.falcon.pages.Data;
import com.falcon.pages.Help;
import com.falcon.pages.View;
import com.falcon.testbase.TestBase;
import com.falcon.utils.ReadLocatorsfile;
import com.falcon.utils.Utils;
import com.falcon.validatetest.ValidateTestResult;

//need to check testng is not invoking
public class ExportFile extends TestBase {
	
	ViewPageTest obj = new ViewPageTest();
	
	View view = new View();
	Help help = new Help();
	String downloadClick;
	String checkDownloadString;
	String expectedFile = "TestReport-REST API TEST RESULT-Web Services-08-05-2019.xlsx";
	String expectedValidation = "Constants.DOWNLOADFILE+expectedFile";

	@Test
	public void verifyDownload() throws IOException, Exception {// String dirPath
		Properties prop = ReadLocatorsfile.loadProperty(Constants.VIEW_FILE);

		obj.page = prop.getProperty("viewPage");
		downloadClick = prop.getProperty("downloadClick");
		checkDownloadString = prop.getProperty("checkDownloadString");

		Utils.ignoreClickInterceptAndClickOnElement(driver, obj.page);
		Utils.ignoreClickInterceptAndClickOnElement(driver, downloadClick);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath(checkDownloadString)).isDisplayed(),
				"Downloading report, please wait.. is shown in the page");
		view.file(Constants.DOWNLOADFILE, expectedValidation);
		//getTotalTestXlCount();
		 help.getXLFileData(8, 1, 0,Constants.DOWNLOADFILE+"TestReports.xlsx","Total testcounts",10,"Passed for total testcases");
	 	help.getXLFileData(9, 1, 0, Constants.DOWNLOADFILE+"TestReports.xlsx","pass testcounts",9,"Passed for total pass testcases");
		 help.getXLFileData(10, 1, 0, Constants.DOWNLOADFILE+"TestReports.xlsx","fail testcounts",1,"Passed for total fail testcases");
	}
	//C:\\Users\\Vedha.Venkataraman\\Downloads\\TestReports.xlsx
	/*
	 * public void getTotalTestXlCount() { help.getXLFileData(8, 1, 0,
	 * "C:\\Users\\Vedha.Venkataraman\\Downloads\\TestReports.xlsx"); }
	 */
	
	
	}
