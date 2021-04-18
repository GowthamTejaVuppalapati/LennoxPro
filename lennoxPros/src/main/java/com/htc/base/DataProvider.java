package com.htc.base;

import java.lang.reflect.Method;

import com.htc.dataReader.ExcelFileManager;

public class DataProvider {

	@org.testng.annotations.DataProvider(name = "data")

	private Object[][] dataProvider(Method result) {
		ExcelFileManager excelFile = null;
		Object[][] data = null;
		if (result.getName().equals("TestvalidLogin")||result.getName().equals("TestInvalidLogin") || result.getName().equals("TestSalestool")) {

			excelFile = new ExcelFileManager();
			data = excelFile.getTestData("LoginData");

		} else if (result.getName().equals("TestLeadDeatails")) {
			excelFile = new ExcelFileManager();
			data = excelFile.getTestData("LeadData");

		}
		return data;
	}

}
