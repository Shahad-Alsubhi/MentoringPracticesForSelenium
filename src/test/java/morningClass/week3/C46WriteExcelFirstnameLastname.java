package morningClass.week3;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class C46WriteExcelFirstnameLastname {

    //Create Firstname and Lastname Columns and write names in a new sheet

    @Test
    public void excelTest() throws IOException {

        // Create new workbook
        //create true for .xlsx , false for .xls
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Create a new sheet
        Sheet sheet = workbook.createSheet("new sheet");

        //Create Firstname and Lastname Columns
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("First Name");
        headerRow.createCell(1).setCellValue("Last Name");

        //Fill some rows
        String[][] employees = {
                {"John", "Doe"},
                {"Jane", "Smith"},
                {"Michael", "Johnson"},
                {"Emily", "Davis"},
                {"David", "Wilson"}
        };

        for (String[] employee : employees) {
            sheet.createRow(sheet.getPhysicalNumberOfRows()).createCell(0).setCellValue(employee[0]);
            sheet.getRow(sheet.getPhysicalNumberOfRows() - 1).createCell(1).setCellValue(employee[1]);
        }
        FileOutputStream fos = new FileOutputStream("./resources/Names.xlsx");
        workbook.write(fos);
        workbook.close();
        fos.close();

    }
}

