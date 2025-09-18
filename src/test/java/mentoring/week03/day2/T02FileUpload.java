package mentoring.week03.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Path;

public class T02FileUpload extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/

    String fileName1 = "08 - Selenium Files & Screenshots - Review and Summary.pdf";
    String fileName2 = "07-Selenium WebDriver - JS Executor - Robot  Class - Cookies Review & Practice Tasks.pdf";
    Path path1 = Path.of("D:", "Downloads", fileName1);
    Path path2 = Path.of("D:", "Downloads", fileName2);
//    Path path1 = Path.of(System.getProperty("user.home"), "Downloads", fileName1);
//    Path path2 = Path.of(System.getProperty("user.home"), "Downloads", fileName2);
//

    @Test
    void test() {

        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        driver.findElement(By.id("uploadInput")).sendKeys(path1.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
    }

    @Test
    void negativeTest() {
        // Negative test
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("alertBox")).isDisplayed());
    }

    @Test
    void multipleFileTest() {
        // Multiple files
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        driver.findElement(By.id("multiUploadInput")).sendKeys(path1.toString() + "\n" + path2.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
    }


}
