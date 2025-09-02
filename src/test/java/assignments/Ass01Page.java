package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ass01Page {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.google.com/");
        //get title and url
        System.out.println("Page Title = " + driver.getTitle());
        System.out.println("Current URL = " + driver.getCurrentUrl());
        driver.quit();

    }
}
