import edu.duke.*;
/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WordPlay
     */
    public WordPlay()
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
    
    public boolean isVowel(char ch){
        
        String vowels = "AEIOU";
        
        for(int i=0; i<vowels.length();i++){
            if (Character.isLowerCase(ch)){
             ch= Character.toUpperCase(ch);
            }
            if(ch == vowels.charAt(i))
            {
                return true;
            }
        
        }
        return false;          
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder phrase1 = new StringBuilder(phrase);
        
        for(int i=0; i<phrase1.length();i++){
            char curr= phrase1.charAt(i);
                        
            if(isVowel(curr)){
            phrase1.setCharAt(i,ch);
            }                    
            }
            return phrase1.toString();
    }
    
    
        public String emphasize(String phrase, char ch){
        StringBuilder phrase1 = new StringBuilder(phrase);
        
        for(int i=0; i<phrase1.length();i++){
            // if ch is lower case, then make a new char ch1 with upper case,else otherwise
            char ch1;
            if(Character.isLowerCase(ch)){
            ch1= Character.toUpperCase(ch);
            }
            else{
            ch1= Character.toLowerCase(ch);
            }
            // check that if char at i is equal to ch or ch1 , if so,
            if(phrase1.charAt(i)== ch  || phrase1.charAt(i)== ch1){
            // then check again, if index is even or odd
            
            if(i%2==0){
                phrase1.setCharAt(i,'*');
            }
            else{
                phrase1.setCharAt(i,'+');
            }
            
            }        
        }
            return phrase1.toString();
    }
    
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
    int key=17;
    FileResource fr= new FileResource();
    String message= fr.asString();
    String encrypted = encrypt(message,key);
    System.out.println(encrypted);
    String decrypted = encrypt(encrypted,26-key);
    System.out.println(decrypted);   
    }
}
