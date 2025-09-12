package assignments.week02.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class T03DragandDrop extends TestBase {
    /*
 Go to https://claruswaysda.github.io/dragAndDrop.html
 Drag the items in their right places
 Assert the success message
 */

    String url = "https://claruswaysda.github.io/dragAndDrop.html";

    By piece1 = By.id("piece1");
    By piece2 = By.id("piece2");
    By piece3 = By.id("piece3");
    By slot1 = By.id("slot1");
    By slot2 = By.id("slot2");
    By slot3 = By.id("slot3");
    By successMessage = By.id("celebrate");

    @Test
    void test() {
        driver.get(url);

        WebElement drag1 = driver.findElement(piece1);
        WebElement drag2 = driver.findElement(piece2);
        WebElement drag3 = driver.findElement(piece3);
        WebElement drop1 = driver.findElement(slot1);
        WebElement drop2 = driver.findElement(slot2);
        WebElement drop3 = driver.findElement(slot3);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag1, drop1).perform();
        actions.dragAndDrop(drag2, drop2).perform();
        actions.dragAndDrop(drag3, drop3).perform();
        Assertions.assertTrue(driver.findElement(successMessage).isDisplayed());

    }

}
