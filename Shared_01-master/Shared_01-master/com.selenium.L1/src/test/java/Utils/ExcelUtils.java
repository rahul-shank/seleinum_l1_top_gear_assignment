/*
 * 
 * Author: Rahul S
 * Emp Id: RA20081501
 * Last Modified: 08/06/2020
 * 
 * Topic: Topgear Selenium Hands-on
 * 
 * Features used: Selenium, Data driven(Excel), Maven-TestNG framework
 * 
 * 
 */

package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import Configuration.PropertiesFile;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String cellDataString;
	static double cellDataNum;

	public ExcelUtils(String excelPath, String sheetName) {

		// projectPath = System.getProperty("user.dir");
		// System.out.println(projectPath);
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);

	}

	public static String getCellDataString(int rowNum, int colNum) {

		cellDataString = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellDataString);

		return cellDataString;

	}

	public static double getCellDataNumber(int rowNum, int colNum) {

		cellDataNum = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellDataNum);

		return cellDataNum;
	}

}