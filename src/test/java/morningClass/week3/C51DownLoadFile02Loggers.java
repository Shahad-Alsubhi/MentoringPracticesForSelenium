package morningClass.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseWithActionHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C51DownLoadFile02Loggers extends TestBaseWithActionHelper {
    @Test
    void name() throws InterruptedException, IOException {
        logger.info("Test is starting...");
        String name = "Admin";
        String password = "admin123";

        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.
        actionHelper.sendKeys(By.xpath("//*[@name='username']"), name);
        actionHelper.sendKeys(By.xpath("//*[@name='password']"), password);
        actionHelper.click(By.xpath("//*[@type='submit']"));

        //Click PIM on the left side bar
        actionHelper.click(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        //Click Configuration and select Data Import
        actionHelper.click(By.className("oxd-topbar-body-nav-tab-item"));
        actionHelper.click(By.xpath("//a[.='Data Import']"));

        Path path = Path.of("D:", "Downloads", "importData.csv"); //my default download path is D
//      Path path=Path.of(System.getProperty("user.home"), "Downloads", "importData.csv"); //to make it dynamic for every computer

        Files.deleteIfExists(path);

        //Download sample CSV file.
        actionHelper.click(By.className("download-link"));

        //Verify if the file downloaded successfully.
        Thread.sleep(3000);
        Assertions.assertTrue(Files.exists(path));
        logger.info("File is downloaded successfully...");
    }
}
