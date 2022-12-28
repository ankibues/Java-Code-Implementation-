import java.util.*;
/**
 * Write a description of class LargestQuakes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LargestQuakes
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class LargestQuakes
     */
    public LargestQuakes()
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
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        //System.out.println("Largest earthquake is at location "+ indexOfLargest(list) + " and its magnitude is "+ list.get(indexOfLargest(list)).getMagnitude()); 
        
        ArrayList<QuakeEntry> answer =  getLargest(list, 50);
        
        for (QuakeEntry qe : answer){
            System.out.println(qe);       
        }
        //*/
        
        
        
    
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        QuakeEntry quake= null; 
        for(int i=0; i<howMany; i++){
            ret.add(quakeData.get(indexOfLargest(quakeData)));
            quakeData.remove(quakeData.get(indexOfLargest(quakeData)));
            System.out.println("\nAfter removing the element the size of the ArrayList is: " + quakeData.size());  
        }
        return ret;
    
    } 
    
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        double mag= 0.0;
        QuakeEntry largest=null;
        for (QuakeEntry qe : data){
            if(qe.getMagnitude()> mag){
            mag = qe.getMagnitude();
            largest= qe;
            }       
        }
        return data.indexOf(largest);
    }
}
