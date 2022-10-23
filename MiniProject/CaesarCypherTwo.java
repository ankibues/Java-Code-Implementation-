import edu.duke.*;
/**
 * Write a description of class CaesarCypherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCypherTwo
{
    // instance variables - replace the example below with your own
    private String alphabet;
    private String shiftedAlphabetkey1;
    private String shiftedAlphabetkey2;
    private int mainKey1;
    private int mainKey2;

    /**
     * Constructor for objects of class CaesarCypherTwo
     */
    public CaesarCypherTwo(int key1, int key2)
    {
        // initialise instance variables
        alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabetkey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabetkey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1= key1;
        mainKey2= key2;
    }
    
    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);
                
        for(int i=0; i<encrypted.length();i++){
            char curr= encrypted.charAt(i);
            char curr1;
            // condition if curr is lowercase, convert it into uppercase
            if (Character.isLowerCase(curr)){
             curr1= Character.toUpperCase(curr);
            }
            else{
                curr1= curr;
            }
            
            int idx= alphabet.indexOf(curr1);
            
            if(idx!=-1){
                if(i%2 == 0){
                    char newChar = shiftedAlphabetkey1.charAt(idx);
                        // condition if curr is lowercase, convert back into uppercase
                    if (Character.isLowerCase(curr)){
                         newChar= Character.toLowerCase(newChar);
                        }
                    encrypted.setCharAt(i,newChar);            
                }
                else{
                char newChar = shiftedAlphabetkey2.charAt(idx);
                        // condition if curr is lowercase, convert back into uppercase
                    if (Character.isLowerCase(curr)){
                         newChar= Character.toLowerCase(newChar);
                        }
                    encrypted.setCharAt(i,newChar);                 
                
                }
            }
            }
            return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCypherTwo cc= new CaesarCypherTwo(26- mainKey1, 26-mainKey2);
        return cc.encrypt(input);
    
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
