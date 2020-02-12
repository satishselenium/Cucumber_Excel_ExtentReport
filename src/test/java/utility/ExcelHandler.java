package utility;
 
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import driverfactory.BaseTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
//import static tests.BaseTest.testDataExcelFileName;
 
/**
 * Created by obaskirt on 28-Oct-17.
 * Updated by obaskirt on 02-Apr-2019
 */
public class ExcelHandler extends BaseTest {
    //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");
 
    //Location of Test data excel file
    public static String testDataExcelPath = null;
 
    //Excel WorkBook
    private static XSSFWorkbook excelWBook;
 
    //Excel Sheet
    private static XSSFSheet excelWSheet;
 
    //Excel cell
    private static XSSFCell cell;
 
    //Excel row
    private static XSSFRow row;
 
    //Row Number
    public static int rowNumber;
 
    //Column Number
    public static int columnNumber;
 
    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }
 
    public static int getRowNumber() {
        return rowNumber;
    }
 
    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }
 
    public static int getColumnNumber() {
        return columnNumber;
    }
 
    public static Map<String, String> getTestDataInMap(String sheetName, String TestCaseId ) throws Exception {
    	setExcelFileSheet(sheetName);
    	int TotalRow = retrieveNoOfRows(sheetName);
    	int TotalCol = retrieveNoOfCols(sheetName);
    	int TestCaseExistRow = 0;
    	int TestCaseHeaderRow = 0;
    	Map<String, String> data = new HashMap<String, String>();
    	data.clear();
    	
    	boolean testcasefound = false,Headerfound=false;
    	for (int i =0;i<=TotalRow-1;i++) {
    		if (!(getCellData(i,0)==null)) {
    			if (getCellData(i,0).equalsIgnoreCase(TestCaseId)) {
        			TestCaseExistRow = i;
        			testcasefound=true;
        			break;
        		}
    		}
    	}
    	if (testcasefound=false) {
    		throw new Exception("test case with name = "+TestCaseId+" is not found in "+sheetName+" under TestCaseId"); 
    	}
    	for (int j =TestCaseExistRow;j>=0;j--) {
    		if (getCellData(j,0).equalsIgnoreCase("TestCaseId")) {
    			TestCaseHeaderRow = j;
    			Headerfound=true;
    			break;
    		}
    	}
    	if (Headerfound=false) {
    		throw new Exception("Header not found for TestCase ID = "+TestCaseId); 
    	}
    	
    	for (int h = 0;h<=TotalCol-1;h++) {
    		String Header = getCellData(TestCaseHeaderRow , h);
    		String CellDate = getCellData(TestCaseExistRow , h);
    		data.put(Header, CellDate);
    	}
    	return data;
    }
    
    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    public static void setExcelFileSheet(String sheetName) {
        //MAC or Windows Selection for excel path
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "//src//test//java//resources//";
        } else if (Platform.getCurrent().toString().contains("WIN")) {
            testDataExcelPath = currentDir + "\\Data\\";
        }
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
 
    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) {
    	String cellData;
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            cellData = formatter.formatCellValue(cell);
            //return cellData;
        } catch(NumberFormatException | NullPointerException exc) {
        	cellData = "";
        }
        catch (Exception e) {
            throw (e);
        }
		return cellData;
    }
 
    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }
 
    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int RowNum, int ColNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
  //To retrieve No Of Rows from .xls file's sheets.
  	public static int retrieveNoOfRows(String wsName){		
  		int sheetIndex=excelWBook.getSheetIndex(wsName);
  		if(sheetIndex==-1)
  			return 0;
  		else{
  			excelWSheet = excelWBook.getSheetAt(sheetIndex);
  			int rowCount=excelWSheet.getLastRowNum()+1;		
  			return rowCount;		
  		}
  	}
  	
  //To retrieve No Of Columns from .cls file's sheets.
  	public static int retrieveNoOfCols(String wsName){
  		int sheetIndex=excelWBook.getSheetIndex(wsName);
  		if(sheetIndex==-1)
  			return 0;
  		else{
  			excelWSheet = excelWBook.getSheetAt(sheetIndex);
  			int colCount=excelWSheet.getRow(0).getLastCellNum();			
  			return colCount;
  		}
  	}
}