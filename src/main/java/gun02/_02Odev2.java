package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class _02Odev2 {
    /*
           B. Chrome browser ile kullanarak
      1. https://demos.bellatrix.solutions/ sayfasina gidin
      2. Sayfa title'inin length'ini, currentURL'i ve pageSource()'u [sayfa kaynak kodlari] consol'a yazdirin.
      3. Title'in uzunlugunun 10'dan büyük oldugunu assert edin.
      4. Current url'in "google" icermedigini assert edin
     */

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demos.bellatrix.solutions/");
        System.out.println("driver.getTitle().length() = " + driver.getTitle().length());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        Assert.assertTrue(driver.getTitle().length()>10, "Length 10 da kücük");
        Assert.assertFalse(driver.getCurrentUrl().contains("google"), "URL google icermektedir");
        //Assert.assertTrue(!driver.getCurrentUrl().contains("google"));

        driver.quit();
    }
}
