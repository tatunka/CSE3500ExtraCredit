package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import search.Point;

public class ScanTest {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/xy.csv");
		Scanner scan = new Scanner(file);
		scan.next();
		for(int i = 0; i<5; i++){
			Scanner scanner = new Scanner(scan.next());
			Scanner pScan = scanner.useDelimiter(",");
			while(pScan.hasNext()){
				String x = pScan.next();
				String y = pScan.next();
				Point p = new Point(Float.valueOf(x), Float.valueOf(y));
				System.out.println(p.toString());
			}
			scanner.close();
			pScan.close();
		}
		scan.close();
	}
	
	
}
