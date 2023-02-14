package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04FindElement {

    WebDriver driver;


    @Test
    public void findElement1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = "https://www.saucedemo.com/";
        driver.get(url);

        // webDriver'in web sayfasi icindeki elementleri görmesi/bulmasi locator'lar ile olur
        // Locator class'i "By"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean logoGorundu = driver.findElement(By.id("header_container")).isDisplayed();
        Assert.assertTrue(logoGorundu, "Logo Görünmedi");
        driver.quit();
    }



}
