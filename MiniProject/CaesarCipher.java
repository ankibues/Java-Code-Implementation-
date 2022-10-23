import edu.duke.*;
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CaesarCipher
     */
    public CaesarCipher()
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
    public String encrypt(String input, int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
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
    
    public void testCaesar(){
    int key=15;
    
    int key1= 8;
    int key2=21;
    
    FileResource fr= new FileResource();
    String message= fr.asString();
    String encrypted = encrypt(message,key);
    System.out.println(encrypted);
    String decrypted = encrypt(encrypted,26-key);
    System.out.println(decrypted);   
    
    
    String encrypted1 = encryptTwoKeys(message,key1,key2);
    System.out.println(encrypted1);
    String decrypted1= encryptTwoKeys(encrypted1,26-key1,26-key2);
    System.out.println(decrypted1); 
    
    
    
    }
    
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabetkey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabetkey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
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
    
}
