package gun17.usedriver;

import gun17.utility.Browsers;
import gun17.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test1 {



    @Test
    public void test1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://google.com");

    }

    @Test
    public void test2(){
        WebDriver driver = Driver.getDriver(Browsers.EDGE);
        driver.get("https://yahoo.com");
        Driver.quitDriver();
    }

    @Test
    public void test3(){
        WebDriver driver = Driver.getDriver(Browsers.EDGE);
        driver.get("http://opencart.abstracta.us/");

    }
    @Test
    public void test4(){
        Driver.quitDriver();
    }
}
