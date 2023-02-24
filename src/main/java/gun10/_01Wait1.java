package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01Wait1 extends BaseGun10{


    @Test
    public void test1(){
        driver.get("https://opencart.abstracta.us/");
        By lMyAccount = By.xpath("//a//span[.='My Account'] | //a[@title='My Account']");

        //driver.findElement(lMyAccount).click();
        click(lMyAccount);

        By lLoginLink = By.xpath("//a[text()='Login']");
        waitForVisibilityOf(lLoginLink);
        click(lLoginLink);

        By lEMail = By.id("input-email");
        By lPassword = By.id("input-password");
        By lLoginButton = By.xpath("//input[@value='Login']");
        waitForVisibilityOf(lEMail);
        senskeys(lEMail, "deneme@deneme.com");
        senskeys(lPassword, "deneme");

        click(lLoginButton);

        waitForVisibilityOf(By.xpath("//aside//a[text()='Logout']"));
        driver.quit();
    }


}
