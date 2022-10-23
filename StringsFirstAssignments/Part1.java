
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part1
     */
    public Part1()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String findSimpleGene(String dna)
    {
        // put your code here
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start+3);
        while (stop != -1)
        {
            if ((stop - start) % 3 == 0) {
                return dna.substring(start, stop+3);
                }
            else {
                stop = dna.indexOf("TAA", stop+1);
                 }   
        }
        return "";
     }
    public int findStopCodon(String dna, int start, String codon)
    {
        int stop = dna.indexOf(codon, start+3);
        while (stop != -1)
        {
            if ((stop - start) % 3 == 0) {
                return stop;
                }
            else {
                stop = dna.indexOf(codon, stop+1);
                 }   
        }
        return dna.length();
     }
     
     public String findSimpleGene2(String dna)
    {
        // put your code here
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int taaIndex= findStopCodon(dna, start,"TAA");
        int tagIndex= findStopCodon(dna, start,"TAG");
        int tgaIndex= findStopCodon(dna, start,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if (minIndex== dna.length()){
        return "";
        }
        return dna.substring(start,minIndex +3);
    }
    
    public String findGene(String dna, int where)
    {
        // put your code here
        int start = dna.indexOf("ATG", where);
        if (start == -1) {
            return "";
        }
        int taaIndex= findStopCodon(dna, start,"TAA");
        int tagIndex= findStopCodon(dna, start,"TAG");
        int tgaIndex= findStopCodon(dna, start,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if (minIndex== dna.length()){
        return "";
        }
        return dna.substring(start,minIndex +3);
    }
     
    public void printAllGenes(String dna){
    
    int startIndex=0;
    
    while(true){
        
    String currentGene= findGene(dna, startIndex);
    
    if(currentGene.isEmpty()){
    break;
    }
    System.out.println(currentGene);
    startIndex= dna.indexOf(currentGene,startIndex)+ currentGene.length();
    
    }
    
    
    
    
    }
    
    public void testSimpleGene()
    {
       String a1 = "cccatggtagggtaaataataataggagagagagagagagttt";
       String a2 = "atggggtttaaataataatag";
       String a3 = "ATGCCCGGGTAA";
       String a4 = "ATGCCCTAA";
       String a5 = "AATGCGTAATTAATCG";
       
       System.out.println("The DNA string is " + a1);
       System.out.println("The gene in this DNA is " + findSimpleGene(a1)); 
        
       System.out.println("The DNA string is " + a2);
       System.out.println("The gene in this DNA is " + findSimpleGene(a2)); 
       
       System.out.println("The DNA string is " + a3);
       System.out.println("The gene in this DNA is " + findSimpleGene(a3)); 
       
       System.out.println("The DNA string is " + a4);
       System.out.println("The gene in this DNA is " + findSimpleGene(a4)); 
       
       System.out.println("The DNA string is " + a5);
       System.out.println("The gene in this DNA is " + findSimpleGene(a5)); 
    
       
    }
}
