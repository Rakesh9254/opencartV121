package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement InkLogOut;
	
	public boolean isMyAccountExit() {
		try {
			return myAccount.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public void clickLogout() {
		InkLogOut.click();
	}
	
	
	
	

}
