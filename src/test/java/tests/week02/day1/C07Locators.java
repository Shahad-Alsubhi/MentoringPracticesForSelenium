package tests.week02.day1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {
    static WebDriver driver;

    @BeforeAll
    static public void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        //we will wait up to 10 seconds for elements to be found
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// TODO: Navigate to LinkedIn
        driver.get("https://www.linkedin.com/login");
    }

    @AfterAll
    static public void tearDown() {
// TODO: Close driver
        driver.quit();
    }

    @Test
    public void testLoginElements() {
// TODO: Locate email field using By.id
        WebElement emailField = driver.findElement(By.id("username"));
// TODO: Locate password field using By.name
        WebElement passwordField = driver.findElement(By.name("session_password"));
// TODO: Locate sign-in button using By.xpath
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
// TODO: Enter test credentials
        emailField.sendKeys("sha@gmail.com");
        passwordField.sendKeys("12342");
// TODO: Verify elements are displayed
        assert emailField.isDisplayed();
        assert passwordField.isDisplayed();
        assert signInButton.isDisplayed();
        signInButton.click();


    }
}