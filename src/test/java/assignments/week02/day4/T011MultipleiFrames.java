package assignments.week02.day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T011MultipleiFrames extends TestBase {

     /*
 Go to URL: http://demo.guru99.com/test/guru99home/
 1. Find the number of iframes on the page
 2. Switch to the third iframe (JMeter Made Easy)
 3. Click the link (https://www.guru99.com/live-selenium-project.html)
 4. Exit the iframe and return to the main page
 */

    String url = "http://demo.guru99.com/test/guru99home/";

    @Test
    void test() throws InterruptedException {
        driver.get(url);
        int numberOfIframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iframes on the page: " + numberOfIframes);
        // Switch to iframe (JMeter Made Easy)
        driver.switchTo().frame("a077aa5e");
        // Click the link
        driver.findElement(By.tagName("a")).click();
        // Exit the iframe and return to the main page
        driver.switchTo().defaultContent();

    }

}
