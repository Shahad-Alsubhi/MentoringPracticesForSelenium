package assignments.week02.day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T07MultiSelectOperations {
    /*
    launch browser
Open https://demoqa.com/select-menu
 Select Standard Multi-Select using element id
 Verify element is multi-select
 Select 'Opel' using index, then deselect using index
 Select 'Saab' using value, then deselect using value
 Deselect all options
 Close browser
     */
    WebDriver driver;

    String url = "https://demoqa.com/select-menu";

    @Test
    void test() {
        driver.get(url);
        // Select Standard Multi-Select using element id
        // Verify element is multi-select
        // Select 'Opel' using index, then deselect using index
        // Select 'Saab' using value, then deselect using value
        // Deselect all options
        driver.get(url);
        WebElement drpdown = driver.findElement(By.id("cars"));
        Select select = new Select(drpdown);
        // Check if the dropdown is multi-select
        System.out.println("Is multi-select: " + select.isMultiple());

        // Select 2nd option from dropdown:
        select.selectByIndex(2);
        // Deselect using index
        select.deselectByIndex(2);

        // Select option which has value of "saab"
        select.selectByValue("saab");
        // Deselect using value
        select.deselectByValue("saab");

        // Deselect all options
        select.deselectAll();
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
