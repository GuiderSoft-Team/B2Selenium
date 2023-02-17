package _Odev2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev2 {


    WebDriver driver;

    String url = "https://opencart.abstracta.us/index.php?route=account/register";

    By logo = By.id("logo");

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void Scenario2() {

        driver.get(url);

        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();


        boolean logoGorundu = driver.findElement(logo).isDisplayed();
        Assert.assertTrue(logoGorundu, "Logo Görünmedi");
        driver.quit();


    }


}
