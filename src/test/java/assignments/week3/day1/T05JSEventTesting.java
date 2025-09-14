package assignments.week3.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05JSEventTesting extends TestBase {
/*
 Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
 Click all the buttons and verify they are all clicked
 */

    @Test
    void test() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement onBlur = driver.findElement(By.id("onblur"));
        js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", onBlur);
        Assertions.assertTrue(driver.findElement(By.id("onblurstatus")).isDisplayed());

        WebElement onClick = driver.findElement(By.id("onclick"));
        js.executeScript("arguments[0].click();", onClick);
        Assertions.assertTrue(driver.findElement(By.id("onclickstatus")).isDisplayed());

        WebElement onContextMenu = driver.findElement(By.id("oncontextmenu"));
        js.executeScript("arguments[0].dispatchEvent(new Event(\"contextmenu\"))", onContextMenu);
        Assertions.assertTrue(driver.findElement(By.id("oncontextmenustatus")).isDisplayed());

        WebElement onDoubleClick = driver.findElement(By.id("ondoubleclick"));
        js.executeScript("arguments[0].dispatchEvent(new Event(\"dblclick\"))", onDoubleClick);
        Assertions.assertTrue(driver.findElement(By.id("ondoubleclickstatus")).isDisplayed());

        WebElement onFocus = driver.findElement(By.id("onfocus"));
        js.executeScript("arguments[0].dispatchEvent(new Event('focus'))", onFocus);
        Assertions.assertTrue(driver.findElement(By.id("onfocusstatus")).isDisplayed());

        Thread.sleep(3000);

        //key events
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));
        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown'))", onKeyDown);
        Assertions.assertTrue(driver.findElement(By.id("onkeydownstatus")).isDisplayed());

        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keyup'))", onKeyUp);
        Assertions.assertTrue(driver.findElement(By.id("onkeyupstatus")).isDisplayed());

        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keypress'))", onKeyPress);
        Assertions.assertTrue(driver.findElement(By.id("onkeypressstatus")).isDisplayed());


        Thread.sleep(3000);

        //mouse events
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover'))", onMouseOver);
        Assertions.assertTrue(driver.findElement(By.id("onmouseoverstatus")).isDisplayed());

        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseleave'))", onMouseLeave);
        Assertions.assertTrue(driver.findElement(By.id("onmouseleavestatus")).isDisplayed());

        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown'))", onMouseDown);
        Assertions.assertTrue(driver.findElement(By.id("onmousedownstatus")).isDisplayed());

    }

}
