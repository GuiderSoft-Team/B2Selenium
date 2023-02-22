package gun05.odev;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev3 extends BaseClass20230217{

    /*
        Scenario-3
        1. https://automationexercise.com/ sayfasina gidin
        2. Menüde Products'a tiklayin
        3. Acilan sayfada Search Product inputbox'ina "Men Tshirt" send edin
        4. Input box yanindaki button'a tiklayin
        5. Arama sonucunda listelenen ürünün
             a. kodunun "Rs. 400"
             b. adinin "Men Tshirt"
           oldugunu assert edin. (AssertEquals)
     */

    @Test
    public void odev3(){
        String url = "https://automationexercise.com/";
        setDriver();
        navigateTo(url);

        By linkProducts = By.xpath("//ul//a[contains(text(), 'Prod')]");

        click(linkProducts);
        sleep(3000);
        By searchBox = By.cssSelector("#search_product");
        sendkeys(searchBox, "Men Tshirt");
        By searchButton = By.cssSelector("#submit_search");
        click(searchButton);

        By productCode = By.cssSelector(".productinfo.text-center h2");
        By productName = By.cssSelector(".productinfo p");

        Assert.assertEquals(driver.findElement(productCode).getText(), "Rs. 400");
        Assert.assertEquals(driver.findElement(productName).getText(), "Men Tshirt");

        quitDriver();

    }



}
