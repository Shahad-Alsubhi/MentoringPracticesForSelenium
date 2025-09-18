package morningClass.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C39UploadFile01 extends TestBase {
    @Test
    void name() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/upload

        driver.get("https://the-internet.herokuapp.com/upload");
        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.home") + "/Desktop/importData.csv";
        //Click on Upload button.
        WebElement inputUpload = driver.findElement(By.id("file-upload"));
        inputUpload.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
        //Verify the upload message.
        Assertions.assertTrue(driver.findElement(By.xpath("//h3[text()=\"File Uploaded!\"]")).isDisplayed());
    }
}
