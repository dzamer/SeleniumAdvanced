package models;

import java.math.BigDecimal;

public class Product {

    private String prdctName;
    private int prdctQty;
    private BigDecimal prdctPrice;

    public Product(String prdctName, int prdctQty, BigDecimal prdctPrice) {
        this.prdctName = prdctName;
        this.prdctQty = prdctQty;
        this.prdctPrice = prdctPrice;
    }

    public String getPrdctName() {
        return prdctName;
    }

    public int getPrdctQty() {
        return prdctQty;
    }

    public BigDecimal getPrdctPrice() {
        return prdctPrice;
    }

    public BigDecimal getTotalPrice(){
        return prdctPrice.multiply(new BigDecimal(prdctQty));
    }


}
