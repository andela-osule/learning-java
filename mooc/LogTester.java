import java .util.*;

public class LogTester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/short-test.log");
        la.printAll();
    }

    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();

        la.readFile("data/short-test.log");
        la.countUniqueIPs();
    }

    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();

        la.readFile("data/weblog1_log.txt");
        la.printAllHigherThanNum(400);
    }
    
    public void  testUniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog1_log.txt");
        ArrayList<String> uniqueIPVisits = la.uniqueIPVisitsOnDay("Mar 17");
        System.out.println("Unique IP Visits: " + uniqueIPVisits.size());
        
        for(String uniqueIP: uniqueIPVisits) {
            System.out.println(uniqueIP);
        }
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog1_log.txt");
        int count = la.countUniqueIPsInRange(200, 299);
        System.out.println("UniqueIPs in range: " + count);
    }
    
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/short-test_log.txt");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        
        System.out.println(counts);
        
        
    }
}