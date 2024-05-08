package resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.ExcelReader;
import util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataDriven {

    private static final String EXTERNAL_DATA_PATH = "src/main/java/resources/external_data/pcx_data.xlsx";

    private DataDriven() {
    }

    public static List<String> getTestData(String sheetName, String testCase) throws IOException {
        List<String> testDataList = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(EXTERNAL_DATA_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                    Row first = rows.next();
                    Iterator<Cell> cell = first.cellIterator();
                    int r = 0;
                    int c = 0;
                    while (cell.hasNext()) {
                        Cell value = cell.next();
                        if (value.getStringCellValue().equalsIgnoreCase("Test Cases")) {
                            c = r;
                        }
                        r++;
                    }
                    while (rows.hasNext()) {
                        Row r2 = rows.next();
                        if (r2.getCell(c).getStringCellValue().equalsIgnoreCase(testCase)) {
                            Iterator<Cell> cv = r2.cellIterator();
                            while (cv.hasNext()) {
                                Cell cell2 = cv.next();
                                if (cell2.getCellType() == CellType.STRING) {
                                    testDataList.add(cell2.getStringCellValue());
                                } else {
                                    testDataList.add(NumberToTextConverter.toText(cell2.getNumericCellValue()));
                                }
                            }
                        }
                    }
                }
            }
            return testDataList;
        }
    }

    private static List<String> getTestDataFromSheet(XSSFSheet sheet, String testCase) {
        List<String> testDataList = new ArrayList<>();

        Row firstRow = sheet.getRow(0);
        int testCaseIndex = findTestCaseColumnIndex(firstRow, testCase);
        if (testCaseIndex != -1) {
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip the first row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell testCaseCell = row.getCell(testCaseIndex);
                if (testCaseCell != null && testCaseCell.getStringCellValue().equalsIgnoreCase(testCase)) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        testDataList.add(getCellValueAsString(cell));
                    }
                    break;
                }
            }
        }
        return testDataList;
    }

    private static int findTestCaseColumnIndex(Row firstRow, String testCase) {
        /**
         * Please ignore the code smell for String testCase parameter, this need to be here.
         */
        Iterator<Cell> cellIterator = firstRow.cellIterator();
        int columnIndex = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getStringCellValue().equalsIgnoreCase("Test Cases")) {
                return columnIndex;
            }
            columnIndex++;
        }
        return -1;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else {
            return NumberToTextConverter.toText(cell.getNumericCellValue());
        }
    }

    public static void writeData(int rowNumber, int columnNumber, String data) throws IOException {
        try (FileInputStream fis = new FileInputStream(EXTERNAL_DATA_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(EXTERNAL_DATA_PATH)) {

            XSSFSheet sheet = workbook.getSheet("Workflow Data");
            XSSFRow row = sheet.getRow(rowNumber);
            XSSFCell cell = row.getCell(columnNumber);

            if (cell == null) {
                row.createCell(columnNumber);
                cell.setCellValue(data);
            } else {
                cell.setCellValue(data);
            }

            workbook.write(fos);
        }
    }

    public static String readExcelColumnCucumber(String columnName, String sheetName, int rowNumber) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(EXTERNAL_DATA_PATH, sheetName);
        String rowId = testData.get(rowNumber).get(columnName);
        Log.info("id : " + rowId);
        return rowId;
    }
}


