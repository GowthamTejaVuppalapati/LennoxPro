package commanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	private WebDriver driver;

	// Page Factory or Object Repository

	@FindBy(xpath = "//span[@class='signedin-user']")
	private WebElement signedin;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOut;
	
	public LogOutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	protected void logOut() {
		signedin.click();
		
		SignOut.click();
		
	}
	
	
	
	

}
