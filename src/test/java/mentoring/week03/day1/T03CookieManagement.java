package mentoring.week03.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class T03CookieManagement extends TestBase {

    /*
 Go to https://claruswaysda.github.io/CookiesWait.html
 Accept the alert if it is present
 Print the cookies
 Delete all cookies and assert
 */

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/CookiesWait.html");
//        try {
//            driver.switchTo().alert().accept();
//        } catch (NoAlertPresentException e) {
//        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert found: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present.");
        }

        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());

    }
}
