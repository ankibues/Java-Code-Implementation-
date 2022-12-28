
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    private String nam;
    
    public MinMagFilter(double min, String name) { 
        magMin = min;
        nam = name;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 
    
    public void addFilter(Filter f){}
    
    public String getName(){
        return nam;
    }
}
