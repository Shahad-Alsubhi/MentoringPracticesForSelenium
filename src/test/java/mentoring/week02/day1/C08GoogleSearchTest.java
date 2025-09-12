package mentoring.week02.day1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08GoogleSearchTest {

    static WebDriver driver;
    int verification = 0;

    @BeforeAll
    public static void setUp() {
// TODO: Initialize static WebDriver
        driver = new ChromeDriver();

// TODO: Navigate to Google
        driver.get("https://www.google.com");
    }

    @AfterAll
    public static void tearDown() {
// TODO: Close driver
        driver.quit();
    }

    @Test
    public void searchMovies() throws InterruptedException {
        String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};

        for (String movie : movies) {
// TODO: Find search box
            WebElement searchBox = driver.findElement(By.name("q"));
// TODO: Clear and enter movie name
            searchBox.clear();
            searchBox.sendKeys(movie, Keys.ENTER);
// TODO: Submit search
// TODO: Get and print result count
            manualVerification();
            WebElement resultStats = driver.findElement(By.cssSelector("div[data-attrid=\"title\"]"));
            System.out.println("First Result for '" + movie + "': " + resultStats.getText());
// TODO: Clear search box for next iteration
            searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
        }
    }

    private void manualVerification() throws InterruptedException {
        if (verification == 0) {
            Thread.sleep(50000);
            verification++;
        }

    }


}
