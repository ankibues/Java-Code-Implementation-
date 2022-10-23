
/**
 * Write a description of class Part6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part6
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part6
     */
    public Part6()
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
    
    public void printAllGenes(String dna)
    {
    
    int startIndex=0;
    
    while(true){
        
    String currentGene = findGene(dna, startIndex);
    
    if(currentGene.isEmpty()){
    break;
    }
    System.out.println(currentGene);
    startIndex= dna.indexOf(currentGene,startIndex)+ currentGene.length();
    
    }
    }
    
    public void CountGenes(String dna)
    {
    
    int startIndex=0;
    int count=0;
    
    while(true){
        
    String currentGene= findGene(dna, startIndex);
    
    if(currentGene.isEmpty()){
    break;
    }
    count = count+1;
    startIndex= dna.indexOf(currentGene,startIndex)+ currentGene.length();
    
    }
    System.out.println("The total genes are"+ count);
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
     
    public String mystery(String dna) {
      int pos = dna.indexOf("T");
      int count = 0;
      int startPos = 0;
      String newDna = "";
      if (pos == -1) {
        return dna;
      }
      while (count < 3) {
        count += 1;
        newDna = newDna + dna.substring(startPos,pos);
        startPos = pos+1;
        pos = dna.indexOf("T", startPos);
        if (pos == -1) {
          break;
        }
      }
      newDna = newDna + dna.substring(startPos);
      return newDna;
    } 
}
