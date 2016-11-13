import edu.duke.*;

public class FindWebLinks {
    URLResource rs = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    
    public void youtubeLinks(){
       int startIndex, stopIndex, pos;
       
       for(String s: rs.words()) {
           pos = s.toLowerCase().indexOf("youtube.com");
           if( pos != -1){
                
                startIndex = s.lastIndexOf("\"", pos);
                stopIndex = s.indexOf("\"", pos + 1);
                if(startIndex != -1) {
                    System.out.println(s.substring(startIndex+1, stopIndex));
                }
           }
       }
    }
}
