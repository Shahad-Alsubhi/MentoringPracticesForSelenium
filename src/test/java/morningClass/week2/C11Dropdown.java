package morningClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C11Dropdown {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";


    @Test
    void oldDropDownMenuTest() {

        driver.get(url);
        WebElement drpdown = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(drpdown);
        // Select 2nd option from dropdown:
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select option which has value of "red":
        select.selectByValue("red");
        System.out.println(select.getFirstSelectedOption().getText());

        // Select according to visible text:
        select.selectByVisibleText("White");
        System.out.println(select.getFirstSelectedOption().getText());

        // Check if the dropdown is multi-select
        select.isMultiple();
        System.out.println(select.getFirstSelectedOption().getText());


    }

    @Test
    void multiSelectTest() {

        driver.get(url);
        WebElement drpdown = driver.findElement(By.id("cars"));
        Select select = new Select(drpdown);
        // Select 2nd option from dropdown:
        select.selectByIndex(1);

        // Select option which has value of "volvo"
        select.selectByValue("volvo");
        // Select according to visible text:
        select.selectByVisibleText("Audi");

        select.getAllSelectedOptions().forEach(t -> System.out.println(t.getText()));

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
