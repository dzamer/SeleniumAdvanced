package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".no-account  a")
    private WebElement noAccountBtn;

    public RegistrationPage goToNoAccountCreated(){
        noAccountBtn.click();
        return new RegistrationPage(getDriver());
    }
}
