package gun09;

import org.openqa.selenium.By;

public interface MyLocatorsInterface {
    By lName = By.id("userName");
    By lEMail = By.id("userEmail");
    By lCAdress = By.id("currentAddress");
    By lPAdress = By.id("permanentAddress");
    By lSubmit = By.id("submit");
}
