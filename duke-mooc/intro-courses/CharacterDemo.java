public class CharacterDemo {
    public void digitTest() {
        String test = "ABCabc0123456789';#!";
        for (int k=0; k < test.length(); k++) {
            char ch = test.charAt(k);
            
            if(Character.isDigit(ch)) {
                System.out.println(ch + " is a digit");
            }
            
            if(Character.isAlphabetic(ch)) {
                System.out.println(ch + " is alphabetic");
            }
            
        }
    }
    
    public void conversionTest() {
        String test = "ABCDEFabc0123456789';#!";
        for (int k=0; k < test.length(); k++) {
            char ch = test.charAt(k);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            
            System.out.println(ch + " " + uch + " " + lch);
            
        }
    }
    
}
