package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class _01GetCss {

    WebDriver driver;

    @Test
    public void checkBgColor() {
        /*
            1.  git ->  http://uitestingplayground.com/
            2.  "Click"  linkine tikla
            3.  "Playground" yazisi altindaki butonun zemin-rengini bir "colorBeforeClick" degiskenine atayin ve consola yazdirin
            4.  butona tiklayin
            5.  butonun zemin-rengini "colorAfterClick" degiskenine atayin ve tekrar consola yazdirin
            6.  colorBeforeClick ve colorAfterClick degerlerinin farkli oldugunu assert edin
         */

        driver = Utils.getChromeDriver();
        driver.get("http://uitestingplayground.com/");
        driver.findElement(By.xpath("//a[text()='Click']")).click();

        WebElement button = driver.findElement(By.id("badButton"));

        // .getCssValue("css name"); elementin istedigimiz css degerini return eder
        String colorBeforeClick = button.getCssValue("background-color");
        button.click();
        Utils.bekle(500);
        String colorAfterClick = button.getCssValue("background-color");
        System.out.println(colorBeforeClick + ", " + colorAfterClick);
        Assert.assertNotEquals(colorBeforeClick, colorAfterClick);


        // Selenium'un Color class'i
        Color color1 = Color.fromString(colorBeforeClick);
        System.out.println(colorBeforeClick + " : " + color1.asHex());
        driver.quit();

    }

/*
        color
            rgb(0, 123, 255)
            rgba(33, 136, 56, 1)
            Hex : 16'lik taban
            #RGB -> #120e34

            0 1 2 3 4 5 6 7 8 9 a b c d e f
 */


}

