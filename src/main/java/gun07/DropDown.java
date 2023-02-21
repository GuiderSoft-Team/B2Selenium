package gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class DropDown {

    WebDriver driver;

    @Test
    public void select1(){
        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By linkWebForm = By.linkText("Web form");
        driver.findElement(linkWebForm).click();

        // Select, tag'i select olan Web elementine ait ozel methodlari olan classdir.
        By select = By.name("my-select");
        driver.findElement(select).click();
        Utils.bekle(3000);
        driver.quit();

    }


    @Test
    public void select2(){
        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By linkWebForm = By.linkText("Web form");
        driver.findElement(linkWebForm).click();


        By select = By.name("my-select");
        Select selectMenu = new Select(driver.findElement(select));
        selectMenu.selectByIndex(1);
        Utils.bekle(1000);
        selectMenu.selectByVisibleText("Three");
        Utils.bekle(1000);
        selectMenu.selectByValue("2");

        for (WebElement option : selectMenu.getOptions()) {
            System.out.println("Value : " + option.getAttribute("value") + ", text: " + option.getText());
        }

        Utils.bekle(2000);
        driver.quit();

    }


    @Test
    public void selectEBayBaby(){
        driver = Utils.getChromeDriver();
        driver.get("https://www.ebay.com/");

        WebElement ddMenu = driver.findElement(By.cssSelector("#gh-cat"));

        Select menu = new Select(ddMenu);
        menu.selectByVisibleText("Baby");

        driver.findElement(By.cssSelector("#gh-btn")).click();

        WebElement nav = driver.findElement(By.xpath("//nav[contains(., 'Baby')]"));
        Assert.assertTrue(nav.isDisplayed());

        Utils.bekle(2000);
        driver.quit();

    }


}
