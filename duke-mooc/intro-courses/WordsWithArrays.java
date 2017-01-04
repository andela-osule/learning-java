import edu.duke.*;
import java.util.*;

public class WordsWithArrays {

    StorageResource myWords;
    
    public WordsWithArrays() {
        myWords = new StorageResource();
    }
    
    public void readWords() {
        myWords.clear();
        FileResource resource = new FileResource();
        for(String word: resource.words()) {
            myWords.add(word.toLowerCase());
        }
    }
    
    public boolean contains(String[] list, String word, int len) {
        for(int k=0; k < len; k++) {
            if(list[k].equals(word)) {
                return true;
            }
        }
        return false;
    }
    
    public int numOfUniqueWords() {
        int numStored = 0;
        String[] words = new String[myWords.size()];
        
        for(String s: myWords.data()) {
            if(!contains(words, s, numStored)) {
                words[numStored] = s;
                numStored++;
            }
        }
        return numStored;
    }
    
    public void tester() {
        readWords();
        System.out.println("number of words read: "+myWords.size());
        int unique = numOfUniqueWords();
        System.out.println("array count "+unique);
    }
}
