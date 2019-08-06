package com.falcon.constants;

import java.io.File;

public class Constants {

	public final static String USER_HOME= System.getProperty("user.dir") + File.separator;
	public final static String VIEW_HOME= USER_HOME + "Resources"+File.separator+"locators"+ File.separator;
	public final static String VIEW_FILE=VIEW_HOME+"view.properties";
	
	public final static String CONFIG_HOME= USER_HOME + "Resources" +File.separator; 
	public final static String CONFIG_FILE= CONFIG_HOME+ "config.properties";
	
	public final static String CHROME_HOME = USER_HOME + "lib"+File.separator;
	public final static String CHROME_FILE = CHROME_HOME + "chromedriver.exe";
	
	public final static String FIREFOX_HOME = USER_HOME + "lib"+File.separator;
	public final static String FIREFOX_FILE = FIREFOX_HOME +"geckodriver.exe";
	
	public final static String LOG4J_HOME = USER_HOME + "Resources"+File.separator;
	public final static String  LOG4J_FILE = LOG4J_HOME +"log4j.properties";
	public final static String DOWNLOADFILE =("C:"+File.separator+"Users" +File.separator+System.getProperty("user.name")+File.separator+"Downloads"+File.separator);
			
	
			
	static String Test_Data_File =   LOG4J_FILE;
	public static void main(String[] args) {
		System.out.println(DOWNLOADFILE);
	}
	

}
