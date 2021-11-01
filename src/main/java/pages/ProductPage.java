package pages;

import models.Product;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.Random;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement productName;

    @FindBy(css = ".current-price [itemprop='price']")
    private WebElement productPrice;

    @FindBy(css = "#quantity_wanted")
    private WebElement productQty;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    public ProductPage setRandomQty(){
        productQty.clear();
        productQty.sendKeys(String.valueOf(new Random().nextInt(5)+1));
        return this;
    }

    public BasketPopupPage addToBasket(){
        addToCartBtn.click();
        return new BasketPopupPage(getDriver());
    }

    public Product setProduct(){
        String name = getName();
        int quantity = getQuantity();
        BigDecimal price = getPrice();

        return new Product(name,quantity,price);
    }

    private String getName(){
        return productName.getText();
    }

    private BigDecimal getPrice(){
        return new BigDecimal(productPrice.getText().replace("zł",""));
    }

    private int getQuantity(){
        int quantity = Integer.parseInt(productQty.getAttribute("value"));
        return quantity;
    }


}
