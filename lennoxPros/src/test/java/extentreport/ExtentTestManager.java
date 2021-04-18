package extentreport;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ExtentTestManager {

	private ExtentReports extent;
	public static ExtentTest test;

	private Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	public synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public synchronized void endTest() {

		extent.flush();
	}

	public synchronized ExtentTest startTest(String testName) {

		extent = ExtentManager.getInstance();
		test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
		
	}

}