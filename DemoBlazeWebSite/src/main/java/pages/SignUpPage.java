package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SignUpPage extends BasePage{
public SignUpPage(WebDriver driver)
{
    super(driver);
}
//locators
    @FindBy(xpath = "//input[@id=\"sign-username\"]")
    private WebElement usernameInput ;

    @FindBy(xpath = "//input[@id=\"sign-password\"]")
    private WebElement passwordInput ;

    @FindBy(xpath = "//button[@onclick=\"register()\"]")
    private WebElement signUpBtn ;

    public void addNewUsernameAndPassword(String userName,String password)
    {
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);

    }
    public void clickOnSignUpBtn()
    {
        signUpBtn.click();
    }
    public String validateSuccessMsg()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert signUPAlert = wait.until(ExpectedConditions.alertIsPresent());
        signUPAlert = driver.switchTo().alert();
      return signUPAlert.getText();

    }

    public String validateSignUpAlertMsgInValidCase()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert signupAlertMsg = wait.until(ExpectedConditions.alertIsPresent());
        signupAlertMsg = driver.switchTo().alert();
        return signupAlertMsg.getText();
    }
    public void acceptAlertMsg()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert signupAlertMsg2 = wait.until(ExpectedConditions.alertIsPresent());
        signupAlertMsg2 = driver.switchTo().alert();
        signupAlertMsg2.accept();
    }

}
