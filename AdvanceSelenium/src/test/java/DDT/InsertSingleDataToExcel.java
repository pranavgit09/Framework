//Insert data to excel

package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {

		 //step 1 : path representation(give local disk path as this will not support excel from eclipse)
		  FileInputStream fis = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
			
			//step 2 : keeping the workbook file in read mode
		 Workbook book = WorkbookFactory.create(fis);
			
			//step 3 : get the control of the sheet 1
		 Sheet sheet = book.getSheet("Sheet1");
		  
		   //step 4 : taking control of the row
		 Row row = sheet.createRow(8);
		  
		  //step 5 : taking control of the cell
		 Cell cel = row.createCell(8);
		 
		 //step 6 : insert single data to particular cell
		 cel.setCellValue("Qspiders");
		 
		 //step 7 : keep excel in write mode to write given data and then close
		 FileOutputStream fos = new FileOutputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		 book.write(fos);
		 book.close();


	}

}
