package gun16.scenarios;


import gun16.basetest.BaseTest;
import gun16.utility.Browsers;
import gun16.utility.Driver;
import org.testng.annotations.Test;


public class ZoomPage extends BaseTest {

    @Test
    public void hoverMenu(){
        setDriver(Driver.getDriver(Browsers.EDGE));

        driver.get("http://opencart.abstracta.us/");

        for (int i = 10; i < 40; i+=2) {
            zoom(i/20.);
            sleep(500);
        }


        driver.quit();


    }


}
