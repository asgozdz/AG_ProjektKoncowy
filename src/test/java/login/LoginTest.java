package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }
    @Test
    public void testLoginWithProperCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test@coderslab.pl", "test1234#");
        Assert.assertEquals("Auto Test", loginPage.getLoggedUsername());
    }
    @After
    public void tearDown() {
        driver.quit();
}
}
