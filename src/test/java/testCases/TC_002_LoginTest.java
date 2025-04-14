package testCases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_LoginTest {

    WebDriver driver;
    Properties prop;

    @BeforeClass
    public void setup() throws Exception {
        // Load config.properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Verify_Login() {
    	
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(prop.getProperty("email"));
        loginPage.setPassword(prop.getProperty("password"));
        loginPage.clickLogin();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        boolean result = myAccountPage.isMyAccountExit();
        Assert.assertTrue(result, "Login failed or My Account page not visible.");
    }
}
