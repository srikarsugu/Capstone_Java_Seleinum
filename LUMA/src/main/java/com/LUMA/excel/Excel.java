package com.LUMA.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    // Method to read data from an Excel file and return it as a list of lists
    public static List<List<String>> dataFromExcel(String filePath, int sheetNo) {
        List<List<String>> credentials = null;

        try {
            credentials = new ArrayList<>(); // Initializing the list to store Excel data
            
            // Opening the Excel file
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file); // Creating a workbook instance
            Sheet sheet = workbook.getSheetAt(sheetNo); // Accessing the specified sheet

            // Iterating through each row in the sheet
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>(); // List to store row data

                if (row != null) {
                    // Iterating through each cell in the row
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);

                        if (cell != null) {
                            try {
                                // Attempting to read the cell as a string
                                rowData.add(cell.getStringCellValue());
                            } catch (Exception e) {
                                // If an exception occurs (e.g., numeric value), convert it to a string
                                rowData.add(String.valueOf((int) cell.getNumericCellValue()));
                            }
                        } else {
                            // If the cell is null, add an empty string
                            rowData.add("");
                        }
                    }
                }
                // Adding the row data to the main list
                credentials.add(rowData);
            }
            workbook.close(); // Closing the workbook

        } catch (Exception e) {
            System.out.println("Exception in dataFromExcel method: " + e); // Handling exceptions
        }

        return credentials; // Returning the extracted data
    }
}
