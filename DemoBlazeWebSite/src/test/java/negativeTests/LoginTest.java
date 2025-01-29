package negativeTests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import testCases.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void validProcess() throws InterruptedException {
        Faker faker = new Faker();
        String userNameFake = faker.name().firstName().concat("Waleed1091818");
        String passwordFake = faker.internet().password().concat("1081996");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnLoginBtnNavBar();
        loginPage.addUserNameAndPassword(userNameFake, passwordFake);
        loginPage.clickOnLoginBtn();
        String actualLoginMsg = loginPage.validateLoginAlertMsgInValidCase();
        String expectedLoginMsgAlert = "User does not exist.";
        Assert.assertTrue(actualLoginMsg.contains(expectedLoginMsgAlert));
        Thread.sleep(1000);
        loginPage.acceptAlertMsgLogin();
    }
}