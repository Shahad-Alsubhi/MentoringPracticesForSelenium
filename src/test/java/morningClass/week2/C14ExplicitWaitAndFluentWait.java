package morningClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
In Selenium, waits are used to handle the synchronization between the script
and the web application. Since web elements may take time to load, appear, or
become clickable, using waits ensures that the script interacts with elements
only when they are ready. Without waits, tests may fail due to timing issues
like ElementNotFoundException.

Selenium provides three types of waits:
    1)  Implicit Wait (applies a global timeout for element searches),
    2)  Explicit Wait (waits for specific conditions like visibility or clickability)
    3)  Fluent Wait (a more flexible wait with polling frequency and exception handling).

    Using waits properly makes tests more stable and reliable.
 */
public class C14ExplicitWaitAndFluentWait {
    WebDriver driver;
    String url = "https://webdriveruniversity.com/Popup-Alerts/index.html";
    By ajaxLoader = By.id("button3");
    By clickMe = By.id("button1");
    By wellDoneText = By.className("modal-title");

    @Test
    void expliciteWaitTest() {
/*
    Specifies the condition and the time that WebDriver should wait.
    In practice, WebDriverWait and Explicit Wait are synonymous,******
    since their definitions and usage perfectly match.

    // How to use Explicit Wait
    // 1- Create a WebDriverWait object
    // 2- Pass the desired condition to the 'until' method of the wait object
*/

        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html

        //    Click on Ajax Loader

        //    Click on 'Click Me'

        //    Assert text "Well Done For Waiting....!!!"

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
        driver.findElement(ajaxLoader).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickMe));
        driver.findElement(clickMe).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(wellDoneText));
        String actualText = driver.findElement(wellDoneText).getText();
        Assertions.assertEquals("Well Done For Waiting....!!!", actualText);


    }

    @Test
    void fluemtWaitTest() throws InterruptedException {
/*
   Fluent Wait is a type of Explicit Wait that allows you to define:
   - The maximum time to wait for a condition
   - The polling period (how often to check the condition)
   - Ignored exceptions while waiting (e.g., NoSuchElementException)
   It provides more flexibility than Implicit and Explicit Wait.
*/


        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html

        //    Click on Ajax Loader

        //    Click on 'Click Me'

        //    Assert text "Well Done For Waiting....!!!"

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds
                .ignoring(Exception.class); // Ignore all exceptions while waiting
        driver.get(url);
        driver.findElement(ajaxLoader).click();
        driver.findElement(clickMe).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(wellDoneText));
        String actualText = driver.findElement(wellDoneText).getText();
        Assertions.assertEquals("Well Done For Waiting....!!!", actualText);


    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
