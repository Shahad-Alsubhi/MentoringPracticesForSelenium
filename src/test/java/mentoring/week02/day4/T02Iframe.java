package mentoring.week02.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T02Iframe extends TestBase {

    /*
Go to https://claruswaysda.github.io/iframe.html
Type your name in input
Click on 'Bold' button
Assert the alert message
*/

    @Test
    void test() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/iframe.html");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("input")).sendKeys("John");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("button[aria-label='Bold']")).click();
        String alertText = driver.switchTo().alert().getText();
        String expectedText = "Bold button clicked";
        Assertions.assertEquals(expectedText, alertText);
        driver.switchTo().alert().accept();
    }
}
