package morningClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C23WindowsHandle04 extends TestBase {

    /*
        Open https://www.google.com/ in the opened tab
        Create a new tab
        Open https://www.instagram.com/ in the opened window
        Create a new window
        Open https://www.linkedin.com/ in the opened tab
        Switch to the instagram tab and write 'You found the instagram tab' in the email area
*/

    @Test
    void test() {
        //        Open https://www.google.com/ in the opened tab
        driver.get("https://www.google.com/");
        //        Create a new tab
        driver.switchTo().newWindow(WindowType.WINDOW);

        //        Open https://www.instagram.com/ in the opened window

        driver.get("https://www.instagram.com/");
        //        Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String instagramHandle = driver.getWindowHandle();
        //        Open https://www.linkedin.com/ in the opened tab
        driver.get("https://www.linkedin.com/");
        //        Switch to the instagram tab and write 'You found the instagram tab' in the email area
        driver.switchTo().window(instagramHandle);
        driver.findElement(By.name("username")).sendKeys("You found the instagram tab");

    }
}
