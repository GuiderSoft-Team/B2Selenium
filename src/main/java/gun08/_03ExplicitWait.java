package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _03ExplicitWait {

    WebDriver driver;
    WebDriverWait wait;     // explicit wait icin kullanilacak

    @Test
    public void dialogProcess(){

        driver = Utils.getChromeDriver();

        // bu wait islemini driver yapacak, bekleme süresi 10 sn
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://demoqa.com/modal-dialogs");

        driver.findElement(By.id("showSmallModal")).click();

        //driver.findElement(By.id("closeSmallModal")).click();

        // locator'i verilen element clickable oluncaya kadar bekler
        // sonucta WebElement return eder, o nedenle .click methodu kullaniliabilir
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeSmallModal"))).click();

        // locator'i verilen elementin invisible olmasini bekler
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("closeSmallModal")));

        driver.quit();


    }




}

/*
    Elemente özel durumlar icin bekleme süresi
    Ayri bir WebDriverWait tanimlanir
    Element durumlari, (WebElement, By)
        visible
        clickable
        attribute
        invisible
        elements size
        ....


   Eger hem Implicit wait hem de Explicit wait beraber kullanilirsa,
   element presence olmamasinin gecikmesi durumunda cok fazla bekleme süresi olur.
   Önce implicitly wait calisir sonra explicit wait calisir

   wait.Until(ExpectedConditions.presenceOfElementLocated(By))  -> Implicitly wait gibi
   wait.Until(ExpectedConditions.presenceOfElement(WebElement)) -> Implicitly wait gibi



 */
