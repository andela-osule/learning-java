import edu.duke.*;
import java.util.*;

public class CodonCount {

    HashMap<String, Integer> map;
    
    public CodonCount() {
        map = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna) {
        map.clear();
        for(int j=start, k=j+3; j<dna.length() && k < dna.length(); j+=3, k+=3) {
            String key = dna.substring(j, k);
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        for(String w : map.keySet()) {
            System.out.println(w + ": " + map.get(w));
        }
    }
   
    
    public String getMostCommonCodon() {
        String codon = "";
        int highestCount = 0;
        for(String w : map.keySet()) {
            if(map.get(w) > highestCount) {
                highestCount = map.get(w);
                codon = w;
            }
        }
        return codon;
    }
    
    public void printCodonCounts(int start, int end) {
        for(String w : map.keySet()) {
            int count = map.get(w);
            if(count <= start || count <= end) {
                System.out.println(w + ": " + count);
            }
        } 
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString().trim().toUpperCase();
        
        System.out.println(dna);
        for(int frame=0; frame<3; frame++) {
            buildCodonMap(frame, dna);
            String common = getMostCommonCodon();
            System.out.println("Most common codon is: " + common + " with " + map.get(common));
            printCodonCounts(1, 5);
        }
    
    }
}
