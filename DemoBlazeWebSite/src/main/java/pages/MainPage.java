package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//a[@id=\"signin2\"]")
    WebElement signUpBtnNavBar ;

    @FindBy(xpath = "//a[@id=\"login2\"]")
    WebElement loginBtnNavBar ;


    public SignUpPage clickOnSignUpBtnNavBar()
    {
        signUpBtnNavBar.click();
        return new SignUpPage(driver);
    }
    public LoginPage clickOnLoginBtnNavBar() throws InterruptedException {
        loginBtnNavBar.click();
        Thread.sleep(500);
        return new LoginPage(driver);
    }
}
