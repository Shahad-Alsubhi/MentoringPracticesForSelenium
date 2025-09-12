package mentoring.week02.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02CheckboxInteraction {

       /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

    WebDriver driver;

    @Test
    void checkboxTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assertions.assertTrue(checkbox1.isSelected());
        Assertions.assertTrue(checkbox2.isSelected());
        System.out.println("Checkbox 1 is selected: " + checkbox1.isSelected());
        System.out.println("Checkbox 2 is selected: " + checkbox2.isSelected());

        driver.quit();
    }
}
