package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args){
		Spreadsheet test = new Spreadsheet();
		Scanner hi = new Scanner(System.in);
		String tests = hi.next();
		do{
			tests = hi.next();
			test.processCommand(tests);
		}while(!tests.equals("quit"));
		SpreadsheetLocation s = new SpreadsheetLocation("D5");
		System.out.println(s.getCol());
		System.out.println(s.getRow());
		                      
	}
}
