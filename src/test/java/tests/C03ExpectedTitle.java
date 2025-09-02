package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C03ExpectedTitle {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.youtube.com/");
        driver.manage().window().maximize();
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
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
