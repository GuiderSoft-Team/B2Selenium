package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RandomProductSelection {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://www.saucedemo.com/";
    By username = By.id("user-name");
    By password = By.id("password");
    By lProducts = By.cssSelector(".inventory_item");

    @Test
    public void selectRandomProduct() {
        setupDriver();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("standard_user");
        driver.findElement(password).sendKeys("secret_sauce" + Keys.ENTER);
        //driver.findElement(password).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.numberOfElementsToBe(lProducts, 6));
        List<WebElement> eProducts = driver.findElements(lProducts);

        int rndomNumber = new Random().nextInt(eProducts.size());

        WebElement selectedProd = eProducts.get(rndomNumber);

        String pName = selectedProd
                .findElement(By.cssSelector(".inventory_item_name"))
                .getText();

        String pPrice = selectedProd
                .findElement(By.cssSelector(".inventory_item_price"))
                .getText()
                .replaceAll("[^0-9.]", "");

        System.out.println("Name, Price\n" + pName + ", " + pPrice);

        selectedProd.findElement(By.cssSelector(".inventory_item_name")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));

        WebElement container = driver.findElement(By.id("inventory_item_container"));
        //WebElement container = driver.findElement(By.cssSelector("html"));

        System.out.println("Container Text\n" + container.getText());

        Assert.assertTrue(container.getText().contains(pName));
        Assert.assertTrue(container.getText().contains(pPrice));

        tearDown();
    }


    void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    void tearDown() {
        driver.quit();
    }


}

