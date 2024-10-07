//for reading data from excel we need to add latest version's Apache poi dependency to pom.xml

package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		 //step 1 : path representation(give local disk path as this will not support excel from eclipse)
	  FileInputStream fis = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		
		//step 2 : keeping the workbook file in read mode
	 Workbook book = WorkbookFactory.create(fis);
		
		//step 3 : get the control of the sheet 1
	 Sheet sheet = book.getSheet("Sheet1");
	  
	   //step 4 : get the control of the row
	 Row row = sheet.getRow(0);
	  
	  //step 5 : get the control of the cell
	 Cell cel = row.getCell(5);
	 
	 DataFormatter format = new DataFormatter();
	 String ExcelData = format.formatCellValue(cel);
	 System.out.println(ExcelData);
	}

}
