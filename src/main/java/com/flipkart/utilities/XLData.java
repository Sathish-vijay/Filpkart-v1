package com.flipkart.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLData {

	public static String path = "C:\\Users\\Lenovo\\eclipse-workspace\\filpkart\\src\\main\\java\\com\\filpkart\\testData\\Flipkartlogindat.xlsx";

	public static File src;

	public static FileInputStream fis;

	public static XSSFWorkbook wb;

	public static XSSFSheet sheet;

	public static int getrowcount() throws Exception {

		src = new File(path);

		fis = new FileInputStream(src);

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheetAt(0);

		int NumberOfRows = sheet.getPhysicalNumberOfRows();

		return NumberOfRows;

	}

	public static int getcellcount() throws Exception {

		src = new File(path);

		fis = new FileInputStream(src);

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheetAt(0);

		Row row = sheet.getRow(0);

		int NumberOfCells = row.getPhysicalNumberOfCells();

		return NumberOfCells;

	}

	public static String getCellData(int rownumber, int cellnumber) throws Exception {

		src = new File(path);

		fis = new FileInputStream(src);

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheetAt(0);

		Row row = sheet.getRow(rownumber);
		Cell cell = row.getCell(cellnumber);

		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;

	}

}
