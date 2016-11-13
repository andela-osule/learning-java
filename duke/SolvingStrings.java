public class SolvingStrings {
    public boolean twoOccurrences(String stringa, String stringb) {
        int occ = 0;
        int startIndex;
        while(true) {
            startIndex = stringb.indexOf(stringa);
            if(startIndex == -1) break;
            
            stringb = stringb.substring(startIndex + stringa.length());
            occ += 1;
        }
        return occ >= 2;
    }
    
    public String lastPart(String stringa, String stringb) {
        int startIndex = stringb.indexOf(stringa);
        if(startIndex == -1) return stringb;
        return stringb.substring(startIndex + stringa.length());
    }
    
    public void testing() {
        System.out.println(twoOccurrences("a", "banana"));
        
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        
        System.out.println(lastPart("an", "banana"));
        
        System.out.println(lastPart("zoo", "forest"));
    }
}
