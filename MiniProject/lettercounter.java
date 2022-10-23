import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class lettercounter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class lettercounter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class lettercounter
     */
    public lettercounter()
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
    public void lettercounter(String s)
    {
        // put your code here
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters= new int[26];
        for(int k=0; k<s.length();k++){
        char ch= s.charAt(k);
        int index = alpha.indexOf(Character.toLowerCase(ch));
        if (index != -1){
            counters[index]+= 1;
        }       
        }
        
        for(int k=0;k<counters.length;k++){
        System.out.println(alpha.charAt(k) + "\t"+ counters[k]);
        }
    }
}
