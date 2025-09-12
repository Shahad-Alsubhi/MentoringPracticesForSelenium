package mentoring.week01.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01Navigate {
    public static void main(String[] args) throws InterruptedException {

// TC - 01

// Invoke Chrome Browser 
// Navigate to URL: https://www.w3schools.com/ 
// Navigate to URL: https://stackoverflow.com/ 
// Come back to the w3schools using the back command. 
// Again go back to the stackoverflow website using forward command 
// Refresh the Browser using refresh command. 
// Close the Browser.


        WebDriver driver = new EdgeDriver();

        driver.navigate().to("https://www.w3schools.com/");

        driver.navigate().to("https://stackoverflow.com/");
        System.out.println("driver = " + driver.getTitle());
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

//Thread.sleep(9000);
        driver.close();
        driver.quit();
        driver.quit();


    }
}
