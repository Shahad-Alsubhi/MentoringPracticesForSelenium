package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ass03WindowCommands {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.amazon.com/");
        // Print the initial position and size of the window
        System.out.println("Window Position= " + driver.manage().window().getPosition());
        System.out.println("Window Size= " + driver.manage().window().getSize());

        // Set the position to (50,50) and verify
        driver.manage().window().setPosition(new org.openqa.selenium.Point(50, 50));
        if (driver.manage().window().getPosition().equals(new org.openqa.selenium.Point(49, 49))) {
            System.out.println("Position Test PASSED");
        } else {
            System.out.println("Position Test FAILED");
        }
// Set the size to 600x600 and verify
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
        if (driver.manage().window().getSize().equals(new org.openqa.selenium.Dimension(600, 600))) {
            System.out.println("Size Test PASSED");
        } else {
            System.out.println("Size Test FAILED");
        }
        driver.quit();
    }
}
