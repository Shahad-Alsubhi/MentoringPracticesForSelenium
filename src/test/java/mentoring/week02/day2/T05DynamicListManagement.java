package mentoring.week02.day2;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class T05DynamicListManagement {

        /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */
    
    WebDriver driver;

    @Test
    void listTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to("http://webdriveruniversity.com/To-Do-List/index.html");
        Faker faker = new Faker();
        //mark tasks as completed
        List<WebElement> tasks = driver.findElements(By.cssSelector("li"));
        for (int i = 0; i < tasks.size(); i += 1) {
            tasks.get(i).click();
        }
        //delete completed tasks
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//li[@class='completed']//i[@class='fa fa-trash']"));
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
        //add new tasks to the list
        WebElement inputElement = driver.findElement(By.cssSelector("input[placeholder='Add new todo']"));
        for (int i = 0; i < 5; i++) {
            inputElement.sendKeys(faker.name().title(), Keys.ENTER);
        }
        Thread.sleep(3000);
        //verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.className("completed"));
        Assertions.assertEquals(0, remainingTasks.size());

        driver.quit();
    }
}
