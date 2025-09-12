package assignments.week02.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class T02ActionsClass extends TestBase {
     /*
 Go to https://claruswaysda.github.io/submit-button.html
 Click on submit
 Verify link contains 'actionsClickDrag'
 Drag 'Drag me' to 'Drop here'
 Right-click on 'Right-click' me
 Double-click on 'Double-click me'
 Hover on 'Hover over me'
 Verify all actions' success messages.
 */

    String url = "https://claruswaysda.github.io/submit-button.html";
    By dragMe = By.id("drag1");
    By dropHere = By.id("drop1");
    By rightClickMe = By.id("showSuccessButton");
    By doubleClickMe = By.id("doubleClickButton");
    By hoverOverMe = By.id("hoverButton");

    @Test
    void test() {
        driver.get(url);
        String mainHandle = driver.getWindowHandle();
        driver.findElement(By.id("submitButton")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("actionsClickDrag"), "URL does not contain 'actionsClickDrag'");


        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragMe), driver.findElement(dropHere));

        actions.contextClick(driver.findElement(rightClickMe)).perform();
        Assertions.assertTrue(driver.findElement(By.id("rightClickSuccessMessage")).isDisplayed());

        actions.doubleClick(driver.findElement(doubleClickMe)).perform();
        Assertions.assertTrue(driver.findElement(By.id("doubleClickSuccessMessage")).isDisplayed());

        actions.moveToElement(driver.findElement(hoverOverMe)).perform();
        Assertions.assertTrue(driver.findElement(By.id("hoverSuccessMessage")).isDisplayed());


    }

}
