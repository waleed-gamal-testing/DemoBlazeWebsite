package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h3[@class=\"price-container\"]")
    WebElement priceMsgElement ;
    @FindBy(xpath = "//a[@onclick=\"addToCart(8)\"]")
    WebElement addToCartBtn1;
    @FindBy(xpath = "//a[@onclick=\"addToCart(9)\"]")
    WebElement addToCartBtn2;
    @FindBy(xpath = "//a[contains(text(),\"Home\")]")
    WebElement homeBtn ;
    @FindBy(xpath = "//a[contains(text(),\"Cart\")]")
    WebElement cartBtn ;
    public String validateCorrectPriceMsgAppear()
    {
       return priceMsgElement.getText();
    }
    public ProductPage clickOnAddToCartBtn1() throws InterruptedException {
        addToCartBtn1.click();
        Thread.sleep(500);
        return this;

    }
    public ProductPage clickOnAddToCartBtn2() throws InterruptedException {
        addToCartBtn2.click();
        Thread.sleep(500);
        return this;

    }
    public String validateAlertMsgWhenAddProduct()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert productAlert = wait.until(ExpectedConditions.alertIsPresent());
        productAlert = driver.switchTo().alert();
        return productAlert.getText();
    }
    public ProductPage acceptAlert() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert productAlert = wait.until(ExpectedConditions.alertIsPresent());
        productAlert = driver.switchTo().alert();
        productAlert.accept();
        Thread.sleep(500);
        return this;
    }
    public HomePage clickOnHomeBtn() throws InterruptedException {
        homeBtn.click();
        Thread.sleep(500);
        return new HomePage(driver);
    }
    public CartPage clickOnCartBtn() throws InterruptedException {
        cartBtn.click();
        Thread.sleep(500);
        return new CartPage(driver);

    }
}
