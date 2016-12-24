package VigenereProgram;
import edu.duke.*;
import java.util.*;

public class TestVigenere {
    public void sliceString() {
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
    }
    
    public void tryKeyLength() {
        VigenereBreaker vb = new VigenereBreaker();
        FileResource encryptedFile = new FileResource();
        String encrypted = encryptedFile.asString();
        int [] keys = vb.tryKeyLength(encrypted, 38, 'e');
        
        VigenereCipher vc = new VigenereCipher(keys);
        String message = vc.decrypt(encrypted);
        
        FileResource dictFile = new FileResource();
        HashSet<String> dict = vb.readDictionary(dictFile);
        
        System.out.println("Valid words: " + vb.countWords(message, dict));
        System.out.println(Arrays.toString(keys));
        
    }
}
