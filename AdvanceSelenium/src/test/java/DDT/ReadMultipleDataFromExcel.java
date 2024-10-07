package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		
		 Workbook book = WorkbookFactory.create(fis);

		 Sheet sheet = book.getSheet("Sheet1");
		 
		 int rownum = sheet.getLastRowNum();
		 System.out.println(rownum);              //prints total number of links present in excel
		 
		 for(int i = 0; i < rownum; i++) 
		 {
			 Row row = sheet.getRow(i);
			 
			 for(int j=0; j<row.getLastCellNum();j++) 
			 {
				 Cell cel = row.getCell(j);
				 String links = cel.getStringCellValue();
				 System.out.println(links);
			 }
			 
			 
		 }
		 
		 FileOutputStream fos = new FileOutputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		 book.write(fos);
		 book.close();
	}

}
