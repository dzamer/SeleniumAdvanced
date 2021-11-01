import models.SocialTitle;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.PageBase;
import pages.RegistrationPage;

import java.util.Random;

public class RegisterUserTest extends TestBase{

    @Test
    public void shouldRegisterUser(){
        MenuPage menuPage =  new MenuPage(driver);
        menuPage.goToSignIn();

        new LoginPage(driver).goToNoAccountCreated();

        String firstName = "Krzysztof";
        String lastName = "Jamro";
        int randomNumber =new Random().nextInt();
        String email = firstName+"."+lastName+ randomNumber+"@wp.pl";

        new RegistrationPage(driver).fillAccountForm(SocialTitle.MR, firstName, lastName,
                email,"q75rUn9S")
                .acceptTerms()
                .saveAccount();

        Assert.assertEquals(menuPage.loggedUserInfo(),
                (firstName + " " + lastName));
    }

    @Test
    public void shouldRegisterUser2(){
        String firstName = "Krzysztof";
        String lastName = "Jamro";
        String email = firstName+"."+lastName+ getRandomNumbers()+"@wp.pl";

        MenuPage menuPage =  new MenuPage(driver);
        menuPage.goToSignIn()
                .goToNoAccountCreated()
                .fillAccountForm(SocialTitle.MR, firstName, lastName,
                        email,"q75rUn9S")
                .acceptTerms()
                .saveAccount();

        Assert.assertEquals(menuPage.loggedUserInfo(),
                (firstName + " " + lastName));
    }

    private String getRandomNumbers(){
        return RandomStringUtils.random(5,false,true);
    }
}
