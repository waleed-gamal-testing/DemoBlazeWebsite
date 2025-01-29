package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h3[@id=\"totalp\"]")
    WebElement totalPriceMsg ;
    @FindBy(xpath = "//button[contains(text(),\"Place Order\")]")
    WebElement placeOrderBtn ;
    @FindBy(xpath = "//*[contains(text(),\"Delete\")]")
    WebElement deleteBtn ;
    public String validateTotalPrice()
    {
        return totalPriceMsg.getText();
    }
    public PurchasePage clickOnPlaceHolderBtn() throws InterruptedException {
        placeOrderBtn.click();
        Thread.sleep(1000);
        return new PurchasePage(driver);
    }
    public CartPage clickOnDeleteBtn() throws InterruptedException {
        deleteBtn.click();
        Thread.sleep(700);
        return this ;
    }
    /*public void verifyNumberOfProducts(int expectedCount) {
        List<WebElement> products = driver.findElements(By.xpath("//td[contains(text(),\"Sony\")]"));
        *//*Assert.assertEquals(products.size(), expectedCount, "Number of products in cart is incorrect");*//*
    }*/
    public List<WebElement> getProductsInCartPage() {
       List<WebElement> products = driver.findElements(By.xpath("//td[contains(text(),\"Sony\")]"));
       return products ;
        /*Assert.assertEquals(products.size(), expectedCount, "Number of products in cart is incorrect");*/
    }

}
