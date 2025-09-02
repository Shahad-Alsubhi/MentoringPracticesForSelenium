package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02Window {
    public static void main(String[] args) {

        // TC - 02
// Go to www.yahoo.com 
// Maximize Window 
// Go to www.amazon.com 
// Maximize Window 
// Navigate Back
// Navigate Forward
// Refresh The Page

        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.yahoo.com/");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
