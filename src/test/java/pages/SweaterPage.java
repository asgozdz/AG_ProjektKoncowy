package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SweaterPage extends BasePage {

    WebDriverWait myWaitVar;

    public SweaterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "group_1")
    private WebElement sizeSelector;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartButton;

    public void selectSize(String size) {
        Select dropDown = new Select(sizeSelector);
        List<WebElement> options = dropDown.getOptions();
        for (WebElement option : options) {
            if (size.equals(option.getText())) {
                option.click();
            }
        }
    }

    public void setQuantity(String quantityWanted) {
        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(quantityWanted);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickProceedButton() {
        myWaitVar = new WebDriverWait(driver, 20);
        WebElement button = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='cart-content']/div[1]/a[1]")));
        button.click();
    }

    public void clickCheckOut() {
        myWaitVar = new WebDriverWait(driver, 20);
        WebElement button = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@id='main']/div[1]/div[2]/div[1]/div[2]/div[1]")));
        button.click();
    }
    public void clickContinue() {
        myWaitVar = new WebDriverWait(driver, 20);
        WebElement button = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.name("confirm-addresses")));
        button.click();
    }
    public void clickShippingMethod() {
        myWaitVar = new WebDriverWait(driver, 20);
        WebElement button = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.name("confirmDeliveryOption")));
        button.click();
    }
    public void clickPaymentOption() {
      WebElement button  = driver.findElement(
                By.id("payment-option-1"));
        button.click();
    }
    public void clickService() {
        WebElement button = driver.findElement(
                By.id("conditions_to_approve[terms-and-conditions]"));
        button.click();
    }
    public void clickOrderToPay() {
        myWaitVar = new WebDriverWait(driver, 20);
        WebElement button = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn-primary.center-block")));
        button.click();
    }

    public void takeScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/aleksandra/IdeaProjects/AG_ProjektKoncowy/src/screens/" + src.getName()));
    }
}