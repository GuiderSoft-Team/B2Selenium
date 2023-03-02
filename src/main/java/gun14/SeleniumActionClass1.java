package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Utils;

import java.util.List;

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


    @Test
    public void actions2() {
        driver.get(url);

        By lMenus = By.cssSelector("ul.nav > li");

        List<WebElement> menus = driver.findElements(lMenus);

        for (WebElement menu : menus) {

            new Actions(driver).moveToElement(menu).pause(500).build().perform();
        }

        driver.quit();

    }



    @Test
    public void actions3() {
        driver.get(url);

        By lMenus = By.cssSelector("ul.nav > li");

        List<WebElement> menus = driver.findElements(lMenus);

        for (WebElement menu : menus) {
            //hover(menu);
            Utils.hover(driver, menu);
        }

        driver.quit();
    }

    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).pause(500).build().perform();
    }

    public void hover(WebElement element, int xOffset, int yOffset){
        new Actions(driver).moveToElement(element, xOffset, yOffset).pause(100).build().perform();
    }


    public void clickByAction(){
        new Actions(driver).click().build().perform();
    }

    public void pageDown(){
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void clickByAction(WebElement element){
        new Actions(driver).moveToElement(element).click().build().perform();
    }



}
