package gun07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverExp {

    WebDriver driver;

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Test
    public void test1(){
        driver = getDriver();

        driver.get("https://");

        driver.getTitle();

        driver.getCurrentUrl();

        driver.manage().window().maximize();

        driver.manage().window().minimize();

        // pencerenin sol üst köse noktasi, soldan 10, yukaridan 20 birim asagida
        driver.manage().window().setPosition(new Point(10, 20));

        // window site 500X600, width x heigth
        driver.manage().window().setSize(new Dimension(500, 600));



        By.id("");
        By.name("");
        By.className("");

        By.linkText("");    // link textin tümü                 text()=''
        By.partialLinkText("Railly");   // link textin parcasi, contains(text(), '')

        By.cssSelector("");
        By.xpath("");


        // action
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).clear();
        driver.findElement(By.id("")).sendKeys("text");

        // konditions
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isSelected();
        driver.findElement(By.id("")).isEnabled();


        // bilgi
        driver.findElement(By.id("")).getText();
        //....
    }




}
