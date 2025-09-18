package morningClass.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C38DownLoadFile02 extends TestBase {
    @Test
    void name() throws InterruptedException, IOException {
        String name = "Admin";
        String password = "admin123";

        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //Click PIM on the left side bar
        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
        //Click Configuration and select Data Import
        driver.findElement(By.className("oxd-topbar-body-nav-tab-item")).click();
        driver.findElement(By.xpath("//a[.='Data Import']")).click();

        Path path = Path.of("D:", "Downloads", "importData.csv"); //my default download path is D
//      Path path=Path.of(System.getProperty("user.home"), "Downloads", "importData.csv"); //to make it dynamic for every computer

        Files.deleteIfExists(path);

        //Download sample CSV file.
        driver.findElement(By.className("download-link")).click();

        //Verify if the file downloaded successfully.
        Thread.sleep(3000);
        Assertions.assertTrue(Files.exists(path));
    }
}
