package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BasePage;
import utilities.DataProviders;

public class TC003_DDT extends BasePage {

    public TC003_DDT(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void loginDDT(String email, String password, String expectedResult) {
        try {
            HomePage hp = new HomePage(driver);
            hp.clickOnMyAccount();
            hp.clickOnLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            MyAccountPage mp = new MyAccountPage(driver);
            boolean accountVisible = mp.isMyAccountExit();

            if (expectedResult.equalsIgnoreCase("Valid")) {
                Assert.assertTrue(accountVisible, "❌ Login failed with valid credentials.");
                mp.clickLogout(); // Only logout if login succeeded
            } else if (expectedResult.equalsIgnoreCase("Invalid")) {
                Assert.assertFalse(accountVisible, "❌ Login succeeded with invalid credentials.");
            }
        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
