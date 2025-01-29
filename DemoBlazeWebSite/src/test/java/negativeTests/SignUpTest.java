package negativeTests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;
import testCases.BaseTest;

public class SignUpTest extends BaseTest {
    @Test
    public void inValidSignUp() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.clickOnSignUpBtnNavBar();
        signUpPage.addNewUsernameAndPassword("test","test");
        signUpPage.clickOnSignUpBtn();
        String actualMsg = signUpPage.validateSignUpAlertMsgInValidCase();
        Thread.sleep(800);
        String expectedMsg = "This user already exist.";
        Assert.assertEquals(actualMsg,expectedMsg);
        signUpPage.acceptAlertMsg();

    }
}
