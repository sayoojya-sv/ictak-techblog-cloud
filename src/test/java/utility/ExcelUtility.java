package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream fle;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static String readExcel(int rowc,int colc) throws IOException {
		fle=new FileInputStream("C:\\Users\\sayoojya\\OneDrive\\Desktop\\dockerictaktech\\dockerictak\\src\\test\\resources\\ICTAK-Login.xlsx");
	    workbook=new XSSFWorkbook(fle);
	    sheet=workbook.getSheetAt(0);
	    return sheet.getRow(rowc).getCell(colc).getStringCellValue();
	
	}

}
