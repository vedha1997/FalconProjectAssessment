package com.falcon.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.falcon.constants.Constants;

public class ReadLocatorsfile {

	static Properties properties;
	static FileReader reader;
    static 	File file;
	public static Properties loadProperty(String filePath) throws IOException {
		properties = new Properties();
		 file = new File(filePath);
	   reader  = new FileReader(file);
       properties.load(reader);
       return properties;
	}
	
	
	public static String getData(String data) throws IOException {
	
		String filedata = properties.getProperty(data);
		return filedata;
		
	}
/*public static void main(String[] args) throws IOException {
	Properties prop =loadProperty(Constants.LOCATORS_FILE);
	System.out.println(prop.getProperty("customerName"));
		String customer= getData("customerName");
		System.out.println("name is "+customer);
	}
*/

}
