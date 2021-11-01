package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".products [itemprop='itemListElement']")
    List<WebElement> productsList;

    public ProductPage openRandomProduct(){
        productsList.get(new Random().nextInt(productsList.size())).click();
        return new ProductPage(getDriver());
    }
}
