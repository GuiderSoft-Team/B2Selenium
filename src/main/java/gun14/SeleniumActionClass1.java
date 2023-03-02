package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Utils;

public class SeleniumActionClass1 extends BaseActionsClass {

    String url = "http://opencart.abstracta.us/";

    @Test
    public void actions1() {
        // action class
        driver.get(url);

        By sli1 = By.cssSelector("ul.nav > li:nth-of-type(1)");
        By sli2 = By.cssSelector("ul.nav > li:nth-of-type(2)");
        WebElement eli1 = driver.findElement(sli1);
        WebElement eli2 = driver.findElement(sli2);

        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(eli1)
                .pause(1000)
                .moveToElement(eli2)
                .pause(1000)
                .build();

        action.perform();

        Utils.bekle(2000);
        driver.quit();

        /*
        new Actions(driver)
                .moveToElement(eli1).pause(1000).click().build()
                .perform();
         */
    }

}
