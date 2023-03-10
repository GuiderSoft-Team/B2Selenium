package gun18.oop;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {
    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));

        write("GuiderShoft");

    }

    public static void write(String str) throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < str.length(); i++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
        }
    }

}
