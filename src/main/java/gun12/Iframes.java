package gun12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes {

    WebDriver driver;
    WebDriverWait wait;

    public Iframes(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top");   // üst frame

        // üst frame'in ilk sub frame'i
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();

        // üst frame'in ikinci frame'i
        By lFrame2 = By.cssSelector("[name='frame-middle']");
        WebElement eFrame2 = driver.findElement(lFrame2);
        driver.switchTo().frame(eFrame2);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();


        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();


        driver.switchTo().frame("frame-bottom");    // alt frame
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();

        driver.quit();
    }


    {
        By.id("id1");                       //*[@id='id1']          [id='id1']          = #id1
        By.className("class1");             //*[@class='class1'],   [class='class1']    = .class1
        By.name("");
        By.tagName("div");                 //div,                   div
        By.linkText("Nested Frames");      //a[text()='Nested Frames']
        By.partialLinkText("");             //a[contains(text(),'Nested Frames')]
        By.cssSelector("");
        By.xpath("");
    }




}
