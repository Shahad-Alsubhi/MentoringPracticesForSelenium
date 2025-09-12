package assignments.week02.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T04Drawing extends TestBase {
 /*
 Go to https://claruswaysda.github.io/Draw.html
 Draw a triangle
 Reset
 */

    String url = "https://claruswaysda.github.io/Draw.html";

    @Test
    void test() {
        driver.get(url);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("myCanvas"))).perform();
        actions.clickAndHold().moveByOffset(50, 0)
                .moveByOffset(0, 50)
                .moveByOffset(-50, 0)
                .moveByOffset(0, -50)
                .release().perform();
        driver.findElement(By.id("resetButton")).click();

    }


}
