package gun16.scenarios;

import gun16.utility.Browsers;
import gun16.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage() {
        this(Browsers.CHROME);
    }

    public HomePage(Browsers browser) {
        this.driver = Driver.getDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    String url = "https://demowebshop.tricentis.com/";


    String sMainMenuLinks = "//div[@class=\"header-links\"]//a[contains(.,\"{0}\")]";
    By lLoginFormUsername = By.id("Email");
    By lLoginFormPassword = By.id("Password");
    By lLoginSubmitButton = By.cssSelector("input[value='Log in']");
    By lSearchInput = By.id("small-searchterms");
    By lSearchButton = By.cssSelector("input[value='Search']");
    By lSearchedProducts = By.cssSelector(".search-results .item-box");

    // hint, 123
    public void open() {
        driver.get(url);
    }

    public By getLocatorMenuOf(String text) {
        return By.xpath("//div[@class='header-links']//a[contains(.,'" + text + "')]");
        //return By.xpath(MessageFormat.format(sMainMenuLinks, text));
    }


    public boolean login(String username, String password) {
        By menuLocator = getLocatorMenuOf("Log in");
        click(menuLocator);
        sendKeys(lLoginFormUsername, username);
        sendKeys(lLoginFormPassword, password);
        //click(lLoginSubmitButton);
        pressEnter();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorMenuOf("Log out")));
        int x = driver.findElements(getLocatorMenuOf("Log out")).size();
        return x >= 1;
    }

    public void clickMenu(String menuText) {
        //Menu locator bulunur
        By menuLocator = getLocatorMenuOf(menuText);
        click(menuLocator);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, String textToSend){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToSend);
    }

    public List<WebElement> search(String textToSearch) {
        sendKeys(lSearchInput, textToSearch);
        click(lSearchButton);
        wait.until(ExpectedConditions.titleContains("Search"));
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lSearchedProducts, 0));
        return driver.findElements(lSearchedProducts);
    }

    public int search(String textToSearch, String productText) {
        return 0;
    }

    public void scrollIntoView(WebElement element) {

    }


    public void pressEnter() {
        new Actions(driver).sendKeys(Keys.ENTER);
    }
}
