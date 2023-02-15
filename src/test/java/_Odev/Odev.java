package _Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev {

    WebDriver driver;

    String url = "https://the-internet.herokuapp.com/login";
    By userName = By.id("username");
    By password = By.id("password");

    String myUsername = "tomsmith";
    String myPassword = "SuperSecretPassword!";

    By loginButton = By.tagName("i");


    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void Scenario1() {

        driver.get(url);

        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Login Page"));

        driver.findElement(userName).sendKeys(myUsername);
        driver.findElement(password).sendKeys(myPassword);
        driver.findElement(loginButton).click();

        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Secure Area"));

        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area"));
        driver.quit();


    }


}
