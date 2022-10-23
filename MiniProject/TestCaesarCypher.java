import edu.duke.*;
/**
 * Write a description of class TestCaesarCypher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCypher
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TestCaesarCypher
     */
    public TestCaesarCypher()
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
    public void simpletests()
    {
        // put your code here
        FileResource fr= new FileResource();
        String message= fr.asString();
        CaesarCypher cc = new CaesarCypher(18);
        System.out.println("The ecrypted message is  >  " + cc.encrypt(message));
        System.out.println("To check if it worked, here is the decrypted version \n" + cc.decrypt(cc.encrypt(message)));
        System.out.println("Now using Break Caesar Cypher method (statistical one) to break Caesar Cypher \n"+ breakCaesarCypher(cc.encrypt(message)));
        
    }
    public int[] countLetters(String encrypted){
            String alpha = "abcdefghijklmnopqrstuvwxyz";
            int[] counters= new int[26];
            for(int k=0; k<encrypted.length();k++){
                char ch= encrypted.charAt(k);
                int index = alpha.indexOf(Character.toLowerCase(ch));
                if (index != -1){
                    counters[index]+= 1;
                    }       
                }   
            return counters;
    }
    
    public int maxIndex(int[] vals){
        int maxDex=0;
        for(int k=0; k<vals.length; k++){
            if (vals[k] > vals[maxDex]){
            maxDex = k;            
            }       
        }
    return maxDex;    
    }
    
    public String breakCaesarCypher(String input){
        
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;  
        if (maxDex<4){
        dkey = 26 - (4- maxDex);
        }
        CaesarCypher cc = new CaesarCypher(dkey);
        return cc.decrypt(input);
    
    
    }
}
