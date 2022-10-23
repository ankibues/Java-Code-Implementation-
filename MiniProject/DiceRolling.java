import java.util.Random;
/**
 * Write a description of class DiceRolling here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiceRolling
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DiceRolling
     */
    public DiceRolling()
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
    public void simpleSimulate(int rolls)
    {
        // put your code here
        Random rand= new Random();
        int twos =0;
        int twelves =0;
        
        for(int k=0;k < rolls; k++){
        int d1 = rand.nextInt(6) +1;
        int d2 = rand.nextInt(6) +1;
        
        if(d1+d2 ==2){
            twos +=1;        
        }
        else if (d1 +d2==12){
        
            twelves +=1;
        }
        }
        System.out.println("2's= \t" + twos + " Percentage \t"+ 100.0*twos/rolls);
        System.out.println("12's= \t" + twelves+ " Percentage \t"+ 100.0*twelves/rolls);
    }
    
    public void Simulate(int rolls)
    {
        // put your code here
        Random rand= new Random();
        int [] counters= new int[13];  
        
        for(int k=0;k < rolls; k++){
        int d1 = rand.nextInt(6) +1;
        int d2 = rand.nextInt(6) +1;
        counters[d1+d2] += 1;
        }
        for (int k=2;k<=12;k++){
        System.out.println(k+"'s= \t" + counters[k] + "  Percentage \t"+ 100.0*counters[k]/rolls);
        }
        
        
    }
    }
