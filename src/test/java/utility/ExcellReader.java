package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReader {
	
	public static String readData(int row, int column) throws IOException
	{
String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata1.xlsx";
		
		File file = new File(path);
		
//		to perform Read operation we have to use file input stream class
		
		FileInputStream fis = new FileInputStream(file);
		
//		To locate the workbook
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
//		To locate the sheet
		
		XSSFSheet sh1 = wb.getSheetAt(0);
		
		DataFormatter df = new DataFormatter();
		
String value = df.formatCellValue(sh1.getRow(row).getCell(column));
		
		
		return value;
		
		
	}
	

}
