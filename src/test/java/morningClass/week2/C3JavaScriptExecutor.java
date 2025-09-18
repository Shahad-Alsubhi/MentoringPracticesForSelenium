package morningClass;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C3JavaScriptExecutor extends TestBase {

    @Test
    public void JscriptExecutorTtest1() {
        driver.get("https://google.com");

        // JavaScript Executor oluşturmalıyız
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // executeScript() metodu ile java Script kodlarını çalıştırabiliriz
        js.executeScript("document.body.style.backgroundColor='lightblue';");
        js.executeScript("document.title = 'Google Hack with JavaScript :)';");
        js.executeScript("alert('JacaScript is quite powerfull !');");
    }

    //Go to URL: https://api.jquery.com/dblclick/
    //Double-click on the blue square at the bottom of the page and then write the changed color.

    @Test
    public void jScriptExecuterTest2() throws InterruptedException {
        By blueSqureTagNAme = By.tagName("div");
        By iframeTagNAme = By.tagName("iframe");

        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");
        WebElement iframe = driver.findElement(iframeTagNAme);

        driver.switchTo().frame(iframe);
        WebElement blueSqure = driver.findElement(blueSqureTagNAme);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", blueSqure);
        System.out.println(blueSqure.getCssValue("backgroundColor"));

        new Actions(driver).doubleClick(blueSqure).perform();
        System.out.println(blueSqure.getCssValue("backgroundColor"));
        Assertions.assertTrue(blueSqure.getCssValue("backgroundColor").equals("rgba(255, 255, 0, 1)"));

        // sayfada scroll yapmak için iframe den çıkmam lazım
        driver.switchTo().defaultContent();

        // Sayfanın en üstüne js ile scroll
        js.executeScript("window.scrollTo(0,0)");

        Thread.sleep(2000);

        // Sayfanın en altına js ile scroll
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
