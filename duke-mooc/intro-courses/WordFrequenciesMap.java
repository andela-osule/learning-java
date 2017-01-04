import edu.duke.*;
import java.util.*;

public class WordFrequenciesMap {
    public void countWords() {
       FileResource fr = new FileResource();
       HashMap<String, Integer> map = new HashMap<String, Integer>();
       
       for(String w: fr.words()) {
           w = w.toLowerCase();
           if(map.keySet().contains(w)) {
               map.put(w, map.get(w) + 1);
           } 
           else {
               map.put(w, 1);
           }
       }
       
       for(String w: map.keySet()) {
          int freq = map.get(w);
          if(freq > 500) {
            System.out.println(freq + "\t" + w);
          }
       }
    }
}
