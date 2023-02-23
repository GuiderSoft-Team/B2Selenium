package gun09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import static gun09.MyLocatorsClass.*;

public class _02ElementInElement  {

    WebDriver driver;
    WebDriverWait wait;

    public _02ElementInElement(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void elementInElement1(){

        driver.get("https://demoqa.com/text-box");

        WebElement firstRow = driver.findElement(By.xpath("(//div[@class='row'])[1]"));


        // element icinde element aranailir
        // xpath de alt element aranirken ikinci xpath  (.) (current element) ile baslamali
        // diger selectorler icin böyle bir sarta ihtiyac yok
        firstRow.findElement(By.xpath("./div"));


        driver.quit();

    }



    @Test
    public void test2WriteIds(){
        /*
            https://demoqa.com/text-box
            adresideki id'si "userForm" olan formun altindaki tüm input'larin id'lerini consola yazdirin
         */
        driver.get("https://demoqa.com/text-box");

        By lForm = By.id("userForm");
        WebElement eForm = wait.until(ExpectedConditions.presenceOfElementLocated(lForm));

        //List<WebElement> list = eForm.findElements(By.xpath(".//input | .//textarea"));
        List<WebElement> list = eForm.findElements(By.cssSelector("input, textarea"));

        for (WebElement element : list) {
            System.out.println(element.getAttribute("id"));
        }

        driver.quit();
    }



}
