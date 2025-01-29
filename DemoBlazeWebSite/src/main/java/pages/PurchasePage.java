package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PurchasePage extends BasePage {
    public PurchasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement nameField ;

    @FindBy(xpath = "//input[@id=\"country\"]")
    WebElement countryField ;

    @FindBy(xpath = "//input[@id=\"city\"]")
    WebElement cityField ;

    @FindBy(xpath = "//input[@id=\"card\"]")
    WebElement  cardField;

    @FindBy(xpath = "//input[@id=\"month\"]")
    WebElement monthField;

    @FindBy(xpath = "//input[@id=\"year\"]")
    WebElement  yearField;

    @FindBy(xpath = "//button[@onclick=\"purchaseOrder()\"]")
    WebElement purchaseBtn ;

    @FindBy(xpath = "//h2[contains(text(),\"Thank you for your purchase!\")]")
    WebElement confirmationMsg ;
    @FindBy(xpath = "//button[contains(text(),\"OK\")]")
    WebElement confirmationBtn ;

    public PurchasePage addDataInPurchasingCart(String name , String country , String city , String card , String month , String year) throws InterruptedException {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        purchaseBtn.click();
        Thread.sleep(500);
        return this ;

    }
    public String validateConfirmationMsg()
    {
       return  confirmationMsg.getText();

    }
    public void clickONConfirmationBtn() throws InterruptedException {
        confirmationBtn.click();
        Thread.sleep(500);
    }
}
