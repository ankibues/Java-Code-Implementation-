package Interface_AbstractClassImplementation;


/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
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
    }
}
