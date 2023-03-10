package gun16.basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest{

    protected WebDriver driver;
    protected WebDriverWait wait;

    //TODO asagidaki methodlari tamamlayin
    // ihtiyaciniz duydugunuz methodlari da ekleyebilirsiniz

    protected void setDriver(WebDriver driver) {

    }

    public void open(String url){

    }

    public void open(String url, String title){

    }

    protected void click(By locator) {

    }

    protected void sendKeys(By locator, String textToSend) {

    }

    protected void clickByAction() {

    }

    protected void clickByAction(By locator) {

    }


    protected void sendKeysByAction(String textToSend) {
    }

    protected void sendKeysByAction(By locator, String textToSend) {

    }

    protected void keyDown(Keys key) {

    }

    protected void keyUp(Keys key) {

    }

    protected void hover(WebElement element) {

    }

    protected void clickAndHold(WebElement element) {

    }

    protected void release() {

    }

    protected boolean isClickable(By locator) {
        return false;
    }

    protected boolean isClickable(WebElement element) {
        return false;
    }

    protected void zoom(double zoomSize){

    }

    public void sleep(long milis){

    }
}
