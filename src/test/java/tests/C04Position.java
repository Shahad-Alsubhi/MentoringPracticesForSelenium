package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C04Position {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.google.com/");
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        driver.manage().window().setPosition(new org.openqa.selenium.Point(50, 50));
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        if (driver.manage().window().getPosition().equals(new org.openqa.selenium.Point(49, 49))) {
            System.out.println("Position Test PASSED");
        } else {
            System.out.println("Position Test FAILED");
        }
        driver.quit();


    }
}
