package writefiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

	public static void main(String[] args) {
		File file = new File("src/writefiles/example.txt");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write("One");
			bw.newLine();
			bw.write("Two");
			bw.newLine();
			bw.write("Three");
		} catch (IOException e){
			System.out.println("Can't not write file "+file.toString());
		}
		
	}

}
