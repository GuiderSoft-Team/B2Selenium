package gun06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestWithStream {

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void getPrice() {

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.clear();
        password.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        By productsTitle = By.xpath("//span[text()='Products']");
        Assert.assertTrue(driver.findElement(productsTitle).isDisplayed());


        By products = By.xpath("//div[@class='inventory_item_name' or @class='inventory_item_price']");

        List<WebElement> list = driver.findElements(products);

        list.forEach(e -> System.out.println(e.getText()));


        System.out.println("--------------------------");

        list.stream()
                .filter(e -> e.getText().contains("$"))
                .toList()
                .forEach(e -> System.out.println(e.getText().replace("$","").concat(" TL")));

        System.out.println("===============================");

        for (WebElement element : list) {
            if (element.getText().contains("$")){
                String text = element.getText().replace("$", "").concat(" TL");
                System.out.println(text);
            }
        }
        driver.quit();


    }
}
