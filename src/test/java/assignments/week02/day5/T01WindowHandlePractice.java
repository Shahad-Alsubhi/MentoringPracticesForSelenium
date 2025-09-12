package assignments.week02.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class T01WindowHandlePractice extends TestBase {
 /*
 Go to https://claruswaysda.github.io/
 Click on Window Handle
 Click on 'Open Index Page'
 Verify the link 'https://claruswaysda.github.io/index.html'
 */

    String url = "https://claruswaysda.github.io/";

    @Test
    void test() {
        driver.get(url);
        String mainHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Window Handle")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {
            String childHandle = iterator.next();
            if (!mainHandle.equals(childHandle)) {
                driver.switchTo().window(childHandle);

            }
        }
        driver.findElement(By.id("openIndex")).click();

        System.out.println("driver.getWindowHandles().size() = " + driver.getWindowHandles().size());
        Set<String> allHandles = driver.getWindowHandles();
        ArrayList<String> urls = new ArrayList<>();
        for (String handle : allHandles) {
            urls.add(driver.switchTo().window(handle).getCurrentUrl());

        }
        Assertions.assertTrue(urls.contains("https://claruswaysda.github.io/index.html"));

    }

}
