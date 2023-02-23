package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _01ShadowRoot {

    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Utils.getChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    @Test
    public void shadowRoot(){
        By lHeader = By.cssSelector(".container > h3");
        By lInput = By.id("editField");
        By lGenerateButton = By.id("buttonGenerate");

        driver.get("http://uitestingplayground.com/shadowdom");

        wait.until(ExpectedConditions.textToBe(lHeader, "Shadow DOM"));


        /*
            Shadow root isleminde
            Shadow root elementini buluruz, bunu web Element olarak aliriz
            Alinan elementte .getShadowRoot() methodu ile ShadowRoot cözülür
            istenilen element findElement ile bu cözülen element altinda aranir.

         */

        By lShadowRoot = By.tagName("guid-generator");
        WebElement eShadowRoot = driver.findElement(lShadowRoot);
        eShadowRoot.getShadowRoot().findElement(lInput).sendKeys("shadow");
        Utils.bekle(2000);
        eShadowRoot.getShadowRoot().findElement(lGenerateButton).click();

        //driver.findElement(lInput).sendKeys("shadow");

        Utils.bekle(1000);
        driver.quit();

    }


}
