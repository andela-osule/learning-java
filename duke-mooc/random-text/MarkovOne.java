import java.util.Random;
import java.util.ArrayList;

public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length());
        String key = myText.substring(index, index+1);
        sb.append(key);
        
        for(int k=1; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            key = follows.get(index);
           
            sb.append(key);
        }
        
        return sb.toString();
    }
    
    
    public ArrayList<String> getFollows(String key) {
       int pos = 0;
       int index = myText.indexOf(key);
       ArrayList<String> result = new ArrayList<String>();
       while (index != -1) {
           pos = index+key.length();
           
           if(pos+1 > myText.length()) break;
           result.add(myText.substring(pos, pos+1));
           index = myText.indexOf(key, pos);
       }
       return result;
    }
}
