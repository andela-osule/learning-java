import edu.duke.*;


public class WordLengths {
    public int countLetters(String word) {
        int count = 0;
        for(int k=0; k < word.length(); k++) {
            if(Character.isLetter(word.charAt(k))) {
                count += 1;
            }
        }
        return count;
    }
    
    public int indexOfMax(int[] values) {
        int maxDex = 0;
        for(int k=0; k < values.length; k++) {
            if(values[k] > values[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public void countWordLengths(FileResource resource, int[] counts) {
        for(String s : resource.words()) {
            int len = countLetters(s);
            if(len >= 30) {
                counts[30] += 1;
            
            } else {
                counts[len] += 1;
            }
        }
    }
    
    
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        
        for(int k=0; k < counts.length; k++) {
            if(counts[k] != 0)
                System.out.println(counts[k] + " words of length "+ k );
        }
        
        System.out.println("the most common word length in the file is " + indexOfMax(counts));
    }
}
