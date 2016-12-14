import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        for(int i = 0; i < encrypted.length(); i++ ) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            
            if(idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
            
            idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1 && Character.isLowerCase(currChar)) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, Character.toLowerCase(newChar));
            }
                
        }
        
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        for(int i = 0; i < encrypted.length(); i++ ) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            char newChar;
            
            if(idx != -1) {
                if (i % 2 == 0) {
                    newChar = shiftedAlphabet1.charAt(idx);
                } else {
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                encrypted.setCharAt(i, newChar);
            }
            
            idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1 && Character.isLowerCase(currChar)) {
                if (i % 2 == 0) {
                    newChar = shiftedAlphabet1.charAt(idx);
                } else {
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                encrypted.setCharAt(i, Character.toLowerCase(newChar));
            }
        }
        
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key); 
        System.out.println(decrypted);
    }
    
    public void testEncrypt() {
        String encrypted = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        
        System.out.println(encrypted);
        
        String decrypted = encrypt(encrypted, 11);
        System.out.println(decrypted);
        
    }
    
    public void testEncryptTwoKeys() {
        String encrypted = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        
        System.out.println(encrypted);
        
        String decrypted = encryptTwoKeys(encrypted, 18, 5);
        System.out.println(decrypted);
        
    }
}
