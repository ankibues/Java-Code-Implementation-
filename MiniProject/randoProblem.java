import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class randoProblem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class randoProblem
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class randoProblem
     */
    public randoProblem()
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
    public void sampleMethod(int[] A)
    {
        
        for(int i=0; i<A.length;i++){
            if(A[i]+ A[i]==6)
                {
                    System.out.println(A[i]+ " "+ A[i]);
                }
                
            for(int j=i+1;j<A.length; j++){
                if(A[i]+ A[j]==6)
                {
                    System.out.println(A[i]+ " "+ A[j]);
                }
                
            
            
            }
        }
        
    }
    
     public boolean isPalindrome(int x) {
        String k ="";
        String s = Integer.toString(x);
        for(int i= s.length()-1; i>=0;i--){
            k = k +  s.charAt(i);
        }
         System.out.println(s);
         System.out.println(k);
        if (s.equals(k)){
            
            return true;
        }
        else{
            return false;
        }
    }
}
