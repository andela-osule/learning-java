package VigenereProgram;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    int[] rightKeys = {};
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        
        for(int j=whichSlice; j<message.length(); j+=totalSlices) {
            sb.append(message.charAt(j));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        
        int[] key = new int[klength];

        for(int j=0; j<klength; j+=1) {
            CaesarCracker cc = new CaesarCracker(mostCommon);
            String encryptedSlice = sliceString(encrypted, j, klength);
            key[j] = cc.getKey(encryptedSlice);
        }
        
        return key;
    }

    public void breakVigenere() {
        FileResource encryptedFile = new FileResource();
        String encryptedMessage = encryptedFile.asString();
        HashMap<String, HashSet<String>> languageMap = new HashMap<String, HashSet<String>>();
        String[] languages = {"Danish", "English", "German", "Portuguese", "Dutch", "French", "Italian", "Spanish"};
        
        for(String language: languages) {
            FileResource dictFile = new FileResource("./VigenereProgram/dictionaries/"+language);
            languageMap.put(language, readDictionary(dictFile));
            System.out.println("Loaded "+language+" dictionary");
        }
        
        
        breakForAllLangs(encryptedMessage, languageMap);
    }
    
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dict = new HashSet<String>();
        
        for(String word: fr.words()) {
            dict.add(word.toLowerCase());
        }
        
        return dict;
    }
    
    public int countWords(String message, HashSet<String> dict) {
        String[] words = message.split("\\W+");
        int count = 0;
        
        for(String word: words) {
            if(dict.contains(word.toLowerCase())) {
                count+=1;
            }
        }
        
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dict) {
        int count = 0;
        String decrypted = "";
        char mostCommonChar = mostCommonCharIn(dict);
        
        
        for(int keyLen=1; keyLen<=100; keyLen+=1) {
            int[] keys = tryKeyLength(encrypted, keyLen, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(keys);
            String message = vc.decrypt(encrypted);
            int validWords = countWords(message, dict);
            
            if(validWords > count) {
                count = validWords;
                rightKeys = keys;
                decrypted = message;
            }

        }

        return decrypted;
    }
    
    public char mostCommonCharIn(HashSet<String> dict) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        String mostCommon = "";
        int bestCount = 0;
        
        for(String word: dict) {
            for(int i = 0; i < word.length(); i++)
            {
               String letter = String.valueOf(word.charAt(i));
               if(hmap.containsKey(letter)) {
                    hmap.put(letter, hmap.get(letter) + 1);
                }
                else {
                    hmap.put(letter, 1);
                }
            }      
        }
        
        for(String letter: hmap.keySet()) {
            int count = hmap.get(letter);
            if(count > bestCount) {
                bestCount = count;
                mostCommon = letter;
            }
        }
        return mostCommon.charAt(0);
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        int bestValidWords = 0;
        String message = "";
        String bestLanguage = "";
        int [] bestKeys = {};
        for(String language: languages.keySet()) {
            HashSet<String> dict = languages.get(language);
            String decrypted = breakForLanguage(encrypted, dict);
            int validWords = countWords(decrypted, dict);
            
            if(validWords > bestValidWords) {
                bestValidWords = validWords;
                bestLanguage = language;
                bestKeys = rightKeys;
                message = decrypted;
            }
        }
        
        System.out.println("Message is: \n" + message);
        System.out.println("Key is: "+ Arrays.toString(bestKeys));
        System.out.println("Language is: "+bestLanguage);
        System.out.println("Count of valid words is: "+ bestValidWords);
    }

}
