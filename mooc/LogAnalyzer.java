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

    public void printAllHigherThanNum(int num) {
        for(LogEntry le: records) {
            int statusCode = le.getStatusCode();
            
            if(statusCode > num) {
                System.out.println(le);
            }
             
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPVisits = new ArrayList<String>();
        
        for(LogEntry le: records) {
            Date accessTime = le.getAccessTime();
            String accessDay = accessTime.toString();

            String IPAddress = le.getIPAddress();
            
            if(accessDay.indexOf(someday) != -1 && !uniqueIPVisits.contains(IPAddress)) {
                uniqueIPVisits.add(IPAddress);
            }
        }
        
        return uniqueIPVisits;
    }
    
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String>  uniqueIPs = new ArrayList<String>();
        for(LogEntry le: records) {
            int statusCode = le.getStatusCode();
            String IPAddress = le.getIPAddress();
            
            if(statusCode >= low  && statusCode <= high && !uniqueIPs.contains(IPAddress)) {
                uniqueIPs.add(IPAddress);
            }           
        }
        return uniqueIPs.size();
    }
    
    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        
        for(LogEntry le: records) {
            String IP = le.getIPAddress();
            
            if(counts.containsKey(IP)) {
                counts.put(IP, counts.get(IP) + 1);
            } else {
                counts.put(IP, 1);
            }
        
        }
        
        return counts;
    }
}
