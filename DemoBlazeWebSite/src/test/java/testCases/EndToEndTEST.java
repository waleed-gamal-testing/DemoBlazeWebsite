package testCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class EndToEndTEST extends BaseTest {
    @Test
    public void validProcess() throws InterruptedException {

        Faker faker = new Faker();
        String userNameFake = faker.name().firstName().concat("1081996");
        String countryFake = faker.internet().password().concat("1081996");
        String monthFake = faker.internet().password().concat("1081996");
        String cardFake = faker.internet().password().concat("1081996");
        String cityFake = faker.internet().password().concat("1081996");
        String yearFake = faker.internet().password().concat("1081996");

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnLoginBtnNavBar();
        loginPage.addUserNameAndPassword("test","test");
        HomePage homePage = loginPage.clickOnLoginBtn();
        Thread.sleep(2000);

        // 1- welcome msg in home page
        String actualWelcomeMsg  = homePage.validateWelcomeMsg();
        String expectedWelcomeMsg = "Welcome test";
        System.out.println(actualWelcomeMsg);
        Assert.assertEquals(actualWelcomeMsg,expectedWelcomeMsg);

        Thread.sleep(500);
        homePage.clickOnLaptopCategory();
        ProductPage productPage = homePage.clickOnFirstProduct();
        productPage.clickOnAddToCartBtn1();
        Thread.sleep(1000);

        //2-alert msg >> product added
        String actualAlertMsg = productPage.validateAlertMsgWhenAddProduct();
        String expectedAlertMsg = "Product added.";
        Assert.assertTrue(actualAlertMsg.contains(expectedAlertMsg));

        Thread.sleep(500);
        productPage.acceptAlert();
        Thread.sleep(2000);
        homePage = productPage.clickOnHomeBtn();
        Thread.sleep(1000);
        homePage.clickOnLaptopCategory();
       productPage =  homePage.clickOnSecondProduct();
       Thread.sleep(500);
       productPage.clickOnAddToCartBtn2();
       Thread.sleep(500);


       productPage.acceptAlert();


       //click on cart btn to navigate to cart page
        CartPage cartPage = productPage.clickOnCartBtn();
        Thread.sleep(1000);

        //3-total price is right
        String actualTotalPrice = cartPage.validateTotalPrice();
        String expectedTotalPrice = "1580";
        Assert.assertTrue(actualTotalPrice.contains(expectedTotalPrice));
        Thread.sleep(600);

        //Assertion about number of products in cart page
        List<WebElement>actualProducts = cartPage.getProductsInCartPage();
        Assert.assertEquals(actualProducts.size(), 2, "Number of products in cart is incorrect");

        PurchasePage purchasePage = cartPage.clickOnPlaceHolderBtn();
        Thread.sleep(2000);
        purchasePage.addDataInPurchasingCart(userNameFake,countryFake,cityFake,cardFake,monthFake,yearFake);
        Thread.sleep(1000);

        //4-confirmation msg
        String actualConfirmationMsg = purchasePage.validateConfirmationMsg();
        String expectedConfirmationMsg ="Thank you for your purchase!";
        Assert.assertTrue(actualConfirmationMsg.contains(expectedConfirmationMsg));

        purchasePage.clickONConfirmationBtn();



    }
}
