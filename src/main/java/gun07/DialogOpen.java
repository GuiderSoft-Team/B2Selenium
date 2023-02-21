package gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Utils;

public class DialogOpen {

    WebDriver driver;

    @Test
    public void openDialog(){
        driver = Utils.getChromeDriver();







        driver.quit();
    }

}
