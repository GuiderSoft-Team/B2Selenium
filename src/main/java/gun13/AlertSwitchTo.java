package gun13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertSwitchTo {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://demoqa.com/alerts";
    By lAlertButton = By.id("alertButton");
    By lTimerAlertButton = By.id("timerAlertButton");
    By lConfirmButton = By.id("confirmButton");
    By lPromtButton = By.id("promtButton");


    public AlertSwitchTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertButtonTest(){
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lAlertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();        // driveralerte gecer ve alert tanimlanir
        System.out.println(alert.getText());            // alert'in texti
        alert.accept();                                 // OK button
        //alert.dismiss();                                // Cancel button
        //alert.sendKeys("");                             // prompt'a text yazmak icin

        // alert'in elementlerinin selectörü yoktur.
        // prompt'un (inputbox olan popup ve yalnizca 1 tane vardir)
        //        input'una text send etmek icin alert.sendKeys("") kullanilir

        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        driver.quit();
    }



}
