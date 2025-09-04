package assignments.week01.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass04WindowMaximize {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//      Open URL: https://www.google.com/
        driver.navigate().to("https://www.google.com/");
//      Maximize the window.
        driver.manage().window().maximize();
//      Print the position and dimensions of the page in maximized state.
        System.out.println("Window Position = " + driver.manage().window().getPosition());
        System.out.println("Window Size = " + driver.manage().window().getSize());
//      Minimize the page.
        driver.manage().window().minimize();
        //      Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        //          Print the position and dimensions of the page in maximized state.
        System.out.println("Window Position = " + driver.manage().window().getPosition());
        System.out.println("Window Size = " + driver.manage().window().getSize());
//      Make the page fullscreen.
        driver.manage().window().fullscreen();
        driver.close();
    }
}
