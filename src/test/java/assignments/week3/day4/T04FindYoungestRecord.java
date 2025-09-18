package assignments.week3.day4;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseWithActionHelper;

import java.util.List;

public class T04FindYoungestRecord extends TestBaseWithActionHelper {

     /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add 10 records using Faker.
 Find the name of the youngest record.
 */

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        for (int i = 0; i < 10; i++) {
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), Faker.instance().number().numberBetween(18, 50) + "");
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1, 5);
            try {
                select.selectByIndex(idx);
                logger.info("Country is selecteed with index :" + idx);
            } catch (Exception e) {
                logger.error("Coulnd'T select by referance with idx :" + idx);
            }
            actionHelper.click(By.xpath("//button[.='Add Record']"));
        }

        List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr")); //

        String youngestName = "";
        int youngestAge = Integer.MAX_VALUE;

        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));
            String name = cells.get(0).getText();
            int age = Integer.parseInt(cells.get(1).getText());

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }
        System.out.println("Youngest person is: " + youngestName + " with age: " + youngestAge);
        logger.info("test is completed successfully....");

    }
}
