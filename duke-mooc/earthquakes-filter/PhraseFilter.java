import java.util.regex.Pattern;

public class PhraseFilter implements Filter {
    private String requestType;
    private String phrase;
    
    public PhraseFilter(String reqType, String wordPhrase) {
        requestType = reqType;
        phrase = wordPhrase;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        String info = qe.getInfo();
        if(requestType.equals("start") && Pattern.matches("^"+phrase+".*", info)){
            return true;
        }
        if(requestType.equals("end") && Pattern.matches(".*"+phrase+"$", info)){
            return true;
        }
        if(requestType.equals("any") && Pattern.matches(".*"+phrase+".*", info)){
            return true;
        }
        return false;
    }
    
    
    public String getName() {
        return this.getClass().getName();
    }

}
