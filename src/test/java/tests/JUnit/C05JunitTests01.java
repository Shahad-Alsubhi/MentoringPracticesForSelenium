package tests.JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C05JunitTests01 {
/*
    // Go to YouTube homepage
// Do the following tasks by creating 4 different test methods. 
*- Print "Test is running" before each test() method
*- Print "Test finished" after each test() method
    // Test if the currentURL contains "youtube" 
// Test if the title does not contain "Video". 
// Test if the URL contains "youtube". 
// Test if the sourcePage contains "youtube".
    */

    WebDriver driver;

    @Test
    void urlTest01() {
        assertTrue(driver.getCurrentUrl().contains("youtube"));

    }

    @Test
    void urlTest02() {
        assertFalse(driver.getTitle().contains("video"));

    }

    @Test
    void titleTest01() {
        assertTrue(driver.getCurrentUrl().contains("youtube"));
    }

    @Test
    void pageSourceTest04() {
        assertTrue(driver.getPageSource().contains("youtube"));
    }

    //better to initial driver for each test for parallel testing
    @BeforeEach
    public void setUp() {
        System.out.println("Test is running");
        driver = new EdgeDriver();
        driver.navigate().to("https://www.youtube.com/");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test finished");
        driver.quit();
    }


}
