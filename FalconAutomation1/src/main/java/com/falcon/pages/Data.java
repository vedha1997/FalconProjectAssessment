package com.falcon.pages;

public class Data {

	String TotalTestCases ;
	String TotalTestPass ;
	String TotalTestfail;
	public String getTotalTestCases() {
		return TotalTestCases;
	}
	@Override
	public String toString() {
		return "Data [TotalTestCases=" + TotalTestCases + ", TotalTestPass=" + TotalTestPass + ", TotalTestfail="
				+ TotalTestfail + "]";
	}
	public static  void setTotalTestCases(String TotalTestCases) {
		TotalTestCases = TotalTestCases;
	}
	public String getTotalTestPass() {
		return TotalTestPass;
	}
	public static  void setTotalTestPass(String TotalTestPass) {
		TotalTestPass = TotalTestPass;
	}
	public String getTotalTestfail() {
		return TotalTestfail;
	}
	public static  void setTotalTestfail(String TotalTestfail) {
		TotalTestfail = TotalTestfail;
	}
	
	
	
}
