import edu.duke.*;
import java.util.ArrayList;
/**
 * Write a description of class CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharactersInPlay
{
    // instance variables - replace the example below with your own
    private ArrayList<String> CharacterName;
    private ArrayList<Integer> CharacterCount;

    /**
     * Constructor for objects of class CharactersInPlay
     */
    public CharactersInPlay()
    {
        // initialise instance variables
        CharacterName = new ArrayList<String>();
        CharacterCount = new ArrayList<Integer>();
    }

    /**
     *Update Method-- this method updates the two ArrayLists, adding character's name and counting this line as one speaking part
     */
    public void update(String person)
    {
        // put your code here
        //person = person.toLowerCase();
        int index = CharacterName.indexOf(person);
        if (index== -1){
                CharacterName.add(person);
                CharacterCount.add(1);
            }
            else{
                int value = CharacterCount.get(index);
                CharacterCount.set(index, value+1);
            }
        
    }
    
    public void findAllCharacters(){
        CharacterName.clear();
        CharacterCount.clear();
        FileResource resource = new FileResource();
        
        for(String s:resource.lines()){
            int dot = s.indexOf(".");
            if (dot!= -1){
               update(s.substring(0,dot));
            }
            
        }
    
    
    }
    
    public void tester(){
        findAllCharacters();
        
        System.out.println("# of characters: "+ CharacterName.size());
        for(int k=0; k<CharacterName.size();k++){
        System.out.println("The character name is "+ CharacterName.get(k)+ " and they speak " + CharacterCount.get(k)+" times");       
        }
    }
}
