
/**
 * Write a description of CommonLetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommonLetters {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public int[] countFrequency(String sentence){
        int[] counts = new int[26];
        
        for(int k=0; k < sentence.length(); k++){
            int index = alphabet.indexOf(sentence.charAt(k));
            if(index != -1) {
                counts[index] += 1;
            } 
        }
        return counts;
    }
    
    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for(int k=0; k < vals.length; k++) {
            if(vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public void testCountFrequency() {
        int[] counts = countFrequency("Hi, do you want a lollipop today? I own many good flavors, but banana is outstanding.");
        
        for(int k=0; k < 26; k++) {
            System.out.println(alphabet.charAt(k) + "\t" + counts[k]);
        }
        
    }
}
