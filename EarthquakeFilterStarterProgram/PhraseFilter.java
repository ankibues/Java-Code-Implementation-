
/**
 * Write a description of class PhraseFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter
{
    // instance variables - replace the example below with your own
    private String where;
    private String phrase;
    private String nam;
    /**
     * Constructor for objects of class PhraseFilter
     */
    public PhraseFilter(String wher, String phrs, String name)
    {
        // initialise instance variables
        where= wher;
        phrase= phrs;
        nam= name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        if(where.equals("start") && qe.getInfo().startsWith(phrase)){
                return true;
            }
            else if(where.equals("end") && qe.getInfo().endsWith(phrase)){
                return true;
            }
            else if(where.equals("any") && qe.getInfo().contains(phrase)){
                return true;
            }
            else
            { return false;}
    } 
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addFilter(Filter f){
        //arrFil.add(f); 
    }
    public String getName(){
        return nam;
    }
    
}
