package gun13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WindowSwitcTo {


    WebDriver driver;
    WebDriverWait wait;

    public WindowSwitcTo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    String url = "https://demoqa.com/browser-windows";
    By lTabButton = By.id("tabButton");
    By lText = By.id("sampleHeading");

    @Test
    public void switchToWin1(){

        driver.get(url);
        driver.findElement(lTabButton).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWin = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();

        /*
            driver.getWindowHandle()  = "W-weferwerwererw"
            driver.getWindowHandles() = {W-qweqweqqweqweqw, W-weferwerwererw}
        */



        for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWin)){
                driver.switchTo().window(win);
                break;
            }
        }


        System.out.println(driver.findElement(lText).getText());

        driver.close(); // aktif pencereyi kapatir
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));

        /*
        wait.until(driver->{
            try {
                driver.findElement(lText);
                return false;
            }catch (Exception e){
                return true;
            }
        });

         */

        /*
        if (driver.findElements(lText).size() <= 0){

        }

         */

        /*
        try{
            driver.findElement(lText);
            System.out.println("Hata");
            System.exit(1);
        }catch (Exception ignored){

        }

         */


        driver.switchTo().window(mainWin);
        driver.findElement(lTabButton).click();

        Utils.bekle(2000);
        driver.quit();

    }



}
