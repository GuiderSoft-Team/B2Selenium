package gun18;

import gun17.utility.Driver;
import gun17.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotClass extends BaseTest {



    @Test
    public void testRobot1() throws AWTException {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));
        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Basic Auth']")));

        driver.quit();
    }

    @Test
    public void testRobot2() throws AWTException {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        writeWithRobot("admin");
        writeWithRobot(Keys.TAB);
        writeWithRobot("admin");
        writeWithRobot(Keys.TAB);
        writeWithRobot(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Basic Auth']")));

        driver.quit();
    }

    public void writeWithRobot(String str){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < str.length(); i++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
        }
    }

    public void writeWithRobot(Keys key){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        switch (key){
            case TAB -> robot.keyPress(KeyEvent.VK_TAB);
            case ENTER -> robot.keyPress(KeyEvent.VK_ENTER);
            case SHIFT -> robot.keyPress(KeyEvent.VK_SHIFT);
        }

    }


    enum Keys{
        TAB,
        ENTER,
        SHIFT
        ;
    }


    @Test
    public void keyRelease() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_SHIFT);
        writeWithRobot("admin");
        robot.keyRelease(KeyEvent.VK_SHIFT);
        writeWithRobot("admin");


    }

}
