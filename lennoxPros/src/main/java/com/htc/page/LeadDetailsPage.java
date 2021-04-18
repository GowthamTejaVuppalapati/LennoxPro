package com.htc.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commanPage.LogOutPage;

public class LeadDetailsPage extends LogOutPage {

	private WebDriver driver;

	// Page Factory or Object Repository

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='phNo']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='calender1']")
	private WebElement calender1;

	@FindBy(xpath = "//input[@id='calender2']")
	private WebElement calender2;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private WebElement tableData;

	@FindBy(xpath = "//p[text()='Add Document']")
	private WebElement addDocument;

	@FindBy(xpath = "//select[@name='documents[1].documentType']")
	private WebElement documentType;

	@FindBy(xpath = "//select[@name='documents[0].documentType']//option[@value=\"OTHER\"]")
	private WebElement other;

	@FindBy(xpath = "//span[@class='fileSelect1']//input[@name='documentFiles[1]']")
	private WebElement selectFile;

	@FindBy(xpath = "//span[text()='Add To Lead']")
	private WebElement addToLead;

	@FindBy(xpath = "//input[@id='multipleImageSelect[0]']")
	private WebElement addImgLead;

	@FindBy(xpath = "//span[text()='SAVE LEAD']")
	private WebElement SaveLead;

	@FindBy(xpath = "//li[contains(text(),'Lead has been created')]")
	private WebElement verifyLeadCreation;
	
	public LeadDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void calaender1() {
		calender1.click();

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		int total = dates.size();
		for (int i = 0; i < total; i++) {
			String date = dates.get(i).getText();

			if (date.equals("20")) {
				dates.get(i).click();
				break;
			}

		}
	}

	public void calender2() {
		calender2.click();

		List<WebElement> dates2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		int total2 = dates2.size();
		for (int i = 0; i < total2; i++) {
			String date2 = dates2.get(i).getText();

			if (date2.equals("24")) {
				dates2.get(i).click();
				
				break;
			}

		}
	}

	public void addDoc() {
		addDocument.click();

		Select sc = new Select(driver.findElement(By.xpath("//select[@name='documents[1].documentType']")));
		sc.selectByIndex(3);
	}

	public void addImg() {
		
			selectFile.sendKeys("C:\\Users\\Gowtham Teja\\Documents\\sql day1.docx");
			addToLead.click();
			addImgLead.sendKeys("C:\\Users\\Gowtham Teja\\Desktop\\img.jpeg");
			SaveLead.click();
		
		
	}

	public boolean leadCreationVerification() {
		String str = verifyLeadCreation.getText();
		boolean flag = str.contains("Lead has been created");
		return flag;
	}

	public boolean  leadData(Map<Object, Object> mapData) throws InterruptedException {
		firstName.sendKeys(mapData.get("firstName").toString());
		lastName.sendKeys(mapData.get("lastName").toString());
		Object nu = mapData.get("phoneNumber");
		String nn = nu.toString();
		phoneNumber.sendKeys(nn);
		email.sendKeys(mapData.get("email").toString());
		calaender1();
		calender2();
		addDoc();
		addImg();
		boolean flag=leadCreationVerification();
		logOut();
		return flag;

	}

}
