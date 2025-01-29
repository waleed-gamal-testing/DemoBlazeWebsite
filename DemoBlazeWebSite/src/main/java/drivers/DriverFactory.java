package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver ;

    public WebDriver initializeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
    String browserName = System.getProperty("browser","CHROME");
        switch (browserName)
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break ;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break ;
            case "SAFARI":
                // safari not use webdriver manager
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("the browser is not suppoprted to test it ");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        return driver;
    }
}
