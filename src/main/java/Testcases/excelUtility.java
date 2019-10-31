package Testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelUtility {
	
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static MissingCellPolicy xRow;
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	@Test
	public static void setExcelFile(String Path, String SheetName) {
		        try {
		            // Open the Excel file
		            FileInputStream ExcelFile = new FileInputStream(Path);
		            // Access the required test data sheet
		            ExcelWBook = new XSSFWorkbook(ExcelFile);
		            ExcelWSheet = ExcelWBook.getSheet(SheetName);

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }}

		    // This method is to read the test data from the Excel cell, in this we are
		    // passing parameters as Row num and Col num
    public static String getCellData(int RowNum, int ColNum) {
		        try {
		           Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		            String CellData = Cell.getStringCellValue();
		            return CellData;
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        return "";
		    }
    
	@Test
    public static void setCellData(String Result, int RowNum, int ColNum)throws Exception {

		        try {
		            Row = ExcelWSheet.getRow(RowNum);
		           Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
		            if (Cell == null) {
		                Cell = Row.createCell(ColNum);
		                Cell.setCellValue(Result);
		            } else {
		                Cell.setCellValue(Result);
		            }
		            // Constant variables Test Data path and Test Data file name
		            FileOutputStream fileOut = new FileOutputStream(constantParams.Path_TestData + constantParams.File_TestData);
		            ExcelWBook.write(fileOut);
		            fileOut.flush();
		            fileOut.close();
		        } catch (Exception e) {

		            throw (e);
}}
	
	@Test
    public  static Object[][] realExcelForSpecificRow(String Path , String SheetName, int columnSize, int rowNumber) throws IOException {

        @SuppressWarnings("resource")
        XSSFWorkbook excel = new XSSFWorkbook(Path);
        XSSFSheet sheet = excel.getSheet(SheetName);
        int rowSize = sheet.getLastRowNum();

        String xslData1;
        double xslNumericData;
        XSSFCell checkData;
        Object[][] data = new Object[1][columnSize];
    if(rowNumber <= rowSize){
     for (int j = 0; j < columnSize; j++) {
                checkData = sheet.getRow(rowNumber).getCell(j);
                if (checkData != null) {

                    CellType type = sheet.getRow(rowNumber).getCell(j).getCellTypeEnum();

                    if (type == CellType.STRING) {

                    xslData1 = sheet.getRow(rowNumber).getCell(j).getStringCellValue();

                        data[0][j] = xslData1;
                    } else if (type == CellType.NUMERIC) {
                        xslNumericData = sheet.getRow(rowNumber).getCell(j).getNumericCellValue();

                        data[0][j] = xslNumericData;

                    } else {                    }}   }
    }else {
        // report that the selected row number is out of the range
    }
 return data;
     }
	
	   public static void excelinstance(){
			excelUtility.setExcelFile(constantParams.Path_TestData + constantParams.File_TestData,"test-data");

	    }
}
