package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ass02VerifyTitleTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.youtube.com/");
        String expectedTitle = "YouTube";

        String actualTitle = driver.getTitle();
        //verify title
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Test PASSED");
        } else {
            System.out.println("Title Test FAILED");
            System.out.println("Actual Title: " + actualTitle);
            System.out.println("Expected Title: " + expectedTitle);
        }

        driver.quit();

    }
}
