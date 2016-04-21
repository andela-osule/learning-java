package readfiles.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadWithCount {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "src/readfiles/textwithnumberoflines.txt";  // use relative path of working directory.
		File textFile = new File(fileName);
		
		// Traditional way of reading files is using Buffer class
		
		Scanner in = new Scanner(textFile);
		int count = in.nextInt();
		System.out.println("Read value:" + count);
		
		in.nextLine();
		
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if(count == 0) {
				break;
			}
			System.out.println("Read: " + line);
			count--;
		}
		
		in.close();
	}
}
