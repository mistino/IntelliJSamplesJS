import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {
  public static ChromeOptions options;
  public static WebDriver driver;


    //Functions



   @BeforeTest
    public static void Setup(){
       options = new ChromeOptions();

       options.addArguments("--remote-allow-origins=*");
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
       driver = new ChromeDriver(options);
       driver.get("http://sampleapp.tricentis.com/101/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      // WebDriverWait expwait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
      // WebElement element = expwait.until(ExpectedConditions.elementToBeClickable(By.id("someElementId")));

   }
   //FUNCTIONS
   //public static class AssertMyObject{
      // public static void selectOptionByVisibleText(WebDriver driver, String MyObjectXpath, String visibleText) {
          // WebElement MyObject= driver.findElement(By.xpath(MyObjectXpath));
          // Assert.assertEquals();
       //}
   public static class ComboBoxUtils {
        public static void selectOptionByVisibleText(WebDriver driver, By comboBoxLocator, String visibleText) {
            WebElement pubcomboBox = driver.findElement(comboBoxLocator);
            Select select = new Select(pubcomboBox);
            select.selectByVisibleText(visibleText);
        }

    }
    @Test
    void testSteps(){


       driver.findElement(By.xpath("//*[@id=\"nav_truck\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"engineperformance\"]")).sendKeys("2000");

       WebElement ComboBox = driver.findElement(By.xpath("//*[@id=\"make\"]"));
       Select select = new Select(ComboBox);
       select.selectByVisibleText("Audi");

       By comboBoxLocator = By.xpath("//*[@id=\"numberofseats\"]");
       String optionToSelect = "5";
       ComboBoxUtils.selectOptionByVisibleText(driver, comboBoxLocator, optionToSelect);

// Rest of your test script

        //pag factory sample
      //  LoginPage loginPage;
//loginPage.enterPassword();


//driver.close();
    }


}
