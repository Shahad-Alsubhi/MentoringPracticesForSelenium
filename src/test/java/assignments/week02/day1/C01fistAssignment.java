package assignments.week02.day1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01fistAssignment {
    WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/";

    // Navigate to: https://opensource-demo.orangehrmlive.com/
    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name=\"username\"]"; // Fill relative path
    // TODO: Locate password using both methods
    String absolutePasswordXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"; // Fill absolute path
    String relativePasswordXPath = "//input[@type=\"password\"]"; // Fill relative path

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"; // Fill absolute path
    String relativeLoginButtonXPath = "//button[@type=\"submit\"]"; // Fill relative path

    // TODO: Test both approaches work


    @Test
    void relativeXpathTest() {
        driver.navigate().to(url);
        driver.findElement(By.xpath(relativeUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(relativePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(relativeLoginButtonXPath)).click();

    }

    @Test
    void absoltuXpathTest() {
        driver.navigate().to(url);
        driver.findElement(By.xpath(absoluteUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(absolutePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(absoluteLoginButtonXPath)).click();

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

