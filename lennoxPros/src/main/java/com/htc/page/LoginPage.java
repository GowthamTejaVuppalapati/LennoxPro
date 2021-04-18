package com.htc.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	// Page Factory or Object Repository

	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement SignIn;

	@FindBy(xpath = "//input[@id='j_username']")
	private WebElement UserName;

	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement Password;

	@FindBy(xpath = "//button[@id='loginSubmit']")
	private WebElement loginSubmit;

	@FindBy(xpath = "//button[contains(text(),'Welcome,')]")
	private WebElement verifyLogIN;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean verifyLogin() {
		String str = verifyLogIN.getText();
		boolean flag = str.contains("Welcome");
		return flag;
	}

	public SalesToolsPage LOGIN(String email, String password) {
		try {

			SignIn.click();
			UserName.sendKeys(email);
			Password.sendKeys(password);
			loginSubmit.click();
			verifyLogin();

		} catch (NoSuchElementException ee) {
			ee.printStackTrace();
			ee.getMessage();

		} catch (Exception ee) {

			ee.printStackTrace();
			ee.getMessage();

		}

		return new SalesToolsPage(driver);

	}

}
