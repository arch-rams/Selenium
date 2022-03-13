package com.seleniumProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.sl.Ce;

public class ExternalUtil {

	public static String[][] readFromExcel(String wrkBook, String wrkSheet) throws IOException {
		// Setup file path
		XSSFWorkbook wBook = new XSSFWorkbook(
				"./src/main/resources/InputData/" + wrkBook + ".xlsx");
		// Get into the sheet
		XSSFSheet ws = wBook.getSheet(wrkSheet);

		// get no. of rows and col
		int rows = ws.getLastRowNum();
		System.out.println("The number of rows are: " + rows);

		int allrows = ws.getPhysicalNumberOfRows();
		short col = ws.getRow(0).getLastCellNum();
		System.out.println("The number of col are: " + col);

		String[][] data = new String[rows][col];

		// Get into rows
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = ws.getRow(i);
			// get into cells
			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				String cellVal = cell.getStringCellValue();
				data[i - 1][j] = cellVal;
			}
		}
		wBook.close();
		
		return data;
	}

	public static String updateExcel(List<List<String>> data, String wrkBook, String wrkSheet) throws IOException {

		// Open Workbook
		FileInputStream file = new FileInputStream(
				"./src/main/resources/InputData/" + wrkBook + ".xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(file);
		// Open workSheet
		XSSFSheet ws = wBook.getSheet(wrkSheet);
		// int rowNum = ws.getLastRowNum();
		XSSFRow row = ws.getRow(0);

		/*
		 * if (data.size() != rowNum) { return "input data size not equal"; }
		 */
		// Get the headers from the workbook
		List<String> bookHeaders = new ArrayList<>();
		row.cellIterator().forEachRemaining(str -> {
			bookHeaders.add(str.getStringCellValue());
		});

		// iterate over the rows and update values in the given cells under correct
		// heading
		for (int i = 1; i < data.size(); i++) {
			for (int j = 1; j < data.get(0).size(); j++) {
				// Find the rowNum in which data needs to be updated
				int rowNum = findRow(ws, data.get(i).get(0));
				if (rowNum == -1) {
					return "row with matching ticket not found";
				}
				row = ws.getRow(rowNum);

				// Get the column name and match with list column name
				String colTitle = data.get(0).get(j);
				int index = bookHeaders.indexOf(colTitle);

				// Find the cell where data needs to be added
				Cell cell = row.getCell(index);
				if (cell == null) {
					cell = row.createCell(j);
				}
				if (cell.getStringCellValue().isEmpty()) {
					cell.setCellValue(data.get(rowNum).get(j));

				} else {
					System.out.println("Overriding cell value: " + cell.getStringCellValue());
					cell.setCellValue(data.get(rowNum).get(j));
				}
			}
		}

		file.close();

		// stream content and close the file
		FileOutputStream outFile = new FileOutputStream(
				"./src/main/resources/InputData/" + wrkBook + ".xlsx");
		wBook.write(outFile);
		outFile.close();

		return "Success";

	}

	private static int findRow(XSSFSheet ws, String rowIndicator) {
		for (Row row : ws) {
			for (Cell cell : row) {
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().trim().equalsIgnoreCase(rowIndicator))
						return row.getRowNum();
				}
			}
		}
		return -1;
	}

}
