package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeleniumActionClass2 extends BaseActionsClass{

    String url = "https://demoqa.com/auto-complete";

    @Test
    public void fillInput1(){
        driver.get(url);

        By input1 = By.cssSelector("#autoCompleteMultipleContainer");
        WebElement eInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(input1));

        new Actions(driver)
                .moveToElement(eInput1,-10,10)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)
                .build()
                .perform();

        driver.quit();
        //  .moveToElement(element)  -> elementin orta noktasina gider
        //  .moveToElement(element, 10, 10)  -> elementin orta noktasindan 10 px saga ve 10 px asagi gider
        //  .moveToElement(element, -10, -10)  -> elementin orta noktasindan 10 px sola ve 10 px yukari gider

    //div//parent::input[@name='keyboard']





    }

    /*
    Bu islemler Actions
    1.  https://demoqa.com/auto-complete
    2.  ilk input icine "a" yazin
    3.  2 defa alt ok kusu ile asagi gidin
    4.  enter'a basin

     */

    @Test
    public void test1(){
        driver.get("https://google.com/");
    }
}
