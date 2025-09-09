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

public class T06OldStyleSelectMenu {
    /*
     Launch browser
 Open https://demoqa.com/select-menu
 Select Old Style Select Menu using element id
 Print all dropdown options
 Select 'Purple' using index
 Select 'Magenta' using visible text
 Select an option using value
 Close browser
    */

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";


    @Test
    void test() {
        driver.get(url);

        driver.get(url);
        WebElement drpdown = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(drpdown);
        // Print all dropdown options
        select.getOptions().forEach(t -> System.out.println(t.getText()));

        // Select 'Purple' using index
        select.selectByIndex(4);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        System.out.println(select.getFirstSelectedOption().getText());

        // Select an option using value
        select.selectByValue("red");
        System.out.println(select.getFirstSelectedOption().getText());


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
