import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder answer = new StringBuilder();
        char [] array= message.toCharArray();
        for (int i = whichSlice; i < array.length; i=i+ totalSlices){
            
        answer.append(array[i]);
        
        }
        return answer.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cipher2 = new CaesarCracker(mostCommon);
        
        for (int i = 0; i< klength; i++){
        key[i] = cipher2.getKey(sliceString(encrypted, i,klength));
        }
        return key;
    }

    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> strset = new HashSet<>();
        for(String s : fr.lines()){
        s = s.toLowerCase();   
        strset.add(s);
        }
    
        return strset;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
    int count = 0;
    String[] str = message.split("\\W+");
    for(String s : str){
        s = s.toLowerCase();
        if(dictionary.contains(s)){
            count= count+1;    
        }
    }   
    return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int lrgcnt=0;
        int klen=0;
        String message= null;
        for(int kl=1; kl<=100;kl++){
        char cha= mostCommonCharIn(dictionary);
        VigenereCipher ciphe = new VigenereCipher(tryKeyLength(encrypted, kl,cha));
        int count= countWords(ciphe.decrypt(encrypted), dictionary);
        if(count >= lrgcnt){
            lrgcnt= count;
            klen= kl;
            message= ciphe.decrypt(encrypted);
        }
        
        }
        System.out.println("key length is "+ klen);
        System.out.println("total valid words are"+ lrgcnt);
        return message;
    }
      
    public char mostCommonCharIn(HashSet<String> dictionary){
        String english= "abcdefghijklmnopqrstuvwxyz";
        int [] counts= new int[english.length()];
        for (String str: dictionary){
            for (int i=0; i<str.length(); i++){
                if(english.indexOf(str.charAt(i)) != -1){
                counts[english.indexOf(str.charAt(i))]++;
                }
            }
            
        }
        
        return english.charAt(maxDex(counts));
        
    
    }
    
    public int maxDex(int[] count){
        int max=0;
        int ind=0;
        for(int i=0; i< count.length ;i++){
        if(count[i]>max){
            max = count[i];
            ind= i;
        }
        
        }
        return ind;
    
    }
    public int[] countChar(String str){
        int [] counts= new int[26];
        String english= "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<str.length(); i++){
            if(english.indexOf(str.charAt(i)) != -1){
                counts[english.indexOf(str.charAt(i))]++;
            }
        
        }
        return counts;
    }
    
    public void breakForAllLangs(String encrypted,HashMap<String, HashSet<String>> languages){
        for(String str:languages.keySet()){
            String message = breakForLanguage(encrypted, languages.get(str));
            System.out.println("*******Decrypting in *****"+ str + " language, here it is***********");
            System.out.println(message);                  
        }    
    }
    
    public void breakVigenere () {
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
        int[] key = tryKeyLength(enmessage,4,'e');
        VigenereCipher ciphe = new VigenereCipher(key);
        System.out.println("here is the decrypted message: ");
        System.out.println(ciphe.decrypt(enmessage));
    }
    
    public void breakVigenere2 () {
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
        FileResource fr = new FileResource();      
        String message = breakForLanguage(enmessage, readDictionary(fr));
        System.out.println(" here is the decrypted message: ");
        System.out.println(message);
    }
    
    public void breakVigenere3 (){
        FileResource resource = new FileResource();
        String enmessage= resource.asString();
        String[] str= {"Danish","Dutch","English", "French", "German", "Italian", "Portuguese", "Spanish"};
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>> ();
        for(int i=0; i< str.length; i++){
            System.out.println("Select the file for " + str[i] + " language");
            FileResource fr = new FileResource();            
            languages.put(str[i],readDictionary(fr));
            System.out.println(str[i] + " language added to HashMap");
        }
        
        breakForAllLangs(enmessage,languages);
        
        

    
    }
}
