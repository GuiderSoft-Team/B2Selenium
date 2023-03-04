package gun15;

import gun14.BaseActionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static utils.Utils.bekle;

public class DragDrop1 extends BaseActionsClass {

    String url = "https://demoqa.com/droppable";
    By lSimpleTab = By.xpath("//a[text()='Simple']");
    By lDraggable = By.id("draggable");
    By lDroppable = By.id("droppable");

    @Test
    public void dragDrop1(){

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSimpleTab));

        WebElement eDraggable = driver.findElement(lDraggable);
        WebElement eDroppable = driver.findElement(lDroppable);

        new Actions(driver)
                .clickAndHold(eDraggable)
                .moveToElement(eDroppable,-100, 100)
                .release()
                .build()
                .perform();

        bekle(3000);
        driver.quit();
    }

    @Test
    public void dragDrop2(){

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSimpleTab));

        WebElement eDraggable = driver.findElement(lDraggable);
        WebElement eDroppable = driver.findElement(lDroppable);

        new Actions(driver)
                .pause(500)
                .dragAndDrop(eDraggable, eDroppable)
                .build()
                .perform();

        bekle(3000);
        driver.quit();

        /*
            elemente tikla ve tut
            100 px saga kaydir
            elementi birak


        new Actions(driver)
                .clickAndHold(eDraggable)
                .moveByOffset(100,0)
                .release()
                .build()
                .perform();
       */
    }

}
