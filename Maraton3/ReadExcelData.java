package Maraton3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static String[][] readData(String dataFile) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./dataSheet/"+dataFile+".xlsx");
		
		XSSFSheet sheetAt = wb.getSheetAt(0);
		
		int rowSize = sheetAt.getLastRowNum();
		
		int columnSize = sheetAt.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowSize][columnSize];
		
		for (int i = 1; i <= rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				String cellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		
		wb.close();
		return data;
		
	}


}
