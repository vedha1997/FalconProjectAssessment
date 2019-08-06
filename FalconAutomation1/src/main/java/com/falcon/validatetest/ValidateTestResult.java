package com.falcon.validatetest;

import org.testng.Assert;

import com.falcon.logreports.LogReports;

public class ValidateTestResult {
	static LogReports report = new LogReports();
	public static boolean verifyBoolean(Object actual, Object expected, String message) {
	try {
	Assert.assertEquals(actual, expected);
	report.info("Passed : " + message + ": " + "Actual data : " + actual + " " + "Expected :" + expected);
	return true;
	} catch (AssertionError assertionError) {
	return false;
	}
	}
	}
