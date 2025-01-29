package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@onclick=\"byCat('notebook')\"]")
    WebElement laptopCategory ;

    @FindBy(xpath = "//*[@onclick=\"byCat('phone')\"]")
    WebElement phoneCategory ;

    @FindBy(xpath = "//button[@onclick=\"byCat('monitor')\"]")
    WebElement monitorsCategory ;

    @FindBy(xpath = "//*[@id=\"nameofuser\"]")
    WebElement welcomeMsg ;

    //
    @FindBy(xpath = "//a[contains(text(),'Sony vaio i5')]")
    WebElement firstProductInLaptopCategory ;

    @FindBy(xpath = "//a[contains(text(),'Sony vaio i7')]")
    WebElement secondProductInLaptopCategory ;

    public HomePage clickOnLaptopCategory()
    {
        laptopCategory.click();
        return this ;

    }
    public String validateWelcomeMsg()
    {
        return welcomeMsg.getText();
    }
    public ProductPage clickOnFirstProduct()
    {
        firstProductInLaptopCategory.click();
        return new ProductPage(driver);
    }

    public ProductPage clickOnSecondProduct()
    {
        secondProductInLaptopCategory.click();
        return new ProductPage(driver);
    }


}
