package tests.week01.day2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class C06JUnitTest02 {

    /*
     * // Go to google homepage
     * // Do the following tasks by creating 3 different test methods.
     * *- Print "Tests are starting to run" before each test() method
     * *- Print "Tests have finished running" after each test() method
     * // Test if the title is the same when the page window is maximize and minimize
     * // Test if the title does not contain "Video" when the page window is fullscreen
     * // Test if the URL contains "google"
     * */

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        // Initialize the WebDriver and navigate to google homepage
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void Test01() {
        // Test if the title is the same when the page window is maximize and minimize
        String titleMax;
        String titleMin;

        driver.manage().window().maximize();
        titleMax = driver.getTitle();

        driver.manage().window().minimize();
        titleMin = driver.getTitle();
        assertEquals(titleMin, titleMax);

    }

    @Test
    void Test02() {
        // Test if the title does not contain "Video" when the page window is fullscreen
        driver.manage().window().fullscreen();
        String titleFull = driver.getTitle();
        assertFalse(titleFull.contains("Video"));
    }

    @Test
    void Test03() {
        // Test if the URL contains "google"
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("google"));
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test is running");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test finished");
    }
}
