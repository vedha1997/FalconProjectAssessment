package com.falcon.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.falcon.constants.Constants;
import com.falcon.logreports.LogReports;
import com.falcon.utils.ReadLocatorsfile;
import com.falcon.validatetest.ValidateTestResult;

import jdk.internal.org.jline.utils.Log;

public class Help {
	Data data = new Data();
	String customerName;
	String moduleName;
	String status;
	public   static String page;
	String testCaseName;
	int passTests;
	int failTests;
	int skipTests;
	static String listOfTestCaseNames;
	String recenRunPage; //= prop.getProperty("recenRunPage");//getting xpath of resentruns page	;
	List<String> name3;
	String viewPass; 
	String	clickDashBoardToggle;
	static String viewFail; 
	static String clickTestCaseNames;
	static String getTheNumberOfTestCases;

	LogReports log = new LogReports();
	
	public  String getPropertiess() throws Exception {
		Properties prop = ReadLocatorsfile.loadProperty(Constants.VIEW_FILE);

		page = prop.getProperty("viewPage");
		customerName = prop.getProperty("customerName");
		moduleName = prop.getProperty("moduleName");
		status = prop.getProperty("testStatus");
		viewFail = prop.getProperty("viewfail");
		viewPass = prop.getProperty("viewPass");
		listOfTestCaseNames = prop.getProperty("listOfTestCaseNames");
		clickTestCaseNames = prop.getProperty("clickTestCaseNames");
		getTheNumberOfTestCases = prop.getProperty("getTheNumberOfTestCases");
		System.out.println(page);
		return page;


	}
	String xlsxPath = "";
	String path = "";
	public FileInputStream xfis;
	public XSSFWorkbook wb ;
	XSSFSheet sheet1;
	public String Counts ;//Constants.DOWNLOADFILE
	String TotalTestPass;
	String TotalTestfail;


	//@DataProvider(name = "xldata")
	public File getXLFileData(int row,int cell,int sheetnum,String path,String loginfo,int expected,String message) {//int row,int cell,int sheetnum,String path
		try {

			xfis = new FileInputStream(path);
			wb = new XSSFWorkbook(xfis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet1 = wb.getSheetAt(sheetnum);
		Counts = sheet1.getRow(row).getCell(cell).getStringCellValue();
		String 	getCounts = Counts;
		log.info(loginfo  + getCounts);
		ValidateTestResult.verifyBoolean(getCounts, expected, message);
		//System.out.println(getCounts);
		
		return null;
	}
	
	

}
		