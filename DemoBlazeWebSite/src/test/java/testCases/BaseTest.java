package testCases;

import drivers.DriverFactory;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected WebDriver driver; //declaration WebDriver in this class

    @BeforeMethod
    public void setup()
    {
        driver = new DriverFactory().initializeDriver();

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


    }

