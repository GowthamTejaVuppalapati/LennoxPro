package com.htc.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import com.htc.constants.Constants;
import com.htc.prop.Property;

public class DriverFactory {
	protected Properties prop;

	public DriverFactory() {
		Property pro = new Property();
		prop = pro.getProp();
	}

	@BeforeSuite
	public WebDriver driver() {

		WebDriver driver = null;
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			System.setProperty(prop.getProperty("chrome_key"), prop.getProperty("chrome_value"));
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITTIMEOUT, TimeUnit.SECONDS);
		driver.get(Constants.APPLICATION_URL);
		return driver;

	}

}
