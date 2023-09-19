package com.tedy.Banking.Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.tedy.Banking.Services.impl.YahooService;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class allows you to handle multiple symbols efficiently and process them one by one, making API requests and
 * inserting data for each symbol separately.
 * It's a reasonable approach for working with a batch of symbols from an Excel file.
 */
public class ExcelExtractor {

    private final YahooService yahooService;

    public ExcelExtractor(YahooService yahooService) {
        this.yahooService = yahooService;
    }

    public void extractAndSendToYahoo(String excelFilePath, int columnIndex) {
        try {
            FileInputStream file = new FileInputStream(excelFilePath = "C:/Users/tedyy/Downloads/Banking/Banking/src/main/java/com/tedy/Banking/CSVs/stocks-list.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to work with the first sheet

            // Iterate through the column and call fetchAndInsertDataFromYahoo for each extracted value
            for (Row row : sheet) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            String extractedValue = cell.getStringCellValue();
                            yahooService.fetchAndInsertDataFromYahoo(extractedValue); // Ensure 'extractedValue' is not null here
                            break;
                        case NUMERIC:
                            // Handle numeric values if needed
                            break;
                    }
                }
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
