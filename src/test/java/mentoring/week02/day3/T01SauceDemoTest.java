package mentoring.week02.day3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T01SauceDemoTest {

    /*
    Given: Go to https://www.saucedemo.com/
When: Enter username as "standard-user"
And: Enter password as "secret-sauce"
And: Click login button
And: Order products by "Price (low to high)"
Then: Assert last product costs $49.99, first product costs $7.99
     */
    WebDriver driver;
    String url = "https://www.saucedemo.com/";


    @Test
    public void test01() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("lohi");
        List<WebElement> productsPrices = driver.findElements(By.className("inventory_item_price"));
        String firstProductPrice = productsPrices.getFirst().getText();
        String lastProductPrice = productsPrices.getLast().getText();
        assert firstProductPrice.equals("$7.99");
        assert lastProductPrice.equals("$49.99");
        driver.quit();

    }
}
