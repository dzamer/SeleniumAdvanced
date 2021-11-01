package pages;

import models.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class RegistrationPage extends PageBase{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".radio-inline")
    private List<WebElement> socialTitleRBtn;

    @FindBy(css = "[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = ".register-form [name='email']")
    private WebElement emailInput;

    @FindBy(css = "[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "[name='customer_privacy']")
    private WebElement customerPrivacy;

    @FindBy(css = "[name='psgdpr']")
    private WebElement generalPolicies;

    @FindBy(css = ".form-control-submit")
    private WebElement saveBtn;

    public RegistrationPage fillAccountForm(SocialTitle socTitle, String firstName, String lastName, String email,
                                            String password){
        switch(socTitle){
            case MR:
                socialTitleRBtn.get(0).click();
                break;
            case MRS:
                socialTitleRBtn.get(1).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + socTitle);
        }

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage acceptTerms(){
        customerPrivacy.click();
        generalPolicies.click();
        return this;
    }

    public void saveAccount(){
        saveBtn.click();
    }

}
