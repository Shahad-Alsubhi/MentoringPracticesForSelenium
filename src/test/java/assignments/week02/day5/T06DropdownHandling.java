package assignments.week02.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T06DropdownHandling extends TestBase {
 /*
 Go to https://claruswaysda.github.io/Dropdowns.html
 In 1. Traditional Dropdown select 'Ford'
 In 2. Multi-Select Dropdown select 'Mercedes'
 In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
 In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
 In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
 */

    String url = "https://claruswaysda.github.io/Dropdowns.html";

    @Test
    void test() {
        driver.get(url);
        //traditional dropdown
        WebElement traditionalDropdownElement = driver.findElement(By.id("carSelect"));
        Select traditionalDropdown = new Select(traditionalDropdownElement);
        traditionalDropdown.selectByValue("Ford");

        //multi-select dropdown
        WebElement multiSelectDropdownElement = driver.findElement(By.id("multiCarSelect"));
        Select multiSelectDropdown = new Select(multiSelectDropdownElement);
        multiSelectDropdown.selectByVisibleText("Mercedes");

        //custom dropdown
        driver.findElement(By.id("customDropdown")).click();
        driver.findElement(By.xpath("//div[@class=\"custom-dropdown\"][text()='BMW']")).click();

        //static auto-suggest dropdown
        driver.findElement(By.id("staticInput")).sendKeys("Tesla Model 3");
        driver.findElement(By.xpath("//div[@class=\"suggestion-item\"][text()='Tesla Model 3']")).click();

        //dynamic auto-suggest dropdown
        driver.findElement(By.id("dynamicInput")).sendKeys("Toyota");
        driver.findElement(By.xpath("//div[@id=\"dynamicSuggestions\"]//div[@class=\"suggestion-item\"][text()='Toyota']")).click();

    }

}
