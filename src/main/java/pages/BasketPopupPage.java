package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPopupPage extends PageBase{
    public BasketPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#blockcart-modal a")
    private WebElement goToBasket;

    public BasketPage goToBasketPage(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(goToBasket));
        goToBasket.click();
        return new BasketPage(getDriver());
    }
}
