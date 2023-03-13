package gun18;

import gun17.utils.BaseTest;
import org.testng.annotations.Test;

public class FederalAuthentication extends BaseTest {
    @Test
    public void testFedAuth(){
        // https://site.adresi.com
        // https://[kullaniciAdi]:[password]@site.adresi.com
        // bu kullanim ise yaramaz


        String username = "username";
        String password = "password";
        String url = "https://site.adresi.com";

        driver.get(url);
        driver.get(driver.getCurrentUrl().replace("https://", "https://"+username + ":" + password + "@"));


    }

}
