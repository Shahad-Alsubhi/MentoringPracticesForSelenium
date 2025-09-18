package morningClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C22WindowsHandle03 extends TestBase {

    /*
Go to URL: https://the-internet.herokuapp.com/windows
Verify the text: “Opening a new window”
Verify the title of the page is “The Internet”
Click on the “Click Here” button
Verify the new window title is “New Window”
Go back to the previous window and then verify the title: “The Internet”
*/

    String expectedHeading = "Opening a new window";
    By headingByXpath = By.xpath("//h3[.='Opening a new window']");
    By clickHereBylinkText = By.linkText("Click Here");

    @Test
    void test() {
        //Go to URL: https://the-internet.herokuapp.com/windows

        driver.get("https://the-internet.herokuapp.com/windows");
        //Verify the text: “Opening a new window”
        String actualHeading = driver.findElement(headingByXpath).getText();
        Assertions.assertEquals(expectedHeading, actualHeading, "Heading is not as expected");

        //Verify the title of the page is “The Internet”
        Assertions.assertTrue(driver.getTitle().equals("The Internet"), "Title is not as expected");


        //Click on the “Click Here” button
        driver.findElement(clickHereBylinkText).click();

        String handle1 = driver.getWindowHandle();
        //Verify the new window title is “New Window”
        String handle2 = "";
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(handle1)) {
                handle2 = handle;
            }
        }
        driver.switchTo().window(handle2);
        //Go back to the previous window and then verify the title: “The Internet”
        Assertions.assertTrue(driver.getTitle().equals("New Window"), "Title is not as expected");
    }
}
