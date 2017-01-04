public class HowMany {

    public int howMany(String stringa, String stringb){
        int found = 0;
        int currIndex = 0;
        int lena = stringa.length();
        
        while(true) {
            currIndex = stringb.indexOf(stringa, currIndex);
            
            if (currIndex == -1) {
                break;
            }
            
            found += 1;
            currIndex += lena;
        }
    
        return found;
    }
    
    public void test() {
        System.out.println(howMany("AA", "ATAAAA"));
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
    
    }
    
}
