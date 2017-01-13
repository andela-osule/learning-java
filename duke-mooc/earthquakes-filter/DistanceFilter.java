
public class DistanceFilter implements Filter {
    
    private Location location;
    private double maxDist;
    
    public DistanceFilter(Location loc, double max){
        location = loc;
        maxDist = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        if(qe.getLocation().distanceTo(location) < maxDist){
            return true;
        }
        return false;
    }
    
    public String getName() {
        return this.getClass().getName();
    }

}
