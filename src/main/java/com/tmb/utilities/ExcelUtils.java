package com.tmb.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstant;

public final class ExcelUtils {

	private ExcelUtils() {
	};

	public static List<Map<String, String>> getRunnerData(String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(FrameworkConstant.getExcelTestDataPath());

		XSSFWorkbook workBook = new XSSFWorkbook(file);

		XSSFSheet sheet = workBook.getSheet(sheetName);

		int lastRowNum = sheet.getLastRowNum();

		int lastCellNum = sheet.getRow(0).getLastCellNum();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 1; i <= lastRowNum; i++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < lastCellNum; j++) {

				DataFormatter formatter = new DataFormatter();
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));

				map.put(key, value);

			}
			list.add(map);

		}

		workBook.close();
		file.close();

		return list;
	}

}
