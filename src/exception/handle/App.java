package exception.handle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class App {

	public static void main(String[] args) throws IOException {
		File file = new File("src/ExcHandler/test.txt");
		
		FileReader fr = new FileReader(file);
		
		
		fr.close();
		
		// can us try/catch as well
		
		Test test  = new Test();
		try {
			test.run();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Caught Exception");
			e.printStackTrace();
		}
		
		// You can catch multiple exception in order of specificity
		try {
			test.input();	
		} catch (FileNotFoundException e){
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}

}
