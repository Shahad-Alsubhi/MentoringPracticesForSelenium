package morningClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C20WindowsHandle01 extends TestBase {
    /*
    Open empty window
    Go to https://www.google.com/ in the open tab
    Create new tab
    Go to https://www.linkedin.com/ in the open tab
    Create new window
    Go to https://clarusway.com/ in the window that opens
*/

    @Test
    void test() {
        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.get("about:blank");
        driver.get("https://www.google.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://clarusway.com/");

    }
}
