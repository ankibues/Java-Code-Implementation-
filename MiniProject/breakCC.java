import edu.duke.*;
/**
 * Write a description of class breakCC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class breakCC
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class breakCC
     */
    public breakCC()
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
    public String decrypt(String encrypted)
    {
        // put your code here
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;  
        if (maxDex<4){
        dkey = 26 - (4- maxDex);
        }
        return cc.encrypt(encrypted,26-dkey);
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
    
    public String halfOfString(String message, int start){
        StringBuilder newmessage = new StringBuilder("");
        
        if(message.length()%2 == 0){
            newmessage.setLength((message.length())/2);
            
        }
        
        else
        {
            if(start==0){
            newmessage.setLength(((message.length()+1))/2);
            
            }
            else{
            newmessage.setLength(((message.length()-1))/2);
            
            }
        
        }
        
        int j= 0;
        for(int i=start; i<message.length();i=i+2){
                newmessage.setCharAt(j,message.charAt(i));
                j+=1;
        }
        
        return newmessage.toString();
    }
    
    public int getKey(String s){
      return maxIndex(countLetters(s));        
    
    }
    
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String s1 = halfOfString(encrypted,0);
        String s2 = halfOfString(encrypted,1);
        int[] freqs1 = countLetters(s1);
        int maxDex1 = maxIndex(freqs1);
        int dkey1 = maxDex1 - 4;  
        if (maxDex1<4){
        dkey1 = 26 - (4- maxDex1);
        }
        int[] freqs2 = countLetters(s2);
        int maxDex2 = maxIndex(freqs2);
        int dkey2 = maxDex2 - 4;  
        if (maxDex2<4){
        dkey2 = 26 - (4- maxDex2);
        }
        
        System.out.println("The two keys are " + dkey1 + " and "+ dkey2);
        return cc.encryptTwoKeys(encrypted, 26-dkey1, 26-dkey2);
    }
    
    public void test(){
    int key=6;
    CaesarCipher cd = new CaesarCipher();
    FileResource fr= new FileResource();
    String message= fr.asString();
    //String encrypted = cd.encrypt(message,key);
    //System.out.println(encrypted);
    
    //String decrypted = decrypt(encrypted);
    //System.out.println(cd.encrypt(encrypted, 26-key));
    //System.out.println(decrypted);   
    //int key1= 2;
    //int key2 =20;
    //String message= "Top ncmy qkff vi vguv vbg ycpx";
    //String encrypted1 = cd.encryptTwoKeys(message,26-key1,26-key2);
    //System.out.println(encrypted1);
    //String encrypted11 = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
    String decrypted1= decryptTwoKeys(message);
    System.out.println(decrypted1); 
    
    
    }
}
