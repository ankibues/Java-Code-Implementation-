import edu.duke.*;
import java.util.*;
/**
 * Write a description of class CodonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodonCount
{
    // instance variables - replace the example below with your own
    private HashMap<String,Integer> dnaCodons; 

    /**
     * Constructor for objects of class CodonCount
     */
    public CodonCount()
    {
        // initialise instance variables
        dnaCodons = new HashMap<String,Integer>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void buildCodonMap(int start, String dna)
    {
        // put your code here
        String codon =null;
        for(int i= start; i<dna.length();i=i+3){
            dna= dna.toLowerCase();
            if (i+3>dna.length()){
            break;
            }
            if (i+3== dna.length())
            { 
             codon = dna.substring(i);
            }
            else{
              codon = dna.substring(i,i+3);
            }
            if(!dnaCodons.containsKey(codon)){
                dnaCodons.put(codon, 1);
            }
            else{
                dnaCodons.put(codon,dnaCodons.get(codon)+1);
            }
        
        }
    }
    
    public String getMostCommonCodon(){
        // this method assume hashmap is already built
        String largest= null;
        int count=0;
        for(String s:dnaCodons.keySet()){
            if(dnaCodons.get(s)> count){
            count =dnaCodons.get(s);
            largest = s;
            }
        }
        return largest; 
        }
        
    public void printCodonCounts(int start, int end){
        for(String s:dnaCodons.keySet()){
            if(dnaCodons.get(s) >= start && dnaCodons.get(s)<= end ){
            System.out.println(s + " occur " + dnaCodons.get(s)+ "  times");
            }
    
    
    }
    }
    
    public void tester(){
        FileResource resource = new FileResource();
        for(String line : resource.lines()){
         line= line.toLowerCase();
         line = line.trim();
         buildCodonMap(0, line);
         //buildCodonMap(1, line);
         //buildCodonMap(2, line);
        }
         printCodonCounts(0, dnaCodons.get(getMostCommonCodon()));
         //System.out.println("the most common codon is "+ getMostCommonCodon()+ " and its count is"+ dnaCodons.get(getMostCommonCodon()));
         //printCodonCounts(1,5);
         
            
        }
            
    public void test2(){
            dnaCodons.clear();
            FileResource resource = new FileResource();
            for(String line : resource.lines()){
                 line= line.toLowerCase();
                 line = line.trim();
                 buildCodonMap(0, line);
            }
            System.out.println("the unique codons with 0 reading frame are "+ dnaCodons.size() );
            
            dnaCodons.clear();
            for(String line : resource.lines()){
                 line= line.toLowerCase();
                 line = line.trim();
                 buildCodonMap(1, line);
            }
            System.out.println("the unique codons with 1 reading frame are "+ dnaCodons.size() );
            
            dnaCodons.clear();
            for(String line : resource.lines()){
                 line= line.toLowerCase();
                 line = line.trim();
                 buildCodonMap(2, line);
            }
            System.out.println("the unique codons with 2 reading frame are "+ dnaCodons.size() );
    }
    }

    
