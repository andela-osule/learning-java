import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, ArrayList<String>> myHashMap;
    
    public EfficientMarkovWord(int order) {
        myOrder = order;
        myRandom = new Random();
        myHashMap = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
        printHashMapInfo();
    }
    
    private int indexOf(String[] words, WordGram target, int start) {
       for(int k=start; k<words.length - target.length(); k++) {
           WordGram wg = new WordGram(words, k, target.length());
           if(wg.equals(target)) {
               return k;
            }
       }
       return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = myHashMap.get(kGram);
        if(follows == null) {
            return new ArrayList<String>();
        }
		return follows;
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, myOrder);
        sb.append(kGram);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(kGram);
            
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }
        
        return sb.toString().trim();
    }
    
    private void buildMap() {
        for(int k=0; k+myOrder<=myText.length; k++) {
            WordGram kGram = new WordGram(myText, k, myOrder);
            ArrayList<String> follows = new ArrayList<String>();
    		int index = indexOf(myText,kGram, 0);
    		
    		if(myHashMap.containsKey(kGram)) continue;
    		
    		while(index != -1 && index + myOrder < myText.length){
    			String follow = myText[index+myOrder];
    			follows.add(follow);
    			index = indexOf(myText,kGram, index + myOrder);
    		}

    		myHashMap.put(kGram, follows);
        }
    }
    
    
    public int largestValueInHashMap() {
        int maxSize = 0;
        for(WordGram wg: myHashMap.keySet()) {
            int currSize = myHashMap.get(wg).size();
            if(currSize > maxSize) {
                maxSize = currSize;
            }
        }
        return maxSize;
    }
    
    public ArrayList<WordGram> keysWithLargestValue() {
        int maxSize = largestValueInHashMap();
        ArrayList<WordGram> result = new ArrayList<WordGram>();
        
        for(WordGram wg: myHashMap.keySet()) {
            int currSize = myHashMap.get(wg).size();
            if(currSize == maxSize) {
                result.add(wg);
            }
        }
        
        return result;
    }
    
	public void printHashMapInfo(){
		System.out.println("Size: " + myHashMap.size());
		System.out.println("Largest value: " + largestValueInHashMap());
		System.out.println("Keys with largest value: " + keysWithLargestValue());
		//System.out.println(myHashMap);
	}
        
}
