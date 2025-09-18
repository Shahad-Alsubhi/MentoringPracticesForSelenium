package assignments.week3.day4;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class T03ExportTabletoExcel extends TestBase {
    /*
 Go to https://claruswaysda.github.io/webTable.html
 Write the entire Table 1 to a new Excel sheet.
 */


    @Test
    void test() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");
        List<WebElement> tableRows = driver.findElements(By.xpath("(//table)[1]//tr"));
        Path filePath = Path.of(System.getProperty("user.dir"), "resources", "Test3.xlsx");
        Files.deleteIfExists(filePath);
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("Sheet1");

        By rowLocator = By.xpath("(//table)[1]//tr[1]/th");
        System.out.println(tableRows.size());
        for (int i = 1; i <= tableRows.size(); i++) {
            List<WebElement> rowCells = driver.findElements(rowLocator);
            System.out.println(rowCells.size());
            Row row = sheet.createRow(i - 1);
            for (int j = 1; j <= rowCells.size(); j++) {
                String cellValue = rowCells.get(j - 1).getText();
                System.out.println(rowCells.size() + cellValue);
                row.createCell(j - 1).setCellValue(cellValue);

            }

            rowLocator = By.xpath("(//table)[1]//tr[" + i + "]/td");
        }

        FileOutputStream fos = new FileOutputStream(filePath.toString());
        workbook.write(fos);
        workbook.close();
        fos.close();

    }

}
