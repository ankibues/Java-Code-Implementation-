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
public class MarkovModel extends AbstractMarkovModel
{
      private int N;
=======
public class MarkovModel implements IMarkovModel
{
    private String myText;
    private Random myRandom;
    private int N;
>>>>>>> Stashed changes
        public MarkovModel(int n)
    {
        myRandom = new Random();
        N=n;
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
        int index = myRandom.nextInt(myText.length()-N);
        String key= myText.substring(index,index+N);
        sb.append(key);
        
        for(int k=0; k < numChars-N; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){break;}
            index= myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key= key.substring(1)+ next;
        }
        
        return sb.toString();
    }
    
<<<<<<< Updated upstream
    public String toString(){
    return "Markov Model of Order " + N;
    }
}
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
    }
}
>>>>>>> Stashed changes
