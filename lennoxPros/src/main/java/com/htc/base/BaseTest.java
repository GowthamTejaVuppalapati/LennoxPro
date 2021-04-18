package com.htc.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.htc.page.LeadDetailsPage;
import com.htc.page.LoginPage;
import com.htc.page.SalesToolsPage;
import com.htc.prop.Property;

public class BaseTest {
    
	protected WebDriver driver = null;
	protected Properties prop = null;
	protected LoginPage loginPage=null;
	protected SalesToolsPage salestool=null;
	protected LeadDetailsPage leadDetails=null;
	
	public BaseTest() {
		
		Property pro = new Property();
		prop = pro.getProp();
	}

	@BeforeMethod
	public void initialization() {
		DriverFactory drf = new DriverFactory();
		this.driver = drf.driver();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		driver.close();
		driver.quit();
		
	} 
	 
	@BeforeMethod
	public  void objectCreation() {
	
		loginPage=new LoginPage(driver);
		salestool=new SalesToolsPage(driver);
		leadDetails=new LeadDetailsPage(driver);
		
	}

	public WebDriver getDriver() {
		
		return driver;
	}

}
