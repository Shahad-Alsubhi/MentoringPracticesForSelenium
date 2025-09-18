package morningClass.week3;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class C44ReadExcellFile {
    /*
        Add the excel file on the resources folder.
        Open the file.
        Open the workbook using file input stream.
        Open the first worksheet.
        Go to first row.
        Go to first cell on that first row and print.
        Go to second cell on that first row and print.
        Go to 2nd row first cell and assert if the data equal to the USA.
        Go to 3rd row and print 2nd cell
        Find the number of used row.
        Print country, capital value pairs as map object.
        Verify that you have Canada on the list
    */
    @Test
    public void readExcelTest() throws IOException {
        //       Add the excel file on the resources folder.
        //       Open the file.


        //       Open the workbook using file input stream.

        Path filePath = Path.of(".", "resources", "Countries.xlsx");

        FileInputStream fis = new FileInputStream(filePath.toString());

        //       Open the first worksheet.

        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();
        //       Go to first row.

        Sheet sheet = workbook.getSheet("Sheet1");
        //       Go to first cell on that first row and print.
        System.out.println("sheet.getRow(0).getCell(0) = " + sheet.getRow(0).getCell(0));

        //       Go to second cell on that first row and print.
        System.out.println("sheet.getRow(0).getCell(1) = " + sheet.getRow(0).getCell(1));
        //       Go to 2nd row first cell and assert if the data equal to the USA.
        Assertions.assertEquals("USA", sheet.getRow(1).getCell(0).toString());

        //       Go to 3rd row and print 2nd cell
        System.out.println("sheet.getRow(2).getCell(1) = " + sheet.getRow(2).getCell(1));


//       Find the number of used row.
        System.out.println("sheet.getLastRowNum() = " + sheet.getLastRowNum()); // index of last row
        System.out.println("sheet.getPhysicalNumberOfRows() = " + sheet.getPhysicalNumberOfRows());

//       Print country, capital value pairs as map object.
//        sheet.n
        Map<String, String> countryCapitalMap = new HashMap<>();
        for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
            String country = sheet.getRow(rowIndex).getCell(0).toString();
            String capital = sheet.getRow(rowIndex).getCell(1).toString();
            countryCapitalMap.put(country, capital);
        }
        System.out.println("countryCapitalMap = " + countryCapitalMap);


        Assertions.assertTrue(countryCapitalMap.containsKey("Canada"));
    }


    //create a method to return cell data by given row and cell numbers and sheet
}
