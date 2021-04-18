package com.htc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesToolsPage {
	private WebDriver driver;
	@FindBy(xpath = "//i[@class='far fa-bars v2-hamburger-menu']")
	private WebElement menuBar;

	@FindBy(xpath = "//a[text()='Sales Tools']")
	private WebElement SalesTools;

	@FindBy(xpath = "//a[text()='Build a Proposal']")
	private WebElement BuildProposal;

	@FindBy(xpath = "//div[@class='lead-select-right lead-select-inn' ]/div[@class='button-set']")
	private WebElement SelectLead;

	@FindBy(xpath = "//a[@class='btn btn-primary hide-mobile introjs-l-9 introjs-l-83']/span[text()='ADD LEAD']")
	private WebElement ADDLEAD;

	@FindBy(xpath = "//h1[text()='Add Leads']")
	private WebElement verifySalesTool;

	public SalesToolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifySalesTool() {
		String str = verifySalesTool.getText();
		boolean flag = str.contains("Add Leads");
		return flag;
	}

	public LeadDetailsPage salesTool() throws InterruptedException {
		menuBar.click();
		SalesTools.click();
		BuildProposal.click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText(SelectLead.getText()))).click().perform();
		ADDLEAD.click();
		verifySalesTool();
		return new LeadDetailsPage(driver);
	}

}
