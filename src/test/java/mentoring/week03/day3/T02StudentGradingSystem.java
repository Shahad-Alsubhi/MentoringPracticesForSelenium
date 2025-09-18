package mentoring.week03.day3;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02StudentGradingSystem extends TestBase {

    /*
     Given: Save StudentScores.xlsx file into your project
 When: In the grade column, write the letter grades (A, B, C, D, F) based on the score ranges:
 A: 90-100
 B: 80-89
 C: 70-79
 D: 60-69
 F: below 60
 Then: Assert that the grade of "Alice" is "A"

     */

    Path filePath = Path.of("./", "resources", "TestData02.xlsx");

    @Test
    void test() throws IOException {
        FileInputStream fis = new FileInputStream(filePath.toFile());

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            double score = sheet.getRow(i).getCell(1).getNumericCellValue();
            String grade;
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            sheet.getRow(i).createCell(2).setCellValue(grade);
        }

        FileOutputStream fos = new FileOutputStream(filePath.toFile());
        workbook.write(fos);

        Assertions.assertEquals("A", sheet.getRow(3).getCell(2).toString());

        fis.close();
        workbook.close();
        fis.close();

    }

}
