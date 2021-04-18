package com.htc.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtility {

	public void drawBorder(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void flash(WebElement element, WebDriver driver) {

		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}

	}

	private void changeColor(String Color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + Color + "'", element);

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void generateAlert(WebDriver driver, String message) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public void clickElementByJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	public void refreshBrowser(WebDriver driver) {

		// driver.navigate().refresh();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}

	public String getTitleByJS(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;

	}

	public String getPageInnerText(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;

	}

	public void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

}
