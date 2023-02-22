package gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class DialogOpen {

    WebDriver driver;

    @Test
    public void openDialog(){
        driver = Utils.getChromeDriver();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showSmallModal")).click();
        WebElement closeButton = driver.findElement(By.id("closeSmallModal"));
        Assert.assertTrue(closeButton.isDisplayed());
        closeButton.click();
        Utils.bekle(300);
        int sizeOfCloseButton = driver.findElements(By.id("closeSmallModal")).size();
        Assert.assertEquals(sizeOfCloseButton, 0);
        driver.quit();
    }

}
