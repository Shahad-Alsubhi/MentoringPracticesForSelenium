package mentoring.week03.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T01JSExecutor extends TestBase {
    /*
 Go to https://claruswaysda.github.io/signIn.html
 enter username 'admin'
 enter password '123'
 Click on Sign In
 Assert the 'Employee Table' is visible
 Create a method to change border color and style of web elements.
 Use the method on each element you interact with.
 */

    @Test
    void test() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign In']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        changeStyleAndFill(username, "admin", js);
        changeStyleAndFill(password, "123", js);
        signInButton.click();
        Assertions.assertTrue(driver.findElement(By.id("employeeTable")).isDisplayed());


    }

    void changeStyleAndFill(WebElement element, String value, JavascriptExecutor js) throws InterruptedException {

        js.executeScript("arguments[0].style.border='2px solid blue' ", element);
        Thread.sleep(1000);
        js.executeScript("arguments[0].value='" + value + "'", element);
    }
}
