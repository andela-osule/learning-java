import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String, ArrayList<String>> myMap;

    private ArrayList<String> seenList =  new ArrayList<String>();
    private ArrayList<String> categories = new ArrayList<String>();
    
    private Random myRandom;

    private String dataSourceURL = "http://dukelearntoprogram";
    private String dataSourceDirectory = "data";
    private int numReplacedWords = 0;


    public GladLib(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String[] categories = {
            "adjective", "noun", "color", "country", 
            "name", "animal", "time", "verb", "fruit"};   
        for(String category : categories) {
            if(category.equals("time")) {
                category = "timeframe";
            }
            myMap.put(category, readIt(source + "/" + category + ".txt"));
        }
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if(label.equals("number")){
            return "" + myRandom.nextInt(50)+5;
        }

        if(myMap.containsKey(label)) {
            if(!categories.contains(label)) {
                categories.add(label);
            }
            return randomFrom(myMap.get(label));
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if(first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(seenList.indexOf(sub) != -1) {
            sub = getSubstitute(w.substring(first+1,last));
        }
        seenList.add(sub);
        numReplacedWords += 1;
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public void makeStory(){
	    seenList.clear();
	    numReplacedWords = 0;
	    
	    System.out.println("\n");
		String story = fromTemplate("data/madtemplate2.txt");
		printOut(story, 60);
		System.out.println("\nNumber of replaced words: " + numReplacedWords);
		
		System.out.println("Total words in map: " + totalWordsInMap());
		System.out.println("Total words considered: " + totalWordsConsidered());
	}
	
	public int totalWordsInMap() {
	    int total = 0;
	    
	    for(ArrayList<String> wordsList: myMap.values()) {
	        total += wordsList.size();
	    }
	    return total;
	}
	
	public int totalWordsConsidered() {
	    int total = 0;
	    for(String category : categories) {
	        total += myMap.get(category).size();
	    }
	    return total;
	}
}
