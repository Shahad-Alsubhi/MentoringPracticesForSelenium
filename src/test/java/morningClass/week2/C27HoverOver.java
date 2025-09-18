package morningClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C27HoverOver extends TestBase {
    /*
        Go to URL: https://www.browserstack.com/
        Hover over on “Products” link.
        Click on "Automate".
        Verify the page URL contains “automate”.
    */
    By productsLinkId = By.id("products-dd-toggle");
    By automateLinkXpath = By.xpath("//div[@id='products-dd-tabpanel-1-inner-1']//span[.='Automate']");
    String url = "https://www.browserstack.com/";

    @Test
    public void hoverOverTest() throws InterruptedException {

//Go to URL: https://www.browserstack.com/
        driver.get(url);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productsLinkId)).perform();
        Thread.sleep(2000);
        driver.findElement(automateLinkXpath).click();
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("automate"));

//Hover over on “Products” link.

//Verify the page URL contains “automate”.

    }
}
