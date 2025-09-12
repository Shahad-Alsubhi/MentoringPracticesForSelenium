package assignments.week02.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05FormJSExecutor extends TestBase {
  /*
 Go to https://claruswaysda.github.io/form.html
 Create a method to flash the elements you are working on and use it.
 Register a user
 Login
 Celebrate the login!
 */

    String url = "https://claruswaysda.github.io/form.html";

    public static void flashAndFill(WebElement element, JavascriptExecutor js, String value) {

        String originalColor = element.getCssValue("backgroundColor"); // get original color
        for (int i = 0; i < 2; i++) {  // number of flashes
            changeColor("blue", element, js);  // highlight color
            changeColor(originalColor, element, js);  // back to original
        }
        js.executeScript("arguments[0].value='" + value + "';", element);

    }

    public static void changeColor(String color, WebElement element, JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(100);  // pause so flash is visible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test() throws InterruptedException {
        driver.get(url);
        WebElement ssn = driver.findElement(By.name("ssn"));
        WebElement firstName = driver.findElement(By.name("first-name"));
        WebElement lastName = driver.findElement(By.name("last-name"));
        WebElement address = driver.findElement(By.name("address"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confirmPassword = driver.findElement(By.name("confirm-password"));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        flashAndFill(ssn, js, "123-45-6789");
        flashAndFill(firstName, js, "John");
        flashAndFill(lastName, js, "Doe");
        flashAndFill(address, js, "123 Main St");
        flashAndFill(email, js, "aa@gmail.com");
        flashAndFill(phone, js, "1234567890");
        flashAndFill(userName, js, "johndoe");
        flashAndFill(password, js, "password123");
        flashAndFill(confirmPassword, js, "password123");
        submit.click();
        // Verify registration success
        Assertions.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed());

        // Login
        WebElement loginLink = driver.findElement(By.xpath("//button[text()='Log In']"));
        loginLink.click();
        WebElement loginUsername = driver.findElement(By.id("username"));
        WebElement loginPassword = driver.findElement(By.id("password"));
        flashAndFill(loginUsername, js, "johndoe");
        flashAndFill(loginPassword, js, "password123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit'][text()='Login']"));
        //to dissmiss the warning
        Thread.sleep(3000);
        loginButton.click();

        // Verify login success
        Assertions.assertTrue(driver.findElement(By.id("clickMeButton")).isDisplayed());
        driver.findElement(By.id("clickMeButton")).click();


    }
}
