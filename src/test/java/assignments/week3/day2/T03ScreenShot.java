package assignments.week3.day2;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03ScreenShot extends TestBase {

    /*
 Go to https://claruswaysda.github.io/homepage.html
 Register a user
 Sign in with the registered user
 Take all pages' screenshots
 Take 'Celebrate Login' button's screenshot.
 Capture a screenshot of the page with confetti.
 */

    @Test
    void test() throws InterruptedException, AWTException, IOException {
        driver.get("https://claruswaysda.github.io/homepage.html");
        driver.findElement(By.id("userIcon")).click();

        takesScreenshot();
        driver.findElement(By.cssSelector("a[href='form.html']")).click();
        takesScreenshot();

        //fill register form
        registerForm((ChromeDriver) driver);
        takesScreenshot();

        //sign in
        signIn((ChromeDriver) driver);
        takesScreenshot();

        Thread.sleep(3000);
        //click celebrate login button
        WebElement celebrateBtn = driver.findElement(By.xpath("//button[@id=\"clickMeButton\"]"));
        File btnScreenshot = celebrateBtn.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(btnScreenshot, getFilePath());
        celebrateBtn.click();

    }


    void registerForm(ChromeDriver driver) {
        driver.findElement(By.name("ssn")).sendKeys("123-45-6789");
        driver.findElement(By.name("first-name")).sendKeys("John");
        driver.findElement(By.name("last-name")).sendKeys("Doe");
        driver.findElement(By.name("address")).sendKeys("123 Main St");
        driver.findElement(By.name("email")).sendKeys("aa@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("username")).sendKeys("johndoe");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("confirm-password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    void signIn(ChromeDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Log In']")).click();

        driver.findElement(By.id("username")).sendKeys("johndoe");
        driver.findElement(By.id("password")).sendKeys("password123");

        driver.findElement(By.xpath("//button[@type='submit'][text()='Login']")).click();


    }

    void takesScreenshot() throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, getFilePath());

    }

    File getFilePath() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Path path = Path.of(System.getProperty("user.dir"), "target", "test-screenshot", "Screnshot" + timestamp + ".png");
        return path.toFile();
    }

}
