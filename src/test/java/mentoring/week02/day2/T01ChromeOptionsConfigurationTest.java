package mentoring.week02.day2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T01ChromeOptionsConfigurationTest {
  /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */

    WebDriver driver;

    @Test
    void chromeOptionsTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window on startup
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--incognito"); // Run in incognito mode
        options.addArguments("disable-infobars"); // Disable infobars
        driver = new ChromeDriver(options);
        driver.get("https://www.example.com");
        String title = driver.getTitle();
        assert title.contains("Example");
        driver.quit();

    }

}
