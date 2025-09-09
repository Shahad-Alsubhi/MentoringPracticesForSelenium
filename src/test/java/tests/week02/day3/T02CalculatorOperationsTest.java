package tests.week02.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class T02CalculatorOperationsTest {
    /*
    Go to https://testpages.eviltester.com/styled/calculator
 Type any number in first and second input
 Click Calculate for each operation
 Get and verify results for all operations
     */

    WebDriver driver;


    @Test
    public void test02() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://testpages.eviltester.com/styled/calculator");

//        WebElement firstInput = driver.findElement(By.id("number1"));
//        WebElement secondInput = driver.findElement(By.id("number2"));
//        WebElement calculateButton = driver.findElement(By.id("calculate"));
//        WebElement resultField = driver.findElement(By.id("answer"));
//        Select operationSelect = new Select(driver.findElement(By.id("function")));

        String currentOperation = "";
        int num1 = 20;
        int num2 = 5;
        for (int i = 0; i < 4; i++) {
            Thread.sleep(3000);
            driver.findElement(By.id("number1")).clear();
            driver.findElement(By.id("number2")).clear();
            driver.findElement(By.id("number1")).sendKeys(String.valueOf(num1));
            driver.findElement(By.id("number2")).sendKeys(String.valueOf(num2));
            Select operationSelect = new Select(driver.findElement(By.id("function")));
            operationSelect.selectByIndex(i);
            currentOperation = operationSelect.getFirstSelectedOption().getText();
            System.out.println("Current Operation: " + operationSelect.getFirstSelectedOption().getText());
            driver.findElement(By.xpath("//input[@id='calculate']")).click();
            System.out.println("Current Operation: " + currentOperation
            );
            String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();


            System.out.println(" Result: " + result);

            switch (currentOperation) {
                case "plus":
                    Assertions.assertEquals((num1 + num2), Integer.parseInt(result));
                    break;
                case "minus":
                    Assertions.assertEquals(num1 - num2, Integer.parseInt(result));
                    break;
                case "divide":
                    Assertions.assertEquals(num1 / num2, Integer.parseInt(result));
                    break;
                case "times":
                    Assertions.assertEquals(num1 * num2, Integer.parseInt(result));
                    break;
                default:
                    System.out.println("No operation selected");
                    break;
            }
        }


        driver.quit();
    }
}
