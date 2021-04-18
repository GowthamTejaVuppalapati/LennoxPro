package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.htc.constants.Constants;
import com.htc.utility.ScreenShot;


public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.EXTENTREPORT_PATH+"---"+ScreenShot.timeStamp()+".html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("AutoMation Report");

		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");

		return extent;
	}

}
