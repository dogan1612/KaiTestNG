package com.Dogan.tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDemo {
    //to create on object that will store excel file
    Workbook workbook;
    //to create an object that will store specific sheet
    Sheet sheet;
    //to provide path to the file
    String path = "src/test/resources/Countries.xlsx";
    //to establish connection with excel file
    FileInputStream inputStream;
    //to write data into file, we need output stream
    //* A file output stream is an output stream for writing data to a File
    FileOutputStream fileOutputStream;

    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);

        workbook = WorkbookFactory.create(inputStream);

        fileOutputStream = new FileOutputStream(path);

        sheet = workbook.getSheet("Countries");
    }


    @Test
    public void putDataIntoListOfMapsTest2() {
        List<Map<String, String>> table = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        //outer loop will change rows
        for(int row=1; row<=rowCount; row++){
            //map that will contain key-value pair
            //key - it's column name
            //value - it's a cell value of specific row
            Map<String, String> map = new HashMap<>();
            //go through the row, and read all cells
            //create a key-value pair based on:
            //column name = cell value
            for(int column = 0; column < colCount; column++){
                String columnName = sheet.getRow(0).getCell(column).toString();
                String columnValue = sheet.getRow(row).getCell(column).toString();
                map.put(columnName, columnValue);
            }
            //add column name + column value into a list
            table.add(map);
        }
        for(Map<String, String> value: table){
            System.out.println(value);
        }
    }

    @Test
    public void writeDataTest(){
        Cell columnName = sheet.getRow(0).getCell(2);
        if(columnName == null){
            //to create a cell
            columnName = sheet.getRow(0).createCell(2);
        }
        //3rd column is completely empty
        //we will write down test result next to every data set
        columnName.setCellValue("Result"); // to write something into cell
        int rowCount = sheet.getLastRowNum();
        for(int row =1; row<=rowCount; row++){
            Row rowValue = sheet.getRow(row);
            Cell cell = rowValue.getCell(2);
            if(cell==null){
                cell = rowValue.createCell(2);
            }
            cell.setCellValue("PASS");
        }
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.write(fileOutputStream);
        workbook.close();
        inputStream.close();
    }
}