import java.util.*;

public class LogEntry {
    private String IPAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    
    public LogEntry(String IP, Date time, String req, int status, int bytes) {
        IPAddress = IP;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }
    
    public String getIPAddress() {
        return IPAddress;
    }
    
    public Date getAccessTime() {
        return accessTime;
    }
    
    public String getRequest() {
        return request;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public int getBytesReturned() {
        return bytesReturned;
    }
    
    public String toString() {
        return IPAddress + " " + accessTime + " " + request + " " + statusCode + " " + bytesReturned; 
    }
}