package gun12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class IFrame2 {

    WebDriver driver;
    WebDriverWait wait;

    public IFrame2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void textEditor(){
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.partialLinkText("iFrame")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));

        driver.switchTo().frame(0);

        By p = By.cssSelector("#tinymce p");
        WebElement editor = driver.findElement(p);
        editor.click();
        editor.sendKeys(Keys.CONTROL + "A");

        Utils.bekle(3000);
        driver.quit();

    }


    @Test
    public void textEditor1(){
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.partialLinkText("iFrame")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));

        By lFile = By.xpath("//span[text()='File']");
        WebElement eFile = driver.findElement(lFile);
        eFile.click();


        By lNewDocument = By.xpath("//div[text()='New document']");
        WebElement eNewDocument = driver.findElement(lNewDocument);
        eNewDocument.click();

        By lBold = By.xpath("//button[@title='Bold']");
        By lItalic = By.xpath("//button[@title='Italic']");

        driver.findElement(lBold).click();
        driver.findElement(lItalic).click();

        driver.switchTo().frame(0);

        By p = By.cssSelector("#tinymce p");

        WebElement editor = driver.findElement(p);
        editor.click();

        editor.sendKeys("Ahmet", Keys.ENTER);
        editor.sendKeys("Tttttt");
        for (int i = 0; i < 5; i++) {
            editor.sendKeys(Keys.BACK_SPACE);
        }
        editor.sendKeys(Keys.ARROW_UP, Keys.HOME);

        Utils.bekle(3000);
        driver.quit();

    }


}
