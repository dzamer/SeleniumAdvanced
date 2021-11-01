import models.Product;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductInBasketPage;
import pages.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class BasketTest extends TestBase{

    @Test
    public void shouldAddProductToBasket(){
        HomePage homePage = new HomePage(driver);
        homePage.openRandomProduct();
        SoftAssert softAssert = new SoftAssert();

        ProductPage productPage = new ProductPage(driver);
        List<Product> productList = new ArrayList<>();
        productList.add(productPage.setRandomQty().setProduct());
        productPage.addToBasket().goToBasketPage();

        List<ProductInBasketPage> listOfProducts = new BasketPage(driver).getProductProperties();
        for(Product product : productList) {
            for(ProductInBasketPage singleProduct : listOfProducts){
                softAssert.assertEquals(singleProduct.getPrdctPrice(),("zł"+product.getPrdctPrice()));
                softAssert.assertEquals(singleProduct.getPrdctName(),product.getPrdctName());
                softAssert.assertEquals(singleProduct.getPrdctQty(), String.valueOf(product.getPrdctQty()));
                softAssert.assertEquals(singleProduct.getPrdctTotalPrice(), ("zł"+product.getTotalPrice()));
                softAssert.assertAll();
            }
        }
    }
}
