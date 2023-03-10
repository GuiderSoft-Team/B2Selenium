package gun17.utils;

import org.openqa.selenium.By;

public interface Locators {

    String url = "http://opencart.abstracta.us/";

    By lLoginLink = By.xpath("//div[@id='top-links']//a[text()='Login']");
    By lMyAccount = By.xpath("//div[@id='top-links']//a[contains(.,'My Account')]");
    By lLoginFormUsername = By.id("input-email");
    By lLoginFormPassword = By.cssSelector("#input-password");
    By lLoginFormSubmitButton = By.cssSelector("input[value='Login']");
    //By lMyAccountText = By.xpath("//div[@id='content']/h2[text()='My Account']");
    By lLogoutLink = By.xpath("//div[@id='top-links']//a[text()='Logout']");



    By lSearchInput = By.cssSelector("#search > input");
    By lSearchButton = By.cssSelector("#search button");

    By lListedProducts = By.cssSelector(".product-thumb");

    By lMainMenuLinks = By.cssSelector(".nav.navbar-nav > li");

}
