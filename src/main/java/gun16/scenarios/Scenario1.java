package gun16.scenarios;

import gun16.utility.Browsers;
import gun16.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Scenario1 {

    WebDriver driver;
    //WebDriver driver = Driver.getDriver(Browsers.EDGE);
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    @Test
    public void scenario1(){
        /*

            2.  HomePage class'ini kullanarak login olun

                HomePage homePage = new HomePage(driver);
                homePage.login("username", "password");
                homePage.search("mac");
                gibi
            3.  comp aratin ve 7 ürün listelendigini assert edin
            4.  "Add to Cart" olan 4 ürün oldugunu assert edin.
                Burada "Add to Cart" iceren ürün sayisini veren güzel bir xpath yazmalisiniz
         */

        driver = Driver.getDriver();
        HomePage homePage = new HomePage(Browsers.EDGE);
        homePage.open();
        System.out.println(homePage.login(myUsername, myPassword));

        List<WebElement> searhedProducts = homePage.search("comp");
        int prods = searhedProducts.size();
        Assert.assertEquals(prods, 7);

        int addToCart = driver.findElements(By.cssSelector(".search-results  .item-box input")).size();
        Assert.assertEquals(addToCart, 6);

        Driver.getDriver().quit();

    }

    @Test
    public void test2(){
        HomePage hp = new HomePage(Browsers.EDGE);
        hp.open();
        hp.login(myUsername, myPassword);
        Driver.getDriver().quit();
    }



}
