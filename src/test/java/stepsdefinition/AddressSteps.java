package stepsdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AccountPage;
import pages.AddressPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressSteps {

    private WebDriver driver;

    @Given("^User is logged in to My Store Shop$")
    public void userIsLoggedInToMyStoreShop() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test@coderslab.pl", "test1234#");
    }

    @When("^User goes to AddressPage$")
    public void userGoesToAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }

    @And("^User click to create new address$")
    public void userClickToCreateNewAddress() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickCreateNewAddress();
    }

    @And("^User fill in alias, address, city, zip/postal code/country/phone$")
    public void userFillInAliasAddressCityZipPostalCodeCountryPhone() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.setAlias("My new address");
        addressPage.setAddress1("Testy");
        addressPage.setCity("Warsaw");
        addressPage.setPostcode("333333");
        addressPage.setIdCountry();
        addressPage.setPhone("800900070");
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.submitAddressPage();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String expected) {
        AddressPage addressPage = new AddressPage(driver);
        assertEquals(expected, addressPage.getUpdateInformation());
    }

    @Then("^User check if address is added$")
    public void userCheckIfAddressIsAdded() {
        AccountPage accountPage = new AccountPage(driver);
        String[] split = accountPage.getLastAddress().split("\n");
        assertEquals("My new address", split[0]);
        assertEquals("Testy", split[2]);
        assertEquals("Warsaw", split[3]);
        assertEquals("333333", split[4]);
        assertEquals("United Kingdom", split[5]);
        assertEquals("800900070", split[6]);
    }
}
