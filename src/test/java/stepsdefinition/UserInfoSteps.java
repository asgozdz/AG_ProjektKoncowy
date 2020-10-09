package stepsdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.UserInfoPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UserInfoSteps {
    private WebDriver driver;

    @Given("^User is logged in to CodersLab shop1$")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test@coderslab.pl", "test1234#");
    }
    @When("^User goes to UserInformationPage1$")
    public void userGoesToUserInformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
    }
    @And("^User signs up for our newsletter1$")
    public void userSignsUpForOurNewsletter() {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.signInForNewsletter();
    }
    @And("^User saves information1$")
    public void userSavesInformation() {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.submitUserInfo();
    }
    @Then("^User sees1 \"([^\"]*)\"$")
    public void userSees(String expected) {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        assertEquals(expected, userInfoPage.getUpdateInformation());
    }
}
