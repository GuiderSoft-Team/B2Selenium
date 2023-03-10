package gun16.scenarios;


import gun16.basetest.BaseTest;
import gun16.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class Scenario2 extends BaseTest {


    WebDriver driver = Driver.getDriver();
    //WebDriver driver = Driver.getDriver(Browsers.FIREFOX);

    By lProdName = By.cssSelector(".product-title");
    By lProdPrice = By.cssSelector(".prices");

    By lProdNameInDetail = By.cssSelector(".product-name");
    By lProdPriceDetail = By.cssSelector(".product-price");

    @Test
    public void scenario2() {
        /*
            1.  https://demowebshop.tricentis.com/  sayfasina gidin
            2.  login olun, (isterseniz HomePage class'ini kullanabilirsiniz)
            3.  "desktop" aratin
            4.  isminde "Elite" olanin fiyatini ve tam ismini kaydedin
            5.  Ürüne tiklayip etaylarini görüntüleyin.
            6.  Detay sayfasindaki fiyat ve ismin kaydettiginiz ile ayni oldugunu assert edin

         */

        setDriver(Driver.getDriver());
        open("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage();
        homePage.login("abc123@aa.com", "123456");
        homePage.search("desktop");
        WebElement selectedProd = driver
                .findElements(By.xpath("//div[@class='item-box']"))
                .stream().filter(e -> e.getText().contains("Elite"))
                .collect(Collectors.toList())
                .get(0);

        String prodName = selectedProd.findElement(lProdName).getText();
        String prodPrice = selectedProd.findElement(lProdPrice).getText();
        selectedProd.click();
        wait.until(ExpectedConditions.titleContains("Elite"));

        wait.until(ExpectedConditions.textToBe(lProdNameInDetail, prodName));
        wait.until(ExpectedConditions.textToBe(lProdPriceDetail, prodPrice));

        driver.quit();
    }

}
