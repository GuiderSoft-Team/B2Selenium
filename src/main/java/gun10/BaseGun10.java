package gun10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseGun10 {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseGun10(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /*
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
     */

    public void click(By locator){
        wait.until(driver1 -> {
            try {
                driver1.findElement(locator).click();
                return true;
            }catch (Exception e){
                return false;
            }
        });

    }


    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebElement waitForVisibilityOf(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void senskeys(By locator, String text){
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = waitForVisibilityOf(locator);
        element.clear();
        element.sendKeys(text);
    }
}
