import edu.duke.*;
import java.util.*;
import java.io.File;

public class WordsInFiles {
  private HashMap<String, ArrayList<String>> fileMap;
  
  public WordsInFiles() {
      fileMap = new HashMap<String, ArrayList<String>>();
  }
  
  public void addWordsFromFile(File f) {
      FileResource fr = new FileResource(f);
      String filename = f.getName();
      
      for(String w: fr.words()) {
        if(fileMap.containsKey(w)) {
            ArrayList<String> list = fileMap.get(w);
            if(!list.contains(filename)) {
              list.add(filename);
            }
        } else {
           ArrayList<String> list = new ArrayList<String>();
           list.add(filename);
           fileMap.put(w, list);
        
        }
      }
  }
  
  public void buildWordFileMap() {
      fileMap.clear();
      DirectoryResource dr = new DirectoryResource();
      for(File f: dr.selectedFiles()) {
          addWordsFromFile(f);  
      }
  }
  
  public int maxNumber() {
      int maxAppearance = 0;
      for(ArrayList<String> files : fileMap.values()) {
          if(files.size() > maxAppearance) {
              maxAppearance = files.size();
          }
      }
      return maxAppearance;
  }
  
  public ArrayList<String> wordsInNumFiles(int number) {
     ArrayList<String> words = new ArrayList<String>();
     for(String word: fileMap.keySet()) {
        if(fileMap.get(word).size() == number) {
            words.add(word);
        }
     }
     return words;
  }
  
  public void printFilesIn(String word) {
     for(String filename: fileMap.get(word)) {
         System.out.println(filename);
     }
  }
  
  
  public void tester() {
      buildWordFileMap();
      
     for(String word: fileMap.keySet()) {
         System.out.println(word + ": " + fileMap.get(word).size());
     }
     
     int maxFiles = maxNumber();
     ArrayList<String> wordsInMaxFiles = wordsInNumFiles(maxFiles);
     
     System.out.println("Words appear in maximum files of: " + maxFiles);
     for(String word: wordsInMaxFiles) {
         StringJoiner sj = new StringJoiner(", ");
         for(String filename : fileMap.get(word)) {
             sj.add(filename);
         }
         System.out.println(word + " appears in : " + sj.toString());
     }
  }
}
