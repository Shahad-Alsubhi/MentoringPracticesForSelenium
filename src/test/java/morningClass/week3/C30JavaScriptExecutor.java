package morningClass.week3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C30JavaScriptExecutor extends TestBase {

    @Test
    public void JscriptExecutorTtest1() {
        driver.get("https://google.com");

        // Create JavaScript Executor object

        // We can execute JavaScript Codes with executeScript()

    }

    @Test
    void dummyTest02() throws InterruptedException {
        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        //Double-click on the blue square at the bottom of the page and then write the changed color.
        WebElement square = driver.findElement(By.xpath("//span[.=\"Double click the block\"]//preceding::div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", square);
        String backgroundBefore = square.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.doubleClick(square).perform();
        String backgroundAfter = square.getCssValue("background-color");
        Assertions.assertEquals("rgba(255, 255, 0, 1)", backgroundAfter);
        driver.switchTo().defaultContent();
        // scrollto the top of the page by js
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
        // scrollto the bottom of the page by js
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

    }

}
