package mentoring.week02.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T03DeleteChars extends TestBase {
    /*
Go to https://claruswaysda.github.io/deleteChars.html
Enter your full name
Delete the letters
Verify the message 'Deleted'
*/

    @Test
    void test() throws InterruptedException {
        String name = "Shahad";
        driver.get("https://claruswaysda.github.io/deleteChars.html");

        driver.findElement(By.id("inputText")).sendKeys(name);

        driver.findElement(By.id("enterButton")).click();

        WebElement deleteBtn = driver.findElement(By.id("deleteButton"));
        for (int i = 0; i < name.length(); i++) {
            deleteBtn.click();
        }
        String deleteMessage = driver.findElement(By.id("deletedMessage")).getText();
        String expectedMessage = "Deleted";
        Assertions.assertEquals(expectedMessage, deleteMessage);

    }
}