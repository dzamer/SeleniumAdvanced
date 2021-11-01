package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasketPage extends PageBase{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    List<ProductInBasketPage> productList = new ArrayList<>();

    @FindBy(css = ".cart-item")
    private List<WebElement> productListInBasket;

    public List<WebElement> getProductList(){
        return productListInBasket;
    }

    public List<ProductInBasketPage> getProductProperties(){
        for(WebElement product:productListInBasket){
            productList.add(new ProductInBasketPage(product.findElement(By.cssSelector(".product-line-info a.label")).getText(),
                    product.findElement(By.cssSelector("[name='product-quantity-spin']")).getAttribute("value"),
                    product.findElement(By.cssSelector(".current-price")).getText(),
                    product.findElement(By.cssSelector(".product-price strong")).getText()));
        }
        return productList;
    }
}
