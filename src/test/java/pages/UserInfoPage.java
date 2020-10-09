package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoPage extends BasePage {
    public UserInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "birthday")
    WebElement birthdayInput;

    @FindBy(name = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    @FindBy(name = "password")
    WebElement passwordInput;

    public void signInForNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }
    public void signOutFromNewsletter() {
        if (newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }
    public void setBirthdate(String birthDate) {
        birthdayInput.click();
        birthdayInput.clear();
        birthdayInput.sendKeys(birthDate);
    }
    public void submitUserInfo() {
        passwordInput.sendKeys("CodersLab");
        submitButton.click();
    }
    public String getUpdateInformation() {
        return successInformation.getText();
    }
    }
