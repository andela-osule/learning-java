import java.util.Random;
import java.util.ArrayList;

public class MarkovOne extends AbstractMarkovModel {
    
    public MarkovOne() {
        myRandom = new Random();
    }

    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1); // last character is invalid because it has no following character
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

    public String toString() {
        return "MarkovModel of order 1";
    }
}
