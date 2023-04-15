package Interface_AbstractClassImplementation;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class MarkovOne here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EfficientMarkovModel extends AbstractMarkovModel
{
    private int N;
    private HashMap<String, ArrayList<String>> myMap= new HashMap<String, ArrayList<String>>();
    public EfficientMarkovModel(int n)
    {
        myRandom = new Random();
        N=n;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
        buildMap(myText);
        printHashMapInfo();
    }
    
    public String getRandomText(int numChars){
        
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key= myText.substring(index,index+N);
        sb.append(key);
        //buildMap(myText);
        //printHashMapInfo();
        
        for(int k=0; k < numChars-N; k++){
            ArrayList<String> follow = new ArrayList<String> ();
            follow = getFollows(key);
            if(follow.isEmpty()){break;}
            index= myRandom.nextInt(follow.size());
            String next = follow.get(index);
            sb.append(next);
            key= key.substring(1)+ next;
        }
        
        return sb.toString();
    }
    
    public String toString(){
    return "Markov Model of Order " + N;
    }
    
    private void buildMap(String myText){
        for(int index=0; index < myText.length()-N; index++)
        {
        String key= myText.substring(index,index+N);
        ArrayList<String> follows = new ArrayList<String>();
        int pos=0;
        int ind=0;
        while(ind !=-1){
            ind = myText.indexOf(key,pos);
            if (ind==-1) break;
            if((ind + key.length())> myText.length()-1) break;
            follows.add(Character.toString(myText.charAt(ind + key.length())));
            pos = ind+1;
        }
        if (!myMap.containsKey(key) && !follows.isEmpty())
        { 
            myMap.put(key,follows);
        }
        }    
    }
    
    private void printHashMapInfo(){
     if(myMap.size()<5){System.out.println("Mappings are: " + myMap);}
     System.out.println("The number of keys are " + myMap.size());
     int maxSize=0;
     ArrayList<String> maxKey= new ArrayList<String>();
     for(String key:myMap.keySet()){
         if(myMap.get(key).size()>= maxSize){
            maxSize= myMap.get(key).size();
            maxKey.add(key);
         }
        }
      System.out.println("Size of the largest value in HashMap " + maxSize);
      System.out.println("keys with Maximum size value " + maxKey);

    }
    
    protected ArrayList<String> getFollows(String key){
        return myMap.get(key);
    }
}
