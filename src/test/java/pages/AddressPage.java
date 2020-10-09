package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends BasePage {
    public AddressPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement address1Input;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postCodeInput;

    @FindBy(name = "id_country")
    private WebElement countryInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement successInformation;


    public void setPhone(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void setIdCountry() {
        Select dropDown = new Select(countryInput);
        dropDown.getFirstSelectedOption().click();
    }

    public void setPostcode(String postcode) {
        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postcode);
    }

    public void setAddress1(String address1) {
        address1Input.click();
        address1Input.clear();
        address1Input.sendKeys(address1);
    }

    public void setAlias(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void setCity(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void submitAddressPage() {
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

}
