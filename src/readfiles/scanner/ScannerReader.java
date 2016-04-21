package readfiles.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReader {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "/Users/oluwafemisule/Documents/workspace/learning-java/src/readfiles/example.txt";
		File textFile = new File(fileName);
		
		//Traditional way of reading files is using Buffer class
		
		Scanner in = new Scanner(textFile);
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println(line);
		}
		
		in.close();
	}
}
