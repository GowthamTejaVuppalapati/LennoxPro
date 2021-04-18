package com.htc.utility;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.htc.constants.Constants;

public class WaitCondition {

	public void explicitWait(int tm, WebElement we, WebDriver driver) {

		try {
			WebElement wdw = new WebDriverWait(driver, tm).until(ExpectedConditions.visibilityOf(we));
			boolean status = wdw.isDisplayed();
			if (status) {
				System.out.println("===== WebDriver is visible======");
			}

		} catch (NoSuchElementException nsee) {
			System.out.println("You are getting No Such Element Exception" + "------------>");
			nsee.printStackTrace();

		} catch (Exception e) {
			System.out.println("You are getting other Exception");
			e.printStackTrace();
		}
	}

	public void setExplicitWait(WebDriver wd, int tm, WebElement we, String value) throws InterruptedException {

		@SuppressWarnings("unused")
		WebElement wdw = new WebDriverWait(wd, tm).until(ExpectedConditions.visibilityOf(we));
		we.sendKeys(value);

	}

	public void fluentWait(WebDriver reference) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(reference).withTimeout(Duration.ofSeconds(Constants.SECONDS))
				.pollingEvery(Duration.ofSeconds(Constants.SECONDS)).ignoring(Exception.class);
	}

}
