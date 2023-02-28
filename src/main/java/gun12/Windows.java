package gun12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Windows {


    WebDriver driver;
    WebDriverWait wait;

    public Windows(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void driverHandle(){
        driver.get("https://demoqa.com/browser-windows");
        System.out.println(driver.getWindowHandle());
        driver.quit();
    }

    @Test
    public void driverHandles(){
        driver.get("https://demoqa.com/browser-windows");
        By lTabButton = By.id("tabButton");
        driver.findElement(lTabButton).click();

        System.out.println(driver.getWindowHandles());

        driver.quit();
    }



    /*
        driver.getWindowHandle()    :   aktif kullandigim window'un handle'ini verir (id)
        driver.getWindowHandles()   :   acilmis olan tüm windowlarin handle'larini set olarak verir
     */
}
