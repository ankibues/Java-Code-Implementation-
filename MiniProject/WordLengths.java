import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordLengths
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WordLengths
     */
    public WordLengths()
    {
        // initialise instance variables
        
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void countWordLengths(FileResource resource, int[] counts)
    {
        // put your code here
        
        for(String word : resource.words()){
            word = word.toLowerCase();
            
            if(Character.isLetter(word.charAt(0))== true && Character.isLetter(word.charAt(word.length()-1)) == true ){
                if(word.length() >= counts.length)
                { counts[counts.length-1] +=1 ;}
                else
                {counts[word.length()]+= 1;}            
            }
            
            if((Character.isLetter(word.charAt(0))== true && Character.isLetter(word.charAt(word.length()-1)) == false ) || (Character.isLetter(word.charAt(0))== false && Character.isLetter(word.charAt(word.length()-1)) == true ) ){
                
                if(word.length()-1 >= counts.length)
                { counts[counts.length-1] +=1 ;}
                else
                {counts[word.length()-1]+= 1;}            
            }
            
             if(Character.isLetter(word.charAt(0))== false && Character.isLetter(word.charAt(word.length()-1)) == false ){
                if(word.length()-2 >= counts.length)
                { counts[counts.length-1] +=1 ;}
                else
                {counts[word.length()-2]+= 1;}            
            }
    
        }
    }
    
    public void testCountWordLengths(){
        int[] counts = new int[31];
        FileResource resource = new FileResource();
        countWordLengths(resource, counts);
        
        for (int k=0;k<=30;k++){
        System.out.println(" Words of length " + k + " are "+ counts[k] );
        }
        
        System.out.println ("Most common word length in the file is " + indexOfMax(counts) );
        
    
    }
    
    public int indexOfMax(int[] values){
        int maxDex=0;
        for(int k=0; k<values.length; k++){
            if (values[k] > values[maxDex]){
            maxDex = k;            
            }       
        }
        return maxDex;  
    
    }
    }

