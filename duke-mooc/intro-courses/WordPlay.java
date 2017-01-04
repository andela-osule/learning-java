import edu.duke.*;


public class WordPlay {
    public boolean isVowel(char ch) {
        String vowels = "aeiou";
        
        return vowels.indexOf(Character.toLowerCase(ch)) != -1;
    
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            if (isVowel(currChar)) {
               sb.setCharAt(i, ch);
            }

        }
        return sb.toString();
    }
    
    
    public String emphasize(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        
        for(int i = 0; i < sb.length(); i++) {
            char currChar = Character.toLowerCase(sb.charAt(i));
            
            if(currChar == Character.toLowerCase(ch) && i % 2 == 0) {
               sb.setCharAt(i, '*');
            }
            
            if(currChar == Character.toLowerCase(ch) && i % 2 == 1) {
               sb.setCharAt(i, '+');
            }

        }
        return sb.toString();
    }
    
    public void testIsVowel() {
        System.out.println(isVowel('A'));
    }
    
    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public void testEmphasize() {
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    
}
