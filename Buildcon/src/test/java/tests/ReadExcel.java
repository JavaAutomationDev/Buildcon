package tests;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\convert.xlsx");
		
		//Creating a workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println(workbook.getSheetAt(0));

		String data2 = "";

		for(int i=1; i<= 150; i++){

			data2=data2+"{";

			for(int j=0; j< 10; j++){

				if (j< 9) {
					data2 = data2 +'"'+sheet.getRow(i).getCell(j)+'"'+',';}
				else {
					data2 = data2 +'"'+sheet.getRow(i).getCell(j)+'"'+"},";
				}

			}

		}
		System.out.println(data2);
	}
}
