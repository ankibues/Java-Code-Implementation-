package Interface_AbstractClassImplementation;

import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class MarkovOne here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
<<<<<<< Updated upstream
public class MarkovOne extends AbstractMarkovModel
{
    
=======
public class MarkovOne implements IMarkovModel
{
    private String myText;
    private Random myRandom;
>>>>>>> Stashed changes
        public MarkovOne()
    {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key= myText.substring(index,index+1);
        sb.append(key);
        
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){break;}
            index= myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key= next;
        }
        
        return sb.toString();
    }
    
<<<<<<< Updated upstream
    public String toString(){
    return "Markov Model of Order 1";
=======
    public ArrayList<String> getFollows(String key){
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
        return follows;
>>>>>>> Stashed changes
    }
}

