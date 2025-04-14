package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	 WebElement login;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	public void clickOnRegister() {
		register.click();
	}
	
	public void clickOnLogin() {
		login.click();
	}
}	
