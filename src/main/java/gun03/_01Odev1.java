package gun03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01Odev1 {

    @Test
    public void test1(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //1. https://the-internet.herokuapp.com/login  sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. Sayfadaki h2 elementinin textinin "Login Page" oldugunu asset edin
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Login Page");

        // 3. Formdaki Kullanici ve sifreyi doldurun.
        //    Kullanici: tomsmith
        //    Sifre : SuperSecretPassword!

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        // 4. Login butonuna tiklayin
        driver.findElement(By.className("radius")).click();

        //5. Login oldugunuzdan
        //    a) h2 elementinin textinin "Secure Area" oldugunu,
        //    b) h4 elementinin icinde "Welcome to the Secure Area" yazisinin oldugunu
        //    assert ederek emin olun
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Secure Area");
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().equalsIgnoreCase("Secure Area"));

        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area"));
        driver.quit();
    }

}

/*





 */