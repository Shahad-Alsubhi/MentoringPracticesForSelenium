package mentoring.week02.day2;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {
    /*
   Task: Go to "https://demoqa.com/text-box"
       . Use Java Faker to:

       Generate and enter a fake full name
       Generate and enter a fake email address
       Generate and enter a fake current address
       Generate and enter a fake permanent address
       Submit the form and verify the output contains the entered data
   */
    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @Test
    void fakerTest() {
        driver.get(url);
        Faker faker = new Faker();
        //        Generate and enter a fake full name
        String name = faker.name().fullName();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(name);
        //        Generate and enter a fake email address
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        //        Generate and enter a fake current address
        String currentAddress = faker.address().fullAddress();
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(currentAddress);
        //        Generate and enter a fake permanent address
        String permanentAddress = faker.address().fullAddress();
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(permanentAddress);
        //        Submit the form and verify the output contains the entered data
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        String outputName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assertions.assertEquals(outputName, "Name:" + name);

        String outputEmail = driver.findElement(By.xpath("//p[@id='email']")).getText();
        Assertions.assertEquals(outputEmail, "Email:" + email);

        String outputCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        Assertions.assertEquals(outputCurrentAddress, "Current Address :" + currentAddress);

        String outputPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        Assertions.assertEquals(outputPermanentAddress, "Permananet Address :" + permanentAddress);
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
