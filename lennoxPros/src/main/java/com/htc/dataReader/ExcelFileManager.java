package com.htc.dataReader;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.htc.base.BaseTest;
import com.htc.constants.Constants;

import org.apache.poi.ss.usermodel.Sheet;

public class ExcelFileManager extends BaseTest {
	private Object[][] data = null;

	public ExcelFileManager() {
		super();

	}

	private Workbook book;

	private Sheet sheet;

	public Object[][] getTestData(String sheetName) {

		String PAGE_LOAD_DATA = Constants.EXCEL_PATH;

		FileInputStream file = null;
		try {
			file = new FileInputStream(PAGE_LOAD_DATA);
			book = WorkbookFactory.create(file);

		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		data = new Object[sheet.getLastRowNum()][1];

		for (int Row = 0; Row < sheet.getLastRowNum(); Row++) {

			Map<Object, Object> dataMap = new HashMap<Object, Object>();

			for (int col = 0; col < sheet.getRow(Row).getLastCellNum(); col++) {

				dataMap.put(sheet.getRow(0).getCell(col).toString(), sheet.getRow(Row + 1).getCell(col).toString());

			}
			data[Row][0] = dataMap;
		}
		return data;
	}
}
