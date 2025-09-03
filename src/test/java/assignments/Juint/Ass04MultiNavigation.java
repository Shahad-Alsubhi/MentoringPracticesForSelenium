package assignments.Juint;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass04MultiNavigation {
    /*
    * Task 4: Multiple Navigation and Verification
Setup:
Launch Chrome and maximize in @BeforeEach.
Test 1:
Navigate Google → YouTube → LinkedIn.
Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
Test 2:
Navigate back twice and assert the URL of Google.
Navigate forward twice and assert URL of LinkedIn.
Teardown:
Use @AfterEach to quit the browser.
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
        driver.navigate().to("https://www.google.com/");
        assert driver.getTitle().contains("Google") : "Google title mismatch";

        driver.navigate().to("https://www.youtube.com/");
        assert driver.getTitle().contains("YouTube") : "YouTube title mismatch";

        driver.navigate().to("https://www.linkedin.com/");
        assert driver.getTitle().contains("LinkedIn") : "LinkedIn title mismatch";
    }

    @Test
    void test2() {
        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        assert driver.getCurrentUrl().contains("https://www.google.com/") : "Not at Google URL";
        driver.navigate().forward();
        driver.navigate().forward();
        assert driver.getCurrentUrl().contains("https://www.linkedin.com/") : "Not at LinkedIn URL";
    }
}
