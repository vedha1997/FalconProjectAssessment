package com.falcon.testscripts.viewpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.falcon.constants.Constants;
import com.falcon.logreports.LogReports;
import com.falcon.pages.View;
import com.falcon.testbase.TestBase;
import com.falcon.utils.ReadLocatorsfile;
import com.falcon.utils.Utils;
import com.falcon.validatetest.ValidateTestResult;

public class SortingTestCaseName extends TestBase{
	ViewPageTest obj = new ViewPageTest();
	LogReports log = new LogReports();


	View viewpage = new View();

	List<String> name;
	List<String> name1;
	List<String> name2;
	/*
	 * public void listSort() { List<String> name= new ArrayList<String>();
	 * List<WebElement> list =
	 * driver.findElements(By.xpath("//td[@data-title-text = 'Test Case Name']"));
	 * for(WebElement element : list) { name.add(element.getText()); }
	 * Collections.sort(name); System.out.println(name.toString()); }
	 */

	@Test
	public void sortTestCaseNames() throws InterruptedException, Exception{
		
		Properties prop = ReadLocatorsfile.loadProperty(Constants.VIEW_FILE);
		obj.page = prop.getProperty("viewPage");
		obj.listOfTestCaseNames = prop.getProperty("listOfTestCaseNames");
		obj.clickTestCaseNames = prop.getProperty("clickTestCaseNames");
		obj.getTheNumberOfTestCases = prop.getProperty("getTheNumberOfTestCases");
		/*performing without clicking the testcasenames
		 * 
		 */
		Utils.ignoreClickInterceptAndClickOnElement(driver, obj.page);//clicking view page
		Thread.sleep(1000);
		/*
		 * name= new ArrayList<String>(); List<WebElement> list =
		 * driver.findElements(By.xpath(listOfTestCaseNames));//list of test cases
		 * for(WebElement element : list) { name.add(element.getText()); }
		 */

		name = viewpage.getAllProductList(driver);

		Collections.sort(name); 
		System.out.println(name.toString());
		Utils.ignoreClickInterceptAndClickOnElement(driver, obj.clickTestCaseNames);//clicking page
		name1 = viewpage.getAllProductList(driver);
		System.out.println(name1.toString());
		ValidateTestResult.verifyBoolean(name1, name, "The sorting passed");
		log.info("The first sorting passed");
		Utils.ignoreClickInterceptAndClickOnElement(driver, obj.clickTestCaseNames);
		name2 = viewpage.getAllProductList(driver);	
		ValidateTestResult.verifyBoolean(name, name2, "The sorting passed");
		log.info("The second sorting passed");
	}
	
}
//In the above i am sorting two things
		//before clicking testcasenames the order was 	ascending so i am sorting and comparing with ascending order after clicking the test case name button
		//i am sorting the before clicking with clicking testcasenames 2 times 

		

		/*The  name holds the list of testcasenames
		 * 
		 */

		/*Clicking again to get the ascending list
		 * 
		 */
		//Utils.ignoreClickInterceptAndClickOnElement(driver, clickTestCaseNames);//clicking page
		//Thread.sleep(1000);
		/*
		 * name1= new ArrayList<String>(); List<WebElement> list1 =
		 * driver.findElements(By.xpath(getTheNumberOfTestCases)); for(WebElement
		 * element : list1) { name1.add(element.getText()); }
		 */
		//		Collections.sort(name1);
		/*
		 * name1 = viewpage.getAllProductList(driver);
		 * System.out.println(name1.toString());
		 */

		/*clicking again to get the descending list
		 * 
		 */
		/*
		 * Utils.ignoreClickInterceptAndClickOnElement(driver, clickTestCaseNames);
		 * Thread.sleep(1000); List<String> name2= new ArrayList<String>();
		 * List<WebElement> list2 =
		 * driver.findElements(By.xpath(getTheNumberOfTestCases)); for(WebElement
		 * element : list2) { name2.add(element.getText()); } //Collections.sort(name2);
		 * System.out.println(name2.toString());
		 * 
		 * //ValidateTestResult.verifyBoolean(name, name1, "passed");
		 * Collections.reverse(name); //System.out.println("name +"+name);
		 * //System.out.println("name1 +"+name1); Assert.assertTrue(name.equals(name1));
		 * ValidateTestResult.verifyBoolean(name2, name1, "passed");
		 * Collections.reverse(name2); //System.out.println(name2 + "name2  ");
		 * Assert.assertTrue(name2.equals(name1));//asserting the list
		 */
	


