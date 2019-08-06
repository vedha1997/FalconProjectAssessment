package com.falcon.testscripts.viewpage;

import java.io.File;

import org.testng.annotations.Test;

import com.falcon.utils.Utils;

public class Try extends ViewPageTest {
	static String user = "user.dir" + File.separator +  "Downloads";
	
	public static void main(String[] args) {
		System.out.println(user);
	}
}