package DDT;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPDF {

	public static void main(String[] args) throws Throwable {

		File fis = new File("./src/test/resources/java notes 1-8.pdf");
		
		PDDocument doc = PDDocument.load(fis);
		
		int pages = doc.getNumberOfPages();
		System.out.println(pages);                     //prints total number of pages in pdf
		
		PDFTextStripper pdfData = new PDFTextStripper();  //object of pdftextstipper for reading data
		//String read = pdfData.getText(doc);
		//System.out.println(doc);                       //prints all data from pdf
		
		pdfData.setStartPage(4);;
		String read = pdfData.getText(doc);
		System.out.println(read);                      //prints data from page 4
		
		//pdfData.setStartPage(1);
		//pdfData.setEndPage(4);
		//String read = pdfData.getText(doc);              //prints data from page 1 to page 4  
		//System.out.println(read);
}
}
