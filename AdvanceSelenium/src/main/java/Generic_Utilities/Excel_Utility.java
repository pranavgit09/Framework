package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * This method is used to read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 * @author Diksha
	 */

	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable, IOException {
		// Reading Data from Excel
				FileInputStream fes = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
				// step2:-keep excel file in read mode
				Workbook book = WorkbookFactory.create(fes);

				// step3:-taking Control of the excel sheet
				Sheet sheet = book.getSheet(sheetName);

				// step4:-taking Control of the rows
				Row row = sheet.getRow(rowNum);

				// step5:-taking Control of the cell
				Cell cel = row.getCell(cellNum);

				String excelData = cel.getStringCellValue();
		return excelData;
	}
	
	public String getExcelDataUsingFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		// Reading Data from Excel
		FileInputStream fes = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		// step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);

		// step5:-taking Control of the cell
		Cell cel = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cel);
		System.out.println(excelData);
        return excelData;
}
	public Object[][] getDataProviderData(String sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		int lastrow =  sheet.getLastRowNum()+1;
		int lastcell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastrow][lastcell];
		
		for (int i = 0; i <lastrow ; i++)
		{
			for(int j = 0; j <lastcell ; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
	}
}