package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends PageBase{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#_desktop_user_info a")
    private WebElement signInBtn;

    @FindBy(css = "#_desktop_user_info .account")
    private WebElement loggedUser;

    public LoginPage goToSignIn(){
        signInBtn.click();
        return new LoginPage(getDriver());
    }

    public String loggedUserInfo(){
        return loggedUser.getText();
    }
}
