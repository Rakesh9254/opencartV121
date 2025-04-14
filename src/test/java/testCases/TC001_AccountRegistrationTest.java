package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_AccountRegistrationTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyAccountRegistration() {
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnRegister();

		AccountRegistrationPage accountreg = new AccountRegistrationPage(driver);
		accountreg.setFirstName("Rakesh");
		accountreg.setLastName("Roshan");
		accountreg.setEmail(generateRandomEmail());
		accountreg.setTelephone(generateRandomPhoneNumber());
		accountreg.setPassword("Rakesh@9254");
		accountreg.setConfirmPassword("Rakesh@9254");
		accountreg.agreeToPrivacyPolicy();
		accountreg.clickContinue();
		
		String confirmationMsg = accountreg.getConfirmationMsg();
		Assert.assertEquals(confirmationMsg, "Congratulations! Your new account has been successfully created!");
	}

	// Helper methods
	public String generateRandomEmail() {
		return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
	}

	public String generateRandomPhoneNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
}
