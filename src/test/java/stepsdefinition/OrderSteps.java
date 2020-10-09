package stepsdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Index;
import pages.LoginPage;
import pages.SweaterPage;

import java.util.concurrent.TimeUnit;

public class OrderSteps {

    private WebDriver driver;

    @Given("^User is logged in to Store Shop$")
    public void userIsLoggedInToStoreShop() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test@coderslab.pl", "test1234#");
    }

    @When("^User click into sweater$")
    public void userClickIntoSweater() {
        Index indexPage = new Index(driver);
        indexPage.clickSweaterWidget();
    }

    @And("^Select size \"([^\"]*)\"$")
    public void selectSize(String size)  {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.selectSize(size);
    }

    @And("^Select quantity, add to cart and proceed to checkout \"([^\"]*)\"$")
    public void selectQuantityAddToCartAndProceedToCheckout(String quantity) {
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.setQuantity(quantity);
        sweaterPage.clickAddToCartButton();
        sweaterPage.clickProceedButton();
        sweaterPage.clickCheckOut();
        sweaterPage.clickContinue();
        sweaterPage.clickShippingMethod();
        sweaterPage.clickPaymentOption();
        sweaterPage.clickService();
        sweaterPage.clickOrderToPay();

    }

    @Then("^Take the order screenshot$")
    public void takeTheOrderScreenshot() throws Throwable{
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.takeScreenshot();
    }
}
