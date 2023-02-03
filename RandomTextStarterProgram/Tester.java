package RandomTextStarterProgram;
import java.util.ArrayList;
import edu.duke.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
     /**
     * Constructor for objects of class Tester
     */
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    void testGetFollows()
    {
       MarkovOne markov = new MarkovOne();
       markov.setTraining("this is a test yes this is a test.");
       ArrayList<String> result= markov.getFollows("es");
       
       for(int i=0; i<result.size(); i++){ System.out.println(result.get(i)+ " ");}
    }
    
    void testGetFollowsWithFile(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> result= markov.getFollows("th");
        System.out.println(result.size());
    }
}
