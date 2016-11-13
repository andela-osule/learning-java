public class GeneRatio {
    
    public int occurrence(String comp, String dna) {
        int count = 0;
        int index = 0;
        
        while(true) {
            index = dna.indexOf(comp, index);
            if(index == -1) break;
            
            count += 1;
            index += 1;
        }
        
        return count;
    }
    
    public void cgRatio(String dna) {
        int cg = occurrence("C", dna) + occurrence("G", dna);
        System.out.println((float)cg / dna.length());
    }
    
    
    public int countCTG(String dna) {
        String codon = "CTG";
        int count = 0; 
        int index = 0;
        while(true){
            index = dna.indexOf(codon, 0);
            if(index == -1) break;
            
            count += 1;
            
            index += 3;
        }
        
        return count;
    }
    
    public void test(){
        cgRatio("ATGCCATAG");
    }
}
