package morningClass.week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;


public class C49WebTables02 extends TestBase {
    /*
        Go to URL: https://the-internet.herokuapp.com/tables
        Print the entire table
        Print All Rows
        Print Last row data only
        Print column 5 data in the table body
        Write a method that accepts 2 parameters
        parameter 1 = row number
        parameter 2 = column number
    */
    @Test
    public void webTableTest() {
        //    Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Print the entire table
        List<WebElement> table1Rows = driver.findElements(By.xpath("//table[1]//tr"));

        //    Print All Rows
        for (WebElement row : table1Rows) {
            List<WebElement> cells = row.findElements(By.xpath("./*[self::td or self::th]"));
            cells.forEach(cell -> System.out.print(cell.getText() + " | "));
            System.out.println();
        }

        //    Print Last row data only
        System.out.println(table1Rows.getLast());

        //    Print column 5 data in the table body
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr/td[4]"));
        column5Data.forEach(cell -> System.out.println(cell.getText()));

        C48WebTables01 instance = new C48WebTables01();
        //    Write a method that accepts 2 parameters
        System.out.println("getDataFromTable(3, 4) = " + instance.getDataFromTable(driver, 3, 4));
        //    parameter 1 = row number
        //    parameter 2 = column number


    }

}
