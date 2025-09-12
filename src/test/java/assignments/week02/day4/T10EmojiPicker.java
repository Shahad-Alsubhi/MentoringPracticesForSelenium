package assignments.week02.day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T10EmojiPicker extends TestBase {
    /*
 Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
 1. Maximize the website
 2. Click on the second emoji
 3. Click on all second emoji items
 4. Return to the parent iframe
 5. Fill out the form and press the apply button
 */

    String url = "https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/";

    By secondEmoji = By.xpath("//a[@href=\"#nature\"]");
    By allSecondEmojiItems = By.xpath("//div[contains(@class,\"is-active\")]//div//img[@class=\"emoji\"]");

    @Test
    void test() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().frame("emoojis");

        // Click on the second emoji
        driver.findElement(secondEmoji).click();

        // Click one of second emoji items
        List<WebElement> emojes = driver.findElements(allSecondEmojiItems);

        emojes.forEach(t -> t.click());

        // Return to the parent iframe
        driver.switchTo().defaultContent();

        // Fill out the form and press the apply button
        driver.findElement(By.id("text")).sendKeys("Hello");
        driver.findElement(By.id("nature")).sendKeys("Have a nice day");
        driver.findElement(By.id("activities")).sendKeys("Have a nice day");
        driver.findElement(By.id("objects")).sendKeys("Have a nice day");
        driver.findElement(By.id("flags")).sendKeys("Have a nice day");
        driver.findElement(By.id("smiles")).sendKeys("Have a nice day");
        driver.findElement(By.id("food")).sendKeys("Have a nice day");
        driver.findElement(By.id("places")).sendKeys("Have a nice day");
        driver.findElement(By.id("symbols")).sendKeys("Have a nice day");
        driver.findElement(By.id("active")).sendKeys("Have a nice day");
        driver.findElement(By.id("hide")).sendKeys("Have a nice day");
        driver.findElement(By.id("send")).click();


    }
}
