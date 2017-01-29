import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int linkLength;
    private HashMap<String, ArrayList<String>> followsHashMap;
    
    public EfficientMarkovModel(int n) {
        super();
        linkLength = n;
        followsHashMap = new HashMap<String, ArrayList<String>>();
    }
    
    public void setTraining(String s){
        super.setTraining(s);
        followsHashMap.clear();
        buildMap();
        //System.out.println("Built hash map successfully.");
        printHashMapInfo();
    }
    
    public ArrayList<String> getFollow(String key) {
        return followsHashMap.get(key);
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-linkLength);
        String key = myText.substring(index, index+linkLength);
        sb.append(key);
        
        for(int k=linkLength; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }

    public void buildMap() {
        for(int i=0; i < myText.length()-linkLength; i++) {
            // determine key
            int start = i + linkLength;
            String key = myText.substring(i, start);
            String letter = myText.substring(start, start+1);
       
            
            if(followsHashMap.containsKey(key)) {
                followsHashMap.get(key).add(letter);
            } else {
                ArrayList<String> list = new ArrayList<String>();
				list.add(letter);
				followsHashMap.put(key, list);
            }
           
        }
    }
    
    public String toString() {
        return "EfficientMarkovModel of order " + linkLength;
    }
    
    public void printHashMapInfo() {
        //System.out.println(followsHashMap);
        System.out.println("Number of keys in HashMap: " + followsHashMap.size());
        int maxSize = 0;
        for(String key: followsHashMap.keySet()) {
            int size = followsHashMap.get(key).size();
            if(size > maxSize) {
                maxSize = size;
            }
        }
        System.out.println("Size of the largest value in the HashMap: " + maxSize);
        
        System.out.println("Keys that have the maximum size value");
        for(String key: followsHashMap.keySet()) {
            int size = followsHashMap.get(key).size();
            if(size == maxSize) {
                System.out.println(key);
            }
        }
    }
}
