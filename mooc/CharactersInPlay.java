import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay() {
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        int index = characters.indexOf(person);
        if(index != -1) {
            int val = counts.get(index);
            counts.set(index, val+1);
        }
        else {
            characters.add(person);
            counts.add(1);
        }
    }
    
    public void findAllCharacters() {
        characters.clear();
        counts.clear();
        FileResource resource = new FileResource();
        
        for(String line : resource.lines()) {
            int indexOfPeriod = line.indexOf(".");
            if(indexOfPeriod != -1) {
                update(line.substring(0, indexOfPeriod));
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        for(int k=0; k < characters.size(); k++) {
            int freq = counts.get(k);
            
            if(freq >= num1 && freq <= num2)
                System.out.println(characters.get(k) + " "+ counts.get(k));
        }
    }
    
    public void mostSpeakingPart() {
        int maxIndex = 0;
        for(int k=0; k < characters.size(); k++) {
            if(counts.get(k) > counts.get(maxIndex)) {
                maxIndex = k;
            }
        }
        System.out.println("Most speaking part is: "+characters.get(maxIndex) + " " + counts.get(maxIndex));
    }
    
    public void tester(){
        findAllCharacters();
        charactersWithNumParts(10, 15);
        mostSpeakingPart();
    }
}
