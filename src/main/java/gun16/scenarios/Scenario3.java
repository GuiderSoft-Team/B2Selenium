package gun16.scenarios;

import gun16.basetest.BaseTest;
import gun16.utility.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Scenario3 extends BaseTest {

    //WebDriver driver = Driver.getDriver(Browsers.FIREFOX);

    @Test
    public void scenario3() {
        /*
            1.  https://demowebshop.tricentis.com/  sayfasina gidin
            2.  login olun, (isterseniz HomePage class'ini kullanabilirsiniz)
            3.  "computer" aratin
            4.  ismi "Simple Computer" a tiklayin
            5.  processor secin
            6.  ürünü sepete ekleyin ve ürünün eklendigini sayfanin üst kisminda
                beliren notification ile assert edin. (text, vs)
            5.  Menüdeki shopping chart'a tiklayin
            6.  ürün miktarini 2 yapin ve sepeti update edin. "Update Shopping Cart"
            7.  "Checkout" ile devam edin ve ürünün alim islemini tamamlayin
            8.  Ürünün satin order isleminin tamamlandigindan emin olun.

         */

        HomePage homePage = new HomePage(Browsers.CHROME);
        homePage.login("abc123@aa.com", "123456");
        homePage.search("computer");
        WebElement selectedProd = driver
                .findElements(By.xpath("//div[@class='item-box']"))
                .stream().filter(e -> e.getText().contains("Simple Computer"))
                .collect(Collectors.toList())
                .get(0);

        By lProdName = By.cssSelector(".product-title");
        String prodName = selectedProd.findElement(lProdName).getText();

        By lProdPrice = By.cssSelector(".prices");
        String prodPrice = selectedProd.findElement(lProdPrice).getText();
        selectedProd.click();
        wait.until(ExpectedConditions.titleContains("Simple Computer"));

        By lProdNameInDetail = By.cssSelector(".product-name");
        By lProdPriceDetail = By.cssSelector(".product-price");
        wait.until(ExpectedConditions.textToBe(lProdNameInDetail, prodName));
        wait.until(ExpectedConditions.textToBe(lProdPriceDetail, prodPrice));
        By lProcessorSlow = By.xpath("//input[@type='radio' and ./parent::li//*[contains(text(),'Slow')]]");
        click(lProcessorSlow);

        By lAddToCartDetail = By.xpath("//div[@class='product-essential']//input[@value='Add to cart']");
        click(lAddToCartDetail);

        By lNotificationBar = By.id("bar-notification");
        wait.until(ExpectedConditions.textMatches(lNotificationBar, Pattern.compile("shopping cart")));
        homePage.clickMenu("Shopping");
        wait.until(ExpectedConditions.titleContains("Shopping Cart"));

        By lTermOfUse = By.id("termsofservice");
        click(lTermOfUse);
        click(By.id("checkout"));
        click(By.cssSelector("#billing-buttons-container input"));
        click(By.cssSelector("#shipping-buttons-container input"));
        click(By.cssSelector("#shipping-method-buttons-container input"));
        click(By.cssSelector("input[value='Payments.CashOnDelivery']"));
        click(By.cssSelector("#payment-method-buttons-container input"));
        click(By.cssSelector("#payment-info-buttons-container input"));
        click(By.cssSelector("#confirm-order-buttons-container input"));
        By lSuccessMessage = By.xpath("//*[.='Your order has been successfully processed!']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSuccessMessage));

        driver.quit();
    }


}
