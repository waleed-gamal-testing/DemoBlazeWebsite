package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id=\"loginusername\"]")
    WebElement registeredUserName ;

    @FindBy(xpath = "//input[@id=\"loginpassword\"]")
    WebElement registeredPassword ;

    @FindBy(xpath = "//button[@onclick=\"logIn()\"]")
    WebElement loginBtn ;

    public void addUserNameAndPassword(String username , String password)
    {
        registeredUserName.sendKeys(username);
        registeredPassword.sendKeys(password);
    }
    public HomePage clickOnLoginBtn()
    {
        loginBtn.click();
        return new HomePage(driver);

    }

    //invalid case
    public String validateLoginAlertMsgInValidCase()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert loginAlertMsg = wait.until(ExpectedConditions.alertIsPresent());
        loginAlertMsg = driver.switchTo().alert();
        return loginAlertMsg.getText();
    }
    public void acceptAlertMsgLogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert loginAlertMsg2 = wait.until(ExpectedConditions.alertIsPresent());
        loginAlertMsg2 = driver.switchTo().alert();
        loginAlertMsg2.accept();
    }
}
