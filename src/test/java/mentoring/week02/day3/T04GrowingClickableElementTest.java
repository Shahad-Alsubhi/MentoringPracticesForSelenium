package mentoring.week02.day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class T04GrowingClickableElementTest {

    /*
    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
Click "click me" button
Verify "Event Triggered" appears
     */

    WebDriver driver;
    String url = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";

    @Test
    void test() {
        driver.get(url);

        driver.findElement(By.className("grown")).click();
        String actualText = driver.findElement(By.id("growbuttonstatus")).getText();
        String expectedText = "Event Triggered";
        System.out.println(actualText);
        assert actualText.equals(expectedText) : "Actual text is not as expected!!!";
    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
