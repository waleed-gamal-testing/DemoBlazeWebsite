package testCases;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
public class End2EndTest extends BaseTest {
   @Test
    public void validProcess() throws InterruptedException {

      ExtentReports extent = new ExtentReports();
      ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
      extent.attachReporter(spark);

      ExtentTest test = extent.createTest("End2EndTest");
      test.log(Status.INFO, "This step shows usage of log(status, details)");
      test.pass("Test Passed");
      extent.flush();

       String userNameFake = FakeDataGenerator.getUserNameFake();
       String countryFake = FakeDataGenerator.getcountryFake();
       String monthFake = FakeDataGenerator.getmonthFake();
       String cardFake = FakeDataGenerator.getCardFake();
       String cityFake =FakeDataGenerator.getCityFake();
       String yearFake =FakeDataGenerator.getyearFake();


       MainPage mainPage = new MainPage(driver);
       LoginPage loginPage = mainPage.clickOnLoginBtnNavBar();
       loginPage.addUserNameAndPassword("test","test");
       HomePage homePage = loginPage.clickOnLoginBtn();
       Thread.sleep(1000);
                               homePage
                               .clickOnLaptopCategory()
                               .clickOnFirstProduct()
                               .clickOnAddToCartBtn1()
                               .acceptAlert()
                               .clickOnHomeBtn()
                               .clickOnLaptopCategory()
                               .clickOnSecondProduct()
                               .clickOnAddToCartBtn2()
                               .acceptAlert()
                               .clickOnHomeBtn()
                               .clickOnLaptopCategory()
                               .clickOnFirstProduct()
                               .clickOnAddToCartBtn1()
                               .acceptAlert()
                               .clickOnCartBtn()
                               .clickOnDeleteBtn()
                               .clickOnPlaceHolderBtn()
                               .addDataInPurchasingCart(userNameFake,countryFake,cityFake,cardFake,monthFake,yearFake)
                               .clickONConfirmationBtn();

   }
}
