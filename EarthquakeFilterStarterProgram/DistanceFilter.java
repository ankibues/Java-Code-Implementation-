
/**
 * Write a description of class DistanceFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter
{
    // instance variables - replace the example below with your own
    private double maxdist;
    private Location myLocation; 
    private String nam;
    /**
     * Constructor for objects of class DistanceFilter
     */
    public DistanceFilter(double maxD, Location myloc, String name)
    {
        // initialise instance variables
        myLocation= myloc;
        maxdist= maxD;
        nam = name;
    
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(myLocation) < maxdist; 
    } 
    public void addFilter(Filter f){
        //arrFil.add(f); 
    }
    public String getName(){
        return nam;
    }
}
