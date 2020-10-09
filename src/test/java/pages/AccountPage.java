package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountPage extends BasePage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Create new address")
    private WebElement createNewAddressButton;

    @FindBy(xpath="//article[@class='address']")
    List<WebElement> articlesTiles;

    public void clickCreateNewAddress() {
        createNewAddressButton.click();
    }
    public String getLastAddress(){
        WebElement lastAddress = articlesTiles.get(articlesTiles.size()-1);
        return lastAddress.getText();
    }
}