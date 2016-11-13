public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna, String startCodon, String stopCodon){
        //Start codon is "ATG"
        //Stop codon is "TAA"
        String result = "";
        String upCaseDna = dna.toUpperCase();
        int startIndex = upCaseDna.indexOf(startCodon);
        if(startIndex == -1) return result; // no ATG
        
        int stopIndex = upCaseDna.indexOf(stopCodon, startIndex + 3);
        
        if(stopIndex == -1) return result; // no TAA
        
        String gene = upCaseDna.substring(startIndex, stopIndex + 3);
        if(gene.length() % 3 == 0) {
            if(upCaseDna.equals(dna))
                result = gene;
            else
                result = gene.toLowerCase();
        }
        
        return result;
    }
    
    public void testFindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "CGATGGTTTG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
    }
}
