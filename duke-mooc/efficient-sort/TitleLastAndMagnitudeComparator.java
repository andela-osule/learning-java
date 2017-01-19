import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String[] wordArr1 = q1.getInfo().trim().split(" ");
        String[] wordArr2= q2.getInfo().trim().split(" ");
        String lastWord1 = wordArr1[wordArr1.length - 1];
        String lastWord2 = wordArr2[wordArr2.length - 1];
        
        int comparison = lastWord1.compareTo(lastWord2);
        
        if(comparison == 0 ) {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return comparison;
    }
}
