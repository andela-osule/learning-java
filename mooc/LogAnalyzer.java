import edu.duke.*;
import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    
    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }
    
    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for(String line : fr.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
        
    }
    
    public void printAll() {
        for(LogEntry le:records) {
            System.out.println(le);
        }
    }
    
    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        
        for(LogEntry le: records) {
            String IPAddress = le.getIPAddress();
            
            if(!uniqueIPs.contains(IPAddress)) {
                uniqueIPs.add(IPAddress);
            }
             
        }
    
        return uniqueIPs.size();
    }
}
