import edu.duke.*;
/**
 * Write a description of class TestCaesarCypherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCypherTwo
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TestCaesarCypherTwo
     */
    public TestCaesarCypherTwo()
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
    public void simpleTests(){
        FileResource fr= new FileResource();
        String message= fr.asString();
        CaesarCypherTwo cc = new CaesarCypherTwo(17,3);
        System.out.println("The ecrypted message using the two keys is  >  " + cc.encrypt(message));
        System.out.println("To check if it worked, here is the decrypted version \n" + cc.decrypt(cc.encrypt(message)));
        System.out.println("Now using Break Caesar Cypher method (statistical one) to break Caesar Cypher \n"+ breakCaesarCypher(cc.encrypt(message)));
    
    
    
    
    }
    
    public String breakCaesarCypher(String input){
        String s1 = halfOfString(input,0);
        String s2 = halfOfString(input,1);
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
        CaesarCypherTwo cc = new CaesarCypherTwo(dkey1,dkey2);
        return cc.decrypt(input);
    
    
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
}
