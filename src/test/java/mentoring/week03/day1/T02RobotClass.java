package mentoring.week03.day1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02RobotClass extends TestBase {
     /*
 Go to https://claruswaysda.github.io/downloadUpload.html
 Click on 'Upload'
 Close the opening page using 'CTRL+F4'
 */

    @Test
    void test() throws AWTException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        driver.findElement(By.xpath("//label[normalize-space()='Upload']")).click();

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } else if (os.contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_META);
        }

    }
}
