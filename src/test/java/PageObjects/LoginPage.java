package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	// Actions
	public void setEmail(String emailAddr) {
		email.sendKeys(emailAddr);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginButton.click();
	}
	
	

}
