package morningClass.week3;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class C45WriteExcel {
    /*
        Create an object of File class to open xlsx file.
        Create an object of FileInputStream class to read Excel file.
        Creating workbook instance that refers to .xlsx file.
        Creating a Sheet object.
        Create a row object to retrieve row at index 3.
        Create a cell object to enter value in it using cell Index.
        Write the data in Excel using output stream.
    */
    Path filePath = Path.of("./", "resources", "Countries.xlsx");

    @Test
    public void writeExcelTest() {
        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read Excel file.
        Workbook workbook;
        //try with resources
        try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
            workbook = WorkbookFactory.create(fis);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Creating workbook instance that refers to .xlsx file.
        //Creating a Sheet object.
        Sheet sheet = workbook.createSheet("New Sheet");

        //Create a row object to retrieve row at index 3.
        Row row = sheet.createRow(3);

        //Create a cell object to enter value in it using cell Index.
        Cell cell = row.createCell(0);

        //Write the data in Excel using output stream.
        cell.setCellValue("USA");
        try (FileOutputStream fos = new FileOutputStream(filePath.toFile());) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Add Population column to the countries
    @Test
    public void addNewColumn() throws IOException {

        Workbook workbook;
        //HW: print populations of the countries
        try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
            workbook = WorkbookFactory.create(fis);
        }
        Sheet sheet = workbook.getSheet("Sheet1");
        sheet.getRow(0).createCell(2).setCellValue("Population");
        FileOutputStream fos = new FileOutputStream(filePath.toFile());
        workbook.write(fos);
        workbook.close();
        fos.close();


    }

}

