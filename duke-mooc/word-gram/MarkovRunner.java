
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markovWord = new MarkovWord(5); 
        runModel(markovWord, st, 200, 844); 
    } 

    public void testHashMap() { 
        FileResource fr = new FileResource("data/confucius.txt");
        //String st = "this is a test yes this is really a test";
        //String st = "this is a test yes this is really a test yes a test this is wow";
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        EfficientMarkovWord markovWord = new EfficientMarkovWord(2); 
        runModel(markovWord, st, 50, 65); 
    } 
    
    
    public void compareMethods() {
        long start;
        long stop;
        FileResource fr = new FileResource("data/hawthorne.txt");
        //String st = "this is a test yes this is really a test";
        //String st = "this is a test yes this is really a test yes a test this is wow";
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 

        start = System.nanoTime();
        MarkovWord markovWord = new MarkovWord(2);
        runModel(markovWord, st, 50, 42);
        stop = System.nanoTime();
        System.out.println("Time running MarkovWord: " + (stop-start));
        
        start = System.nanoTime();
        EfficientMarkovWord effMarkovWord = new EfficientMarkovWord(2);
        runModel(effMarkovWord, st, 50, 42); 
        stop = System.nanoTime();
        System.out.println("Time running EfficientMarkovWord: " + (stop-start));
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
