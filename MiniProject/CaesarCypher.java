import edu.duke.*;
/**
 * Write a description of class CaesarCypher here.
 *
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCypher
{
    // instance variables - replace the example below with your own
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCypher(int key)
    {
        // initialise instance variables
        alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey= key;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
            char newChar = shiftedAlphabet.charAt(idx);
            
            // condition if curr is lowercase, convert back into uppercase
            if (Character.isLowerCase(curr)){
             newChar= Character.toLowerCase(newChar);
            }
            encrypted.setCharAt(i,newChar);            
            } 
            }
            return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCypher cc = new CaesarCypher(26 - mainKey);
        return cc.encrypt(input);
        
    }
}
