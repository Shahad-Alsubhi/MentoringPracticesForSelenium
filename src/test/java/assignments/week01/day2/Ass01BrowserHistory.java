package assignments.week01.day2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ass01BrowserHistory {
    /*
    Task 1: Browser History Exploration
Setup:
Use @BeforeEach to launch Chrome and maximize.
Test 1:
Navigate to https://www.wikipedia.org/.
Navigate to https://www.google.com/.
Navigate back and forward multiple times, asserting the correct title at each step.
Test 2:
Use driver.navigate().refresh() on Google and assert the title still contains "Google".
Teardown:
Use @AfterEach to close the browser.
     */

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
    void test01() {
        // Navigate to Wikipedia
        driver.navigate().to("https://www.wikipedia.org/");
        assertEquals("Wikipedia", driver.getTitle(), "Wikipedia title mismatch");

        // Navigate to Google
        driver.navigate().to("https://www.google.com/");
        assertEquals("Google", driver.getTitle(), "google title mismatch");

        // Navigate back to Wikipedia
        driver.navigate().back();
        assert driver.getTitle().equals("Wikipedia") : "Back to Wikipedia title mismatch";

        // Navigate forward to Google
        driver.navigate().forward();
        assert driver.getTitle().equals("Google") : "Forward to Google title mismatch";
    }

    @Test
    void test02() {
        // Navigate to Google
        driver.navigate().to("https://www.google.com/");

        // Refresh the page
        driver.navigate().refresh();
        assertEquals("Google", driver.getTitle(), "Title after refresh does not contain 'Google'");


    }
}
