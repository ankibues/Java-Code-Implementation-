
/**
 * Write a description of class Part5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part5
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part5
     */
    public Part5()
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
    public int howmany(String stringa, String stringb)
    {
        int count = 0;
        int ind = 0;
        // put your code here
        while(stringb.indexOf(stringa,ind)!= -1)
        {
          int startI = stringb.indexOf(stringa,ind);
        if(startI> 0)
        {
            count = count +1;
        }
        ind = startI + stringa.length();
        }
        return count;
    }
    
    public void testHowMany()
    {
       int K1= howmany("GAAT", "ATGAACGAATTGAATCGAAGAAGAATGA");
       System.out.println("GAAT " + " appears " + K1 + " times");
       int K2= howmany ("AA","ATAAAAAA");
       System.out.println("AA " + " appears " + K2 + " times");
    
    
    }
    }
