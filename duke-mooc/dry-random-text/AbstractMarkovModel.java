
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s;
    }
 
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    abstract public String getRandomText(int numChars);

    
    protected ArrayList<String> getFollows(String key) {
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
