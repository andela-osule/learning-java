import edu.duke.StorageResource;
import edu.duke.FileResource;

public class AllGenesStored {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            
            if(diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        
        return -1;
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1)
            return "";
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = 0;
        
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }else {
            minIndex = taaIndex;
        }
        
        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        
        if (minIndex == -1) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }

    
    public StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        
        while(true) {
            String currentGene = findGene(dna, startIndex);
            
            if(currentGene.isEmpty()) break;
            
            geneList.add(currentGene);
            
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return geneList;
    }
    
    public StorageResource longerThan(int num, StorageResource sr) {
        StorageResource li = new StorageResource();
        
        for(String g: sr.data()){
            if(g.length() > num)
                li.add(g);
        }
        
        return li;
    }
    
    public void printSr(StorageResource sr) {
        for(String g: sr.data()){
            System.out.println(g);
        }
    }
    
    public void lengthOfLongestGene(StorageResource sr) {
        int len = 0;
        
        for(String g: sr.data()){
            if(g.length() > len)
                len = g.length();
        }
        
        System.out.println(len);
    }
    
   
    public void numOfSr(StorageResource sr) {
        int count = 0;
        
        for (String s: sr.data()){
            count++;
        }
        
        System.out.println(count);
    }
    
        
    public int occurrence(String comp, String dna) {
        int count = 0;
        int index = 0;
        int len = comp.length();
        
        while(true) {
            index = dna.indexOf(comp, index);
            if(index == -1) break;
            
            count += 1;
            index += len;
        }
        
        return count;
    }

    
    public StorageResource validCGRatio(StorageResource sr) {
        StorageResource ratios = new StorageResource();
        int cg;
        
        for(String g: sr.data()) {
            cg = occurrence("C", g) + occurrence("G", g);
            if((float)cg / g.length() > 0.35) {
                ratios.add(g);
            }
                
        }
        
        return ratios;
    } 
    
    public void processGenes(StorageResource sr) {
       //printSr(longerThan(9, sr));
       //printSr(longerThan(60, sr));
       //numOfSr(longerThan(9, sr));
       //numOfSr(longerThan(60, sr));
       //printSr(validCGRatio(sr));
       numOfSr(sr);
       //numOfSr(validCGRatio(sr));
       
       //lengthOfLongestGene(sr);
    }
    
    public void testProcessGenes() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        
        StorageResource genes = getAllGenes(dna.toUpperCase());
        
        //System.out.println(occurrence("CTG", dna.toUpperCase()));
        processGenes(genes);
        
    }

}
