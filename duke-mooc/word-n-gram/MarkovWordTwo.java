
import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target1, String target2, int start) {
       for(int k=start; k+1<words.length; k++) {
           if(words[k].equals(target1) && words[k+1].equals(target2)) {
               return k;
            }
       }
       return -1;
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int found = indexOf(myText, key1, key2, 0);
        while (found != -1 && found+2 < myText.length ) {
            follows.add(myText[found+2]);
            found = indexOf(myText, key1, key2, found+2);
        }
        
        return follows;
    }
    
    
    public void testIndexOf() {
        String[] words = "this is just a test yes this is a simple test".split(" ");
        System.out.println(indexOf(words, "this", "is", 0));
    }

}
