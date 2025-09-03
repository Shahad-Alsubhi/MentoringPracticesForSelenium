package assignments.Juint;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ass02PageSourceValidation {

    /*
    * Task 2: Page Source Validation
Setup:
Use @BeforeEach to open Chrome and maximize.
Test 1:
Navigate to https://www.selenium.dev/.
Verify that the page source contains the word "WebDriver".
Test 2:
Navigate to https://www.python.org/.
Assert the page source contains "Python".
Teardown:
Close the browser with @AfterEach.
    * */

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Initialize the WebDriver and maximize the window
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() {
        // Close the browser
        driver.quit();
    }


    @Test
    void test1() {
        driver.navigate().to("https://www.selenium.dev/");
        assertTrue(driver.getPageSource().contains("WebDriver"));
    }

    @Test
    void test2() {
        driver.navigate().to("https://www.python.org/");
        assertTrue(driver.getPageSource().contains("Python"));
    }
}
