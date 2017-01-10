import java.util.*;

public class LargestQuakes {

    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        int index = indexOfLargest(list);
        double magnitude = list.get(index).getMagnitude();
        
        System.out.println("Quake with largest magnitude("+ magnitude +") is at index "+ index);
        
        ArrayList<QuakeEntry> largest = getLargest(list, 5);
        
        System.out.println("Largest in order of magnitude");
        for(QuakeEntry qe: largest) {
            System.out.println(qe.getInfo() + " ("+ qe.getMagnitude() + ")");
        }
        
    }
    
    
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int location = 0;
        int maxIndex = 0;
        double maxMagnitude = 0.0;
        for(QuakeEntry qe: data) {
            if(qe.getMagnitude() > maxMagnitude) {
                maxMagnitude = qe.getMagnitude();
                maxIndex = location;
            }
            location += 1;
        }
        
        return maxIndex;
    }
        
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        while(howMany > 0) {
            int index = indexOfLargest(copy);
            QuakeEntry qe = copy.get(index);
            ret.add(qe);
            copy.remove(index);
            howMany -= 1;
        }
        
        return ret;
    }
    
    
}
