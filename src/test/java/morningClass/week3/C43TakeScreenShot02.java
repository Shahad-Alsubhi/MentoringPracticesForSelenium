package morningClass.week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C43TakeScreenShot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws IOException {
        driver.get("https://www.linkedin.com/");
        WebElement element = driver.findElement(By.xpath("//icon[@data-test-id=\"nav-logo\"]"));
        takeScreenShot(driver);
        takeScreenshotOfElement(driver, element);

    }
}
