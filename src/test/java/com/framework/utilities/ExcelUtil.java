package com.framework.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelUtil {

    public FileInputStream fileInStream = null;
    public FileOutputStream fileOutStream = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelUtil(String filepath){
        try{
            fileInStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(fileInStream);
            sheet = workbook.getSheetAt(0);
            fileInStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // return excel data as HashMap  with testCase Name
    public HashMap<String, String> getExcelData(String sheetName, String TestCase) throws IOException {

        DataFormatter format = new DataFormatter();


        HashMap<String, String> excelData = new HashMap<>();

        HashMap<String, String> currentRowData;

        List<String> columnHeader = new ArrayList<>();
        try {

            int index = workbook.getSheetIndex(sheetName);

            if (index == -1)
                return null;
            sheet = workbook.getSheetAt(index);
            int rowCount = sheet.getLastRowNum();
            if (rowCount == 0)
                return null;

            int cellCount = sheet.getRow(0).getLastCellNum();

            //update all column headers


            for (int iRow = 0; iRow <= rowCount; iRow++) {
                row = sheet.getRow(iRow);
                currentRowData = new HashMap<>();
                for (int iCell = 1; iCell <cellCount; iCell++) {

                    if (iRow == 0) {
                        columnHeader.add(row.getCell(iCell).getStringCellValue());
                    } else {
						if (!row.getCell(0).getStringCellValue().equalsIgnoreCase(TestCase)) {
							break;
						}
                        excelData.put(columnHeader.get(iCell-1), format.formatCellValue(row.getCell(iCell)));
                        //excelData.put(row.getCell(0).getStringCellValue(),currentRowData);
                    }
                }
            }

            System.out.println("excelData: " + excelData);

            fileInStream.close();

        } catch (Exception e) {

            e.printStackTrace();
            fileInStream.close();

        }

        return excelData;
    }
}
