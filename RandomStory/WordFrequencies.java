import edu.duke.*;
import java.util.ArrayList;
/**
 * Write a description of class WordFrequencies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordFrequencies
{
    // instance variables - replace the example below with your own
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    /**
     * Constructor for objects of class WordFrequencies
     */
    public WordFrequencies()
    {
        // initialise instance variables
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    /**
     **/
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s:resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index== -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }       
        
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+ myWords.size());
        for(int k=0; k<myWords.size();k++){
        System.out.println(myFreqs.get(k)+ "\t" + myWords.get(k));       
        }
        
        System.out.println("The word that occurs most often and its count are " + myWords.get(findIndexOfMax()) +" "+ myFreqs.get(findIndexOfMax()) );
    }
    
    public int findIndexOfMax(){
        int maxval= 0;
        int index = 0;
        for(int k=0; k<myFreqs.size();k++){
            if(myFreqs.get(k)>maxval){
            maxval = myFreqs.get(k);
            index= k;
            }
        }
        return index;     
    }
}
