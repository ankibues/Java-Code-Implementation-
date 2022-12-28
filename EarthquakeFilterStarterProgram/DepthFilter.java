
/**
 * Write a description of class MagnitudeFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter
{
    // instance variables - replace the example below with your own
    private double min;
    private double max;
    private String nam;
    /**
     * Constructor for objects of class MagnitudeFilter
     */
    public DepthFilter(double mindep, double maxdep, String name)
    {
        // initialise instance variables
        min= mindep;
        max= maxdep;
        nam= name;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getDepth() >= min && qe.getDepth() <= max; 
    } 
    public void addFilter(Filter f){
        //arrFil.add(f); 
    }
    public String getName(){
        return nam;
    }
}
