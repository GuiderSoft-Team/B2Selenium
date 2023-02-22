package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _02ImplicitlyWait {

    WebDriver driver;

    @Test
    public void loadingImage() {
        /*
        1.  git ->  https://bonigarcia.dev/selenium-webdriver-java/
        2.  "Loading images" linkine tikla
        3.  cssSelector("#image-container #compass") olan elementin visible oldugunu assert et
        */

        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.findElement(By.xpath("//a[text()='Loading images']")).click();
        WebElement img = driver.findElement(By.cssSelector("#image-container #compass"));
        Assert.assertTrue(img.isDisplayed());
        driver.quit();

        // istenilen element gec olustugu icin driver.findElement() hata verir.

    }

    @Test
    public void loadingImageWithWait() {
        /*
        1.  git ->  https://bonigarcia.dev/selenium-webdriver-java/
        2.  "Loading images" linkine tikla
        3.  cssSelector("#image-container #compass") olan elementin visible oldugunu assert et
        */


        driver = Utils.getChromeDriver();

        // Implicitly Wait sadece elementin precence olmasini max belirtilen süre kadar bekler
        // tüm driver.findElement islemi icin standart bekleme süresidir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        driver.findElement(By.xpath("//a[text()='Loading images']")).click();
        WebElement img = driver.findElement(By.cssSelector("#image-container #landscape"));
        Assert.assertTrue(img.isDisplayed());
        driver.quit();


    }


    @Test
    public void waitForTextVisible() {
        /*
        1.  git ->  http://uitestingplayground.com/
        2.  "AJAX Data" linkine tikla
        3.  "Playground" yazisi altindaki butonuna tiklayin
        4.  "Data loaded with AJAX get request." textinin göründügünü ve
            zemin renginin "#28a745" oldugunu assert edin
        */

        driver = Utils.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://uitestingplayground.com/");

        driver.findElement(By.xpath("//a[text()='AJAX Data']")).click();
        //driver.findElement(By.linkText("AJAX Data")).click();

        driver.findElement(By.id("ajaxButton")).click();

        WebElement label = driver.findElement(By.cssSelector(".bg-success"));
        //WebElement label = driver.findElement(By.className("bg-success"));

        Assert.assertTrue(label.isDisplayed());

        String bgColorRGB = label.getCssValue("background-color");

        String bgColorHex = Color.fromString(bgColorRGB).asHex();
        Assert.assertEquals(bgColorHex, "#28a745");

        driver.quit();

    }




}



/*
    Seleniumda 2 tür bekleme var
    1.  Implicitl Wait
        driver'a aittir, driver'da belirtilir
        driver.findElement ile aranan tüm elemenler olusuncaya (create) kadar standar bekleme süresidir
        driver element bulununcaya kadar ya da maximum bekleme süresince bekler
        bu bekleme süresi icinde elementi bulam ise hata verir


    2.  Explicit Wait
        elemente aittir, driver yürütür
        element visible olucaya kadar, rengi kirmizi olucaya kadar, invisible oluncaya kadar gibi özellikler icin

 */