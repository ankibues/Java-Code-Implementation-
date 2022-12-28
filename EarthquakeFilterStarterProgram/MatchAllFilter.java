import java.util.*;
import edu.duke.*;
/**
 * Write a description of class MatchAllFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatchAllFilter implements Filter
{
    // instance variables - replace the example below with your own
    
    public ArrayList<Filter> arrFil;
    
    /**
     * Constructor for objects of class MatchAllFilter
     */
    public MatchAllFilter()
    {
        // initialise instance variables
        arrFil= new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f){
        arrFil.add(f); 
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        for(Filter f: arrFil){
            if(! f.satisfies(qe)){
                return false;
            }
        }
        return true;
    } 
    public String getName(){
        String res= "";
        for(Filter f: arrFil){
        res= res +" "+ f.getName();
        }
        return res;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
