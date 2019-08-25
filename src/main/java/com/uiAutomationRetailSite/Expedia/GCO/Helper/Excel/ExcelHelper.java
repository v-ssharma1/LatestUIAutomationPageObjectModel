package com.uiAutomationRetailSite.Expedia.GCO.Helper.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	public static final Logger log = Logger.getLogger(ExcelHelper.class.getName());

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// get sheet from excel workbook
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// Count no of row in excelSheet.
			int totalRow = sheet.getLastRowNum();
			// Count active coumns
			int totalColumn = sheet.getRow(0).getLastCellNum();
			dataSets = new Object[totalRow + 1][totalColumn];
			// iterate through each row one by one.
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				// every row needs to be iterated over column.
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j - 1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i - 1][j - 1] = cell.getCellFormula();
						break;
					default:
						log.info("No matching data type found.");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateTestResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// get sheet from excel workbook
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// Count no of row in excelSheet.
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("Test Result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		} catch (Exception e) {
          e.fillInStackTrace();
		}
	}
}
