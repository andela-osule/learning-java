import edu.duke.*;

public class CommonWords {
    public void countShakespeare() {
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        
        String[] common = getCommon();
        
        int[] counts = new int[common.length];
        
        for(int k=0; k < plays.length; k++) {
            FileResource fr = new FileResource("data/" + plays[k]);
            countWords(fr, common, counts);
            System.out.println("done with " + plays[k]);
        }
        
        for(int k=0; k < common.length; k++) {
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
    
    public int indexOf(String[] list, String word) {
        int index = 0;
        for(String find : list) {
            if(find.equals(word)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }
    
    public void countWords(FileResource fr, String[] common, int[] counts) {
        for(String word : fr.words()) {
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if(index != -1) {
                counts[index] += 1;
            }
        }
        
    }
    
    public String[] getCommon() {
        FileResource fr = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String s : fr.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
}
