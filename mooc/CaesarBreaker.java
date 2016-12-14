import edu.duke.*;

public class CaesarBreaker {
    
   public String decrypt(String encrypted) {
        
        CommonLetters cl = new CommonLetters();
        int[] freqs = cl.countFrequency(encrypted);
        int maxDex = cl.maxIndex(freqs);
        int dkey = maxDex - 4;
        
        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26 - dkey);
        return cc.encrypt(encrypted);
    }
    
    
    public void testDecrypt() {
        System.out.println(decrypt("eeeeeeeeeeeeeeeees"));
    }
    
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder("");
        for(int k = start; k<message.length(); k += 2) {
            sb.append(message.charAt(k));
        }
        return sb.toString();
    }
    
    public int getKey(String s) {
        CommonLetters cl = new CommonLetters();
        int[] freqs = cl.countFrequency(s);
        int maxDex = cl.maxIndex(freqs);
        int key = maxDex - 4;
        
        if(maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        return key;
    }
    
    public void testHalfOfString() {
        System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    
    
    public String decryptTwoKeys(String encrypted) {
        String odd = halfOfString(encrypted, 0);
        String even = halfOfString(encrypted, 1);
        
        int key1 = getKey(odd);
        int key2 = getKey(even);
        
        CaesarCipher cc = new CaesarCipher(2);
        String message = cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
       
        System.out.println("Keys are: "+  key1 + "\t" + key2);
        return message;   
    }
    
    public void testDecryptTwoKeys() {
        FileResource fr = new FileResource();
        System.out.println(decryptTwoKeys(fr.asString()));
    }
}
