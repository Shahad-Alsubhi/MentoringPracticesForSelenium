package mentoring.week02.day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T01ActionsForm extends TestBase {
/*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill the form
    Generate Passcode
    Use passcode to submit form
    */

    @Test
    void test() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Gadir");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("73");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='options']")));
        select.selectByValue("it");

        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

        String passcode = driver.switchTo().alert().getText().split(" ")[3];
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(passcode);
        driver.switchTo().alert().accept();
        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.id("submitButton")).click();


    }


}
