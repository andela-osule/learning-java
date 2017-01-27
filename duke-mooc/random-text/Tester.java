import java.util.ArrayList;
import edu.duke.*;


public class Tester {
    public void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        //markov.setTraining("this is a test yes this is a test.");
        markov.setTraining("this is an attempt");
        ArrayList<String> follows = markov.getFollows("mpt");
        // System.out.println(follows);
        System.out.println(follows.size());
    }
    
    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> follows = markov.getFollows("t");
        
        System.out.println(follows.size());
    
    }
}
