package mentoring.week02.day3;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class T02CalculatorOperationsTest_y {

    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    By firstInput = By.id("number1");
    By secondInput = By.id("number2");

    String num1 = "20";
    String num2 = "5";

    String[] operations = {"plus", "minus", "times", "divide"};


    int addResult = Integer.parseInt(num1) + Integer.parseInt(num2);
    String expectedAddResult = String.valueOf((int) addResult);
    int subResult = Integer.parseInt(num1) - Integer.parseInt(num2);
    String expectedSubResult = String.valueOf((int) subResult);
    int mulResult = Integer.parseInt(num1) * Integer.parseInt(num2);
    String expectedMulResult = String.valueOf((int) mulResult);
    int divResult = Integer.parseInt(num1) / Integer.parseInt(num2);
    String expectedDivResult = String.valueOf(divResult);


    @Test
    void test() throws InterruptedException {

        //   Go to https://testpages.eviltester.com/styled/calculator
        driver.get(url);

        //   Type any number in first and second input
        driver.findElement(firstInput).sendKeys(num1);
        driver.findElement(secondInput).sendKeys(num2);

        //   Click Calculate for each operation

        for (int i = 0; i < operations.length; i++) {

            driver.findElement(firstInput).clear();
            driver.findElement(firstInput).sendKeys(num1);
            driver.findElement(secondInput).clear();
            driver.findElement(secondInput).sendKeys(num2);

            WebElement op = driver.findElement(By.id("function"));
            Select select = new Select(op);
            select.selectByValue(operations[i]);
            driver.findElement(By.id("calculate")).click();
            // time for answer to be updated
            Thread.sleep(3000);
            //   Get and verify results for all operations
            switch (operations[i]) {
                case "plus" -> {
                    String additionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedAddResult, additionResult);
                    System.out.println("Addition Result: " + additionResult); // 20 + 5
                }
                case "minus" -> {
                    String subtractionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedSubResult, subtractionResult);
                    System.out.println("Subtraction Result: " + subtractionResult); // 20 - 5
                }
                case "times" -> {
//                    String multiplicationResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedMulResult, driver.findElement(By.id("answer")).getText());
                    System.out.println("Multiplication Result: " + driver.findElement(By.id("answer")).getText()); // 20 * 5
                }
                case "divide" -> {
                    String divisionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedDivResult, divisionResult);
                    System.out.println("Division Result: " + divisionResult); // 20 / 5
                }
            }
            //for stale element exception
            Thread.sleep(5000);
        }

    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
