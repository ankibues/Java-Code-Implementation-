import edu.duke.*;
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
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
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
    
    public StorageResource getAllGenes(String dna)
    {
    
    StorageResource geneList= new StorageResource();
    int startIndex=0;
    
    
    while(true){
        
    String currentGene = findGene(dna, startIndex);
    
    if(currentGene.isEmpty()){
    break;
    }
    geneList.add(currentGene);
    //System.out.println(currentGene);
    startIndex= dna.indexOf(currentGene,startIndex)+ currentGene.length();
    
    }
    return geneList;
    }
    
    public float cgRatio(String dna){
    
    int Cs= howmany("C",dna);
    int Gs= howmany("G",dna);
    return (float)(Cs+Gs)/dna.length();
    
    }
    
    
    public int countCTG(String dna)
    {
        
        String stringa= "CTG";
        return howmany(stringa,dna);   
    }
    
    public int howmany(String stringa, String stringb)
    {
        int count = 0;
        int ind = 0;
        // put your code here
        while(stringb.indexOf(stringa,ind)!= -1)
        {
          int startI = stringb.indexOf(stringa,ind);
        if(startI> 0)
        {
            count = count +1;
        }
        ind = startI + stringa.length();
        }
        return count;
    }
    
    public void processGenes(StorageResource sr){
        int count=0;
        int count9= 0;
        int countCG= 0;
        int len=0;
        StorageResource strList9= new StorageResource();
        StorageResource strListCG= new StorageResource();
        
        for (String g: sr.data()){
        
        // g is the string in sr    
            if(g.length()>60)
            {
                // store the string
                count9=count9+1;
                strList9.add(g);
            }
            if(cgRatio(g)>0.35)
            {
                // store  the string
                countCG= countCG+1;
                strListCG.add(g);
            }
            if(g.length()>len)
            {
                len = g.length();
            }
            count=count+1;
        }
        
        System.out.println("The number of GENES that are longer than 60  are "+ count9 + " and here they are: "  );
        for (String gg: strList9.data()){
           System.out.println(gg);
         }    
               
        System.out.println("Number of strings with CG ratio higher than .35 are "+ countCG + " and here they are:");
        for (String ggg: strListCG.data()){
           System.out.println(ggg);
         }
        
        System.out.println("The length of longest gene is "+ len);
        
        System.out.println("Total number of genes are "+ count);
    
        }
    
    
    
    
    public void testOn(String dna) {
    System.out.println ("Testing getAll Genes on "+ dna);
    StorageResource genes= getAllGenes(dna);
    System.out.println(genes.size());
    for (String g: genes.data()){
        System.out.println(g);
    }
    }
    
    public void printsr(StorageResource genes)
    {
       for (String g: genes.data()){
           System.out.println(g);
         }
    
    }
    public void test(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
                //String dna2= "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println(howmany("CTG", dna));
                
        
        //testOn(dna2);
    
    }
    
    public void testProcessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString(); 
        StorageResource stored = new StorageResource();
        stored= getAllGenes(dna.toUpperCase());
        processGenes(stored);
        
    
    
    }
    public void tests(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString(); 
        System.out.println(dna.toUpperCase());
    }
    
    }

