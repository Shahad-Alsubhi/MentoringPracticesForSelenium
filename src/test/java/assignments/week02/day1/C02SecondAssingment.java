package assignments.week02.day1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02SecondAssingment {
    String url = "https://testpages.herokuapp.com/styled/index.html";
    WebDriver driver;
// TODO: Navigate to test pages
// TODO: Click on "Locators - Find By Playground Test Page"
// TODO: Print current URL
// TODO: Navigate back
// TODO: Print URL after going back
// TODO: Click on "WebDriver Example Page"
// TODO: Print current URL
// TODO: Enter value 20 in number input
// TODO: Verify 'two, zero' message appears


    @Test
    public void testNavigation() {
        driver.navigate().to(url);
        driver.findElement(By.id("findbytest")).click();
        System.out.println("Current URL after clicking 'Locators - Find By Playground Test Page': " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URL after navigating back: " + driver.getCurrentUrl());
        driver.findElement(By.id("webdriverexamplepage")).click();
        System.out.println("Current URL after clicking 'WebDriver Example Page': " + driver.getCurrentUrl());
        driver.findElement(By.id("numentry")).sendKeys("20", Keys.ENTER);

        String message = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals("two, zero", message);

    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
