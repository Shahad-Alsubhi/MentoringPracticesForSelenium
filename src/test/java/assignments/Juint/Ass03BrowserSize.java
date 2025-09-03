package assignments.Juint;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ass03BrowserSize {
    /*
    * Task 3: Browser Size and Position
Setup:
Open Chrome in @BeforeEach.
Test 1:
Navigate to https://www.bbc.com/.
Set browser size to 800x600 and assert the window size.
Test 2:
Move the window to position (100, 100) and assert its position.
Teardown:
Close the browser.
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
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        assertEquals(new org.openqa.selenium.Dimension(802, 602), driver.manage().window().getSize(), "Size Test FAILED");
    }


    @Test
    void test2() {
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        assertEquals(new org.openqa.selenium.Point(100, 100), driver.manage().window().getPosition(), "Position Test FAILED");
    }
}
