
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part2
     */
    public Part2()
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
    public String findSimpleGene(String dna,String startCodon, String stopCodon )
    {
        // put your code here
        int start = dna.indexOf(startCodon);
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf(stopCodon, start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
     }
     
     public void testSimpleGene()
    {
       String a1 = "cccatggtagggtaaataataataggagagagagagagagttt";
       String a2 = "atggggtttaaataataatag";
       String a3 = "atgcccgggtaa";
       String a4 = "ATGCCCTAGTAA";
       String a5 = "ATCCCCTAG";
       
       System.out.println("The DNA string is " + a1);
       System.out.println("The gene in this DNA is " + findSimpleGene(a1, "atg", "taa")); 
        
       System.out.println("The DNA string is " + a2);
       System.out.println("The gene in this DNA is " + findSimpleGene(a2, "atg", "taa")); 
       
       System.out.println("The DNA string is " + a3);
       System.out.println("The gene in this DNA is " + findSimpleGene(a3, "atg", "taa")); 
       
       System.out.println("The DNA string is " + a4);
       System.out.println("The gene in this DNA is " + findSimpleGene(a4, "atg", "taa")); 
       
       System.out.println("The DNA string is " + a5);
       System.out.println("The gene in this DNA is " + findSimpleGene(a5,"atg", "taa")); 
    
       
    }
}
