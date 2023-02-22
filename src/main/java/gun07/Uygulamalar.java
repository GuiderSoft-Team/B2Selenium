package gun07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Utils;

public class Uygulamalar {
    /*
        1.  https://bonigarcia.dev/selenium-webdriver-java/index.html
        2.  Web Form'a tikla
        3. Acilan sayfada kac adet input var, consol'a yazdirin
     */
    WebDriver driver;
    @Test
    public void boniegarcia1(){

        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By webForm = By.xpath("//a[text()='Web form']");
        WebElement link = driver.findElement(webForm);
        link.click();

        By inputs = By.cssSelector("input");
        System.out.println(driver.findElements(inputs).size());

        By mdInput = By.name("my-disabled");
        WebElement disabledInput = driver.findElement(mdInput);
        System.out.println(disabledInput.getAttribute("class"));
        System.out.println(disabledInput.getAttribute("type"));
        System.out.println(disabledInput.getAttribute("placeholder"));

        driver.quit();
    }


}
