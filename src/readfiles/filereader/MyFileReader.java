package readfiles.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
	public static void main(String[] args) {
		
		File file = new File("src/readfiles/example.txt");
		BufferedReader br;
		FileReader fr;
		try {
			 fr = new FileReader(file);
			
			// Lets buffer
			 br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {				
				System.out.println(line);
				// Use StringBuilder if you need to concatenate strings
			}
			
			br.close(); // closes br, fr, then file.
		} catch (FileNotFoundException e) {
			System.out.println("File not found: "+file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file");
		}
		
		
	}
}
