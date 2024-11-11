package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\convert.xlsx");
		//Creating a workbook
		XSSFWorkbook Workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = Workbook.getSheetAt(0);
		//System.out.println("\n");
		System.out.println(Workbook.getSheetAt(0));

		String data2 = "";

		for(int i=1; i<= 34; i++){

			data2=data2+"{";

			for(int j=0; j< 16; j++){

				if (j< 15) {
					data2 = data2 +'"'+sheet.getRow(i).getCell(j)+'"'+',';}
				
				else {
					data2 = data2 +'"'+sheet.getRow(i).getCell(j)+'"'+"},";
				}

			}

		}
		System.out.println("\n");
		System.out.println(data2);

	}
}