package WordGramClassStarterProgram;
import java.util.Random;
import java.util.ArrayList;


/**
 * Write a description of class MarkovWord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MarkovWord implements IMarkovModel
{
    // instance variables - replace the example below with your own
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int order)
    {
        // initialise instance variables
        myRandom = new Random();
        myOrder = order;
    }
    
    public void setTraining(String text){
         myText = text.split("\\s+");
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    private int indexOf(String[] words, WordGram target, int start){
        
        for(int i=start; i< words.length-myOrder; i++){
        WordGram wg = new WordGram(words,i,myOrder);    
        if(wg.equals(target)){
        return i;
        }    
        }        
        return -1;    
    }
    
     private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos=0;
        int ind=0;
        while(ind !=-1){
            ind = indexOf(myText,kGram,pos);
            if (ind==-1) break;
            if((ind + myOrder)> myText.length-myOrder) break;
            follows.add(myText[ind + myOrder]);
            pos = ind + myOrder;
        }
        return follows;
        }  
         
    public String getRandomText(int numWords){
    StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kgram = new WordGram(myText,index,myOrder);
        sb.append(kgram.toString());
        sb.append(" ");
        for(int k=0; k < numWords; k++){
            ArrayList<String> follows = getFollows(kgram);
            //System.out.println("the key is "+ key + "and the words that follows are");
            //System.out.println(follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kgram = kgram.shiftAdd(next);
        }
        
        return sb.toString().trim();
    
    }
    
    

    
}
