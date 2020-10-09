package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index extends BasePage {

    public Index(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@id='content']/section[1]/div[@class='products']/article[@data-id-product='2']")
    WebElement sweaterWidget;

    public void clickSweaterWidget() {
        sweaterWidget.click();
    }
}
