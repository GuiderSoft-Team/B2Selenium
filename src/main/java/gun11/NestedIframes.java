package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedIframes {

    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://demoqa.com/nestedframes";

    @Test
    public void nestedIFrames(){
        // ana penceredyiz
        driver.get(url);

        // body ana pencerenin body'si
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        // frame1'e atladik
        driver.switchTo().frame("frame1");

        // body frame1'in body'si
        // frame1 icinde driver.findElement(By) ile aranan tütm selectorler frame1 icinde aranir
        // be parentFrame'de ne de child iframe icinde aranmaz
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        // frame1 icinde yalniz 1 adet iframa var. index kullanilabilir, ifame element olarak da tanimlanabilir
        WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrame);
        //driver.switchTo().frame(0);

        System.out.println(driver.findElement(By.cssSelector("p")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector("#framesWrapper>div")).getText());



        driver.quit();

    }
}
