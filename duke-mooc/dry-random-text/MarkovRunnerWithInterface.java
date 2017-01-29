
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            //printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 0;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);

    }

    public void testHashMap() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        //String st = "yes-this-is-a-thin-pretty-pink-thistle";
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 615;
        EfficientMarkovModel mTwo = new EfficientMarkovModel(5);
        runModel(mTwo, st, size, seed);
    }
    
    public void compareMethods() {
        FileResource fr = new FileResource("data/hawthorne.txt");
		String st = fr.asString();
		//String st = "yes-this-is-a-thin-pretty-pink-thistle";
		st = st.replace('\n', ' ');
		int size = 1000;
		int seed = 42;
		MarkovModel cMTwo = new MarkovModel(2);
		EfficientMarkovModel tMTwo = new EfficientMarkovModel(2);
		
		for(int i=0; i<3; i++) {
		    long t0 = System.nanoTime();
		    runModel(cMTwo, st, size, seed);
		    long t1 = System.nanoTime();
		    System.out.println("Running time for MarkovModel: " + (t1-t0));
		    
		    t0 = System.nanoTime();
		    runModel(tMTwo, st, size, seed);
		    t1 = System.nanoTime();
		    System.out.println("Running time for EfficientMarkovModel: " + (t1-t0));
		}
    
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
