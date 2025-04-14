package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(name = "agree")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//p[normalize-space()='Congratulations! Your new account has been successfully created!']")
	WebElement msgConfirmation;

	// Actions
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String emailAddr) {
		email.sendKeys(emailAddr);
	}

	public void setTelephone(String phone) {
		telephone.sendKeys(phone);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void setConfirmPassword(String cpwd) {
		confirmPassword.sendKeys(cpwd);
	}

	public void agreeToPrivacyPolicy() {
		privacyPolicy.click();
	}

	public void clickContinue() {
		continueButton.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
