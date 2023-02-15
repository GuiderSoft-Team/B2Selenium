package gun03;

import org.openqa.selenium.By;

public class _04Selectors {
    public static void main(String[] args) {
        By id = By.id("div[id=\"logo\"]");
        By id1 = By.id("div[id='logo']");
        By.xpath("//div[@id='content']");
    }
}
