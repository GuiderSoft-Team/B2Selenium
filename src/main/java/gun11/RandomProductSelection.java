package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RandomProductSelection {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://www.saucedemo.com/";

    @Test
    public void selectRandomProduct(){
        setupDriver();
        driver.get(url);



        tearDown();
    }


    void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    void tearDown(){
        driver.quit();
    }


}

