package gun18;

import gun17.utility.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void screenShot1() throws IOException {

        driver.get("http://opencart.abstracta.us/");
        wait.until(ExpectedConditions.titleContains("Your Store"));

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenshots/resim.png");
        FileUtils.copyFile(source, target);

        driver.quit();

    }


    @Test
    public void screenShot2() {

        driver.get("http://opencart.abstracta.us/");
        wait.until(ExpectedConditions.titleContains("Your Store"));

        getScreenShot();

        driver.quit();

    }

    @Test
    public void screenShot3() {
        try {
            driver.get("http://opencart.abstracta.us/");

            wait.until(ExpectedConditions.titleContains("Your Store1"));

            driver.quit();

        } catch (Exception e) {
            getScreenShot();
            driver.quit();
        }
    }


    private void getScreenShot() {
        String name = "Resim_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd H_m_s"));
        getScreenShot(name);
    }

    public void getScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
