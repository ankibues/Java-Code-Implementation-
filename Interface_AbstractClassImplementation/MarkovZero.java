package Interface_AbstractClassImplementation;
<<<<<<< Updated upstream
import java.util.Random;

public class MarkovZero extends AbstractMarkovModel {
       
=======


import java.util.Random;

public class MarkovZero implements IMarkovModel{
    private String myText;
    private Random myRandom;
    
>>>>>>> Stashed changes
    public MarkovZero() {
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
        for(int k=0; k < numChars; k++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        
        return sb.toString();
    }
<<<<<<< Updated upstream
    
    public String toString(){
    return "Markov Model of Order 0";
    }
=======
>>>>>>> Stashed changes
}
