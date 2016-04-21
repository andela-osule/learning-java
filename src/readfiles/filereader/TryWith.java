package readfiles.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Temp implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Closing!");
		
	}
	
}

public class TryWith {
	public static void main(String[] args) {
		Temp temp = new Temp();
		
		try {
			temp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// using try with resources. Resource class must have an implement close method.
		try(Temp tempA = new Temp()) {
			// close is automatically closed.
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		File file = new File("src/readfiles/example.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			} 
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}
	
	}
}
