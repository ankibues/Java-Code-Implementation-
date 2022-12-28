
/**
 * Write a description of class MagnitudeFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter
{
    // instance variables - replace the example below with your own
    private double min;
    private double max;
    private String nam;

    /**
     * Constructor for objects of class MagnitudeFilter
     */
    public MagnitudeFilter(double minmag, double maxmag, String name)
    {
        // initialise instance variables
        min= minmag;
        max= maxmag;
        nam= name;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= min && qe.getMagnitude() <= max; 
    } 
    public void addFilter(Filter f){
        //arrFil.add(f); 
    }
    public String getName(){
        return nam;
    }
}
