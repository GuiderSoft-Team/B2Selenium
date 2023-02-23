package gun09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.List;

import static gun09.MyLocatorsClass.*;

public class _03Scroll {

    WebDriver driver;
    WebDriverWait wait;

    public _03Scroll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
        Bir element ile intaraction olacak ise ve o element baska bir element ile örtülüyorsa
        alttaki element ile islem yapilamaz
        Bu durumda sayfanin asagi dogru scroll edilmesi gerekir
        Scroll islemini Javascript yapar
     */

    @Test
    public void testFillTheForm(){
        /*
            https://demoqa.com/text-box
            adresideki formu doldurun, submit edin ve
            yazdiginiz ismin form altinda göründügünü assert edin
         */

        driver.get("https://demoqa.com/text-box");
        //By lName = By.cssSelector("#userName");

        sendkey(lName, "Guidersoft");
        sendkey(lEMail, "gs@gs.com");
        sendkey(lCAdress, "current adress");
        sendkey(lPAdress, "Permanent adress");
        /*
            lSubmit'e görününceye kadar 200 px asagi kaydiralim
            scroll islemi JavaScriptExecuter ile yapilir
         */

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 300)");

        click(lSubmit);
        //js.executeScript("alert('Bitti')");
        driver.quit();
    }


    /*
        JavaScriptExecuter ile kullanilacak basit 3 script:

        1.  mevcut noktadan 0 birim saga, 300 birim asagi git.
        js.executeScript("window.scrollBy(0, 300);");

        2.  ekranda x=300 ve y=300 noktasina git.
        js.executeScript("window.scrollTo(300, 300);");


        3.  element'e kadar scroll et
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[1].scrollIntoView();", element0, element1);

     */



    @Test
    public void testScrollIntoView(){

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        By p = By.xpath("//p[contains(text(),'Curae era')]");

        WebElement elementP = wait.until(ExpectedConditions.presenceOfElementLocated(p));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementP);
        Utils.bekle(2000);

        // false aranan elementin alt siniri sayfanin altinda olacak
        js.executeScript("arguments[0].scrollIntoView(false);", elementP);
        Utils.bekle(2000);

        // true aranan elementin üst siniri sayfanin üstünde olacak
        // bos ise true anlamina gelir
        js.executeScript("arguments[0].scrollIntoView(true);", elementP);
        Utils.bekle(2000);


        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementP);

        driver.quit();

    }



    void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    void sendkey(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

}
