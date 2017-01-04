import edu.duke.*;


public class SomeFile {
    public void file() {
        URLResource res = new URLResource("http://www.dukelearntoprogram.com/java/somefile.txt");
        
        for(String word: res.words()) {
            System.out.println(word);
        }
    }
}
