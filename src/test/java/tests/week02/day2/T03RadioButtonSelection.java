package tests.week02.day2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03RadioButtonSelection {
    /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */


    WebDriver driver;

    @Test
    void radioButtonTest() {
        driver = new ChromeDriver();
        //http://test.rubywatir.com/radios.php
        driver.navigate().to("http://test.rubywatir.com/radios.php");

        By radio1Button = By.cssSelector("input[value='Radio1']");
        WebElement radio1btn = driver.findElement(radio1Button);
        boolean isRadio1Enabled = radio1btn.isEnabled();
        System.out.println("Radio1 is enabled: = " + isRadio1Enabled);
        radio1btn.click();
        boolean isRadio1Selected = radio1btn.isSelected();
        System.out.println("radio 1 is selected: = " + isRadio1Selected);

        By radioClass = By.className("radioclass");
        WebElement radioClassBtn = driver.findElement(radioClass);
        boolean isRadioClassEnabled = radioClassBtn.isEnabled();
        System.out.println("RadioClass is enabled: = " + isRadioClassEnabled);
        radioClassBtn.click();
        boolean isRadioClassSelected = radioClassBtn.isSelected();
        System.out.println("radio Class is selected: = " + isRadioClassSelected);

    }
}
