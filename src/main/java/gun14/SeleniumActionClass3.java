package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Set;

import static utils.Utils.bekle;

public class SeleniumActionClass3 extends BaseActionsClass{


    String url = "https://www.snapdeal.com/";

    By lSearchBox = By.id("inputValEnter");
    By lFirstProduct = By.xpath("(//div[@class='product-tuple-image ']/a)[1]");
    By productBigPicture = By.cssSelector("img[slidenum='0']");

    @Test
    public void resimUstundeGezinti(){
        driver.get(url);
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox));

        /*
        new Actions(driver)
                .moveToElement(input)   // input üzerine gelir
                .click()                // elemente tikladi
                .sendKeys("watch")      //  "watch" harflerini send edecek
                .build()
                .perform();

        new Actions(driver)
                .sendKeys(input, "Watch")   //bu elemente "watch" send eder
                .build()
                .perform();

         */

        String mainWin = driver.getWindowHandle();

        new Actions(driver)
                .sendKeys(input, "watch")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(lFirstProduct));

        Actions actions = new Actions(driver);
        Action action = actions
                .click(firstProduct)
                .build();
        action.perform();



        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> wins = driver.getWindowHandles();

        for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWin)){
                driver.switchTo().window(win);
                break;
            }
        }

        /*
        wins.forEach(win -> {
            if (!win.equalsIgnoreCase(mainWin)){
                driver.switchTo().window(win);
            }
        });
         */

        WebElement picture = wait.until(ExpectedConditions.visibilityOfElementLocated(productBigPicture));


        new Actions(driver)
                .moveToElement(picture)
                .build()
                .perform();

        // asagidaki belirtilen koordinatlara hover eder
        /*
        hoverWithOffset(picture, -50, -50);
        hoverWithOffset(picture, -20, -20);
        hoverWithOffset(picture, 0, 0);
        hoverWithOffset(picture, 20, 20);
        hoverWithOffset(picture, 50, 50);
         */

        int height = picture.getSize().height;

        for (int i = -height/2; i < height/2; i=i+10) {
            hoverWithOffset(picture, 0, i);
        }

        bekle(5000);
        driver.quit();



    }

    public void hoverWithOffset(WebElement element, int xOffset, int yOffset){
        new Actions(driver)
                .moveToElement(element, xOffset, yOffset)
                .pause(100)
                .build()
                .perform();
    }




}
