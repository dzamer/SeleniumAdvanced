package pages;

import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ProductInBasketPage {

    private String prdctName;
    private String prdctQty;
    private String prdctPrice;
    private String prdctTotalPrice;

    public ProductInBasketPage(String prdctName, String prdctQty, String prdctPrice, String prdctTotalPrice) {
        this.prdctName = prdctName;
        this.prdctQty = prdctQty;
        this.prdctPrice = prdctPrice;
        this.prdctTotalPrice = prdctTotalPrice;
    }

    public String getPrdctName() {
        return prdctName;
    }

    public void setPrdctName(String prdctName) {
        this.prdctName = prdctName;
    }

    public String getPrdctQty() {
        return prdctQty;
    }

    public void setPrdctQty(String prdctQty) {
        this.prdctQty = prdctQty;
    }

    public String getPrdctPrice() {
        return prdctPrice;
    }

    public void setPrdctPrice(String prdctPrice) {
        this.prdctPrice = prdctPrice;
    }

    public String getPrdctTotalPrice() {
        return prdctTotalPrice;
    }

    public void setPrdctTotalPrice(String prdctTotalPrice) {
        this.prdctTotalPrice = prdctTotalPrice;
    }
}
