package testCases;


import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;

import java.time.Duration;

public class SignUpTest extends BaseTest {
    @Test
    public void validSignUp() throws InterruptedException {
        Faker faker = new Faker();
        String userNameFake = faker.name().firstName().concat("1081996");
        String passwordFake = faker.internet().password().concat("1081996");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.clickOnSignUpBtnNavBar();
        signUpPage.addNewUsernameAndPassword(userNameFake,passwordFake);
        signUpPage.clickOnSignUpBtn();
        String actualMsg = signUpPage.validateSuccessMsg();
        String expectedMsg = "Sign up successful.";
        Assert.assertEquals(actualMsg,expectedMsg);

    }
}
