package gun03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01Odevler {

    WebDriver driver;

    public void driverSetup(String browser) {
        switch (browser.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }

    public void driverQuit(){
        driver.quit();
    }

    @Test
    void odev1(){
        By lUsername = By.id("username");
        By lPassword = By.id("password");
        By lH2 = By.tagName("h2");
        By lH4 = By.tagName("h4");
        By lLoginButton = By.tagName("button");
        //By lLoginButton = By.className("radius");
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        driverSetup("Firefox");
        driver.get("https://the-internet.herokuapp.com/login");

        /*
            // Alttaki 4 satir ile aciklama sonrasi 2 assert ayni islemleri yapiyor
        WebElement loginPageLabel = driver.findElement(lH2);
        String h2Text = loginPageLabel.getText();

        Assert.assertEquals(h2Text, "Login Page");
        Assert.assertTrue(loginPageLabel.isDisplayed());
         */

        Assert.assertEquals(driver.findElement(lH2).getText(), "Login Page");
        Assert.assertTrue(driver.findElement(lH2).isDisplayed());


        driver.findElement(lUsername).sendKeys(username);



        driver.findElement(lPassword).sendKeys(password);


        driverQuit();
    }





}
