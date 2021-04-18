package com.htc.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.htc.constants.Constants;

public class ScreenShot {

	public static String screenShot(WebDriver driver, String fileName, String path) {
		String path2 = null;
		if (path.equals("pass")) {
			path2 = Constants.PASS + new SimpleDateFormat(" yyyy-MM-dd----hh-mm-ss a").format(new Date()) + "/";
		} else if (path.equals("fail")) {
			path2 = Constants.FAIL + new SimpleDateFormat(" yyyy-MM-dd---hh-mm-ss a").format(new Date()) + "/";

		}

		String scrPath = path2 + fileName + "  " + timeStamp() + ".jpg";
		TakesScreenshot tss = (TakesScreenshot) driver;

		File fl = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fl, new File(scrPath));

		} catch (IOException e) {

			e.printStackTrace();
		}
		return scrPath;

	}

	public static String timeStamp() {
		return new SimpleDateFormat(" yyyy-MM-dd--( hh-mm-ss a)").format(new Date());

	}

}
