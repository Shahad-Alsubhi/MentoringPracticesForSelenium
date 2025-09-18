package morningClass.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C37DownloadFile extends TestBase {
    /*
Go to URL: https://the-internet.herokuapp.com/download
    Download selenium-login_exeption.png
    Verify if the file downloaded successfully.
*/

    @Test
    public void FileDownLoadTest() throws InterruptedException, IOException {
        driver.get("https://the-internet.herokuapp.com/download");

        By LinkText = By.linkText("test.txt");
        driver.findElement(LinkText).click();
        Thread.sleep(3000);

        //Verify if the file downloaded successfully
        String separator = System.getProperty("file.separator");
//      String sep = File.separator; //another way to get file separator

//      String filePath = "D:" + separator + "downloads" + separator + "selenium-snapshot.png"; //for my computer(i moved downloads to d drive)

        String filePath2 = System.getProperty("user.home") + separator + "Downloads" + separator + "test.txt"; //genral c:/users/username/downloads

        // Path path2 = Paths.get(System.getProperty("user.home"),"Downloads","test.txt"); //another way to get file path

        Assertions.assertTrue(Files.exists(Path.of(filePath2)));

        Files.deleteIfExists(Path.of(filePath2));
    }
}
