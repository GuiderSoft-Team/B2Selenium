package gun17.tests;

import gun17.pages.HomePage;
import gun17.utility.Browsers;
import gun17.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static gun17.utils.Locators.url;


public class Tests {
    WebDriver driver;


    @Test
    public void loginTest(){
        driver = Driver.getDriver(Browsers.EDGE);    // parametre CHROME, EDGE, FIREFOX olabilir
        HomePage homePage = new HomePage(driver);
        homePage.open(url);
        homePage.login("deneme@deneme.com", "deneme");
        homePage.logout();
        Driver.getDriver().quit();      //driver.quit();
    }

    @Test
    public void searchTest(){
        //Driver.getDriver(Browsers.SAFARI);    // parametre CHROME, EDGE, FIREFOX olabilir
        HomePage homePage = new HomePage();
        homePage.open(url);
        homePage.search("mac");
        List<WebElement> list = homePage.getSearchList();
        Assert.assertEquals(list.size(), 4);

        List<WebElement> listMacBook = homePage.getSearchList("MacBook");
        Assert.assertEquals(listMacBook.size(), 3);
        Driver.getDriver().quit();
    }

    @Test
    public void hoverMenu(){
        /*
            1.  Ana menü üzerinde bastan sona 500ms bekleme ile hover edecek
                a.  Ana menüdeki 8 adet li'yi bulan locator'i bulun
                b.  Bu locator ile 8 adet menüyü list'e atin
                c.  BaseTest'teki hover() ve actionWait()'i kullanarak
                    menü üzerinde bastan sona gezinti yapin

         */

        HomePage homePage = new HomePage();
        homePage.open(url);
        homePage.walkOverMenu();
        Driver.getDriver().quit();
    }
}
