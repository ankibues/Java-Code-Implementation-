import edu.duke.*;
import java.util.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
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
    public void testCaesarCipher(){
        int key= 5;
        CaesarCipher cipher= new CaesarCipher(key);
        CaesarCracker cipher2 = new CaesarCracker();
        CaesarCracker cipher3 = new CaesarCracker('a');
        FileResource resource = new FileResource();
        String message= resource.asString();
        int[]  kkey= {17, 14, 12, 4};
        VigenereCipher ccipher = new VigenereCipher(kkey);
        System.out.println(ccipher.encrypt(message));
        //String message= cipher.encrypt(line);
        //System.out.println(message);
        //System.out.println(cipher.decrypt(message));
        //System.out.println(cipher2.getKey(message));
        //System.out.println(cipher3.getKey(message));
        //System.out.println(cipher.encryptLetter('n'));
        
        
    
    }
    
    public void testVigenereBreaker(){
        
        VigenereBreaker breaker = new VigenereBreaker();
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
        int[] key = breaker.tryKeyLength(enmessage,38,'e');
        for(int i=0;i< key.length;i++)
        {
        System.out.println(key[i]);
        }
        /*
        System.out.println(breaker.sliceString("abcdefghijklm", 0, 3));
        System.out.println(breaker.sliceString("abcdefghijklm", 1, 3));
        System.out.println(breaker.sliceString("abcdefghijklm", 2, 3));
        System.out.println(breaker.sliceString("abcdefghijklm", 0, 4));
        System.out.println(breaker.sliceString("abcdefghijklm", 1, 4));
        System.out.println(breaker.sliceString("abcdefghijklm", 2, 4));
        System.out.println(breaker.sliceString("abcdefghijklm", 3, 4));
        System.out.println(breaker.sliceString("abcdefghijklm", 0, 5));
        System.out.println(breaker.sliceString("abcdefghijklm", 1, 5));
        System.out.println(breaker.sliceString("abcdefghijklm", 2, 5));
        System.out.println(breaker.sliceString("abcdefghijklm", 3, 5));
        System.out.println(breaker.sliceString("abcdefghijklm", 4, 5));
        */
    }
    
    public void countValidWords(){
        VigenereBreaker breaker = new VigenereBreaker();
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
         
        FileResource fr = new FileResource();
        HashSet<String> dictionary= breaker.readDictionary(fr);
        VigenereCipher ciphe = new VigenereCipher(breaker.tryKeyLength(enmessage, 38,'e'));
        int count = breaker.countWords(ciphe.decrypt(enmessage), dictionary);
        System.out.println("Total valid words are" + count);
    }
    
    public void testCountWords(){
        VigenereBreaker breaker = new VigenereBreaker();
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
    
    }
}
