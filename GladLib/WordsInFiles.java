import edu.duke.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class WordsInFiles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordsInFiles
{
    // instance variables - replace the example below with your own
    private HashMap<String,ArrayList<String>> wordsinfile; 

    /**
     * Constructor for objects of class WordsInFiles
     */
    public WordsInFiles()
    {
        // initialise instance variables
        wordsinfile = new HashMap<String,ArrayList<String>>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void addWordsFromFile(File f)
    {
        // put your code here (read from the file)
        FileResource resource = new FileResource(f);
        for(String word : resource.words()){
           if(!wordsinfile.containsKey(word)){
               // when word is not in the hashmap, add it; add file name in the array list
               wordsinfile.put(word,new ArrayList<String>());
               ArrayList<String> list = wordsinfile.get(word);
               list.add(f.getName());
               wordsinfile.put(word,list);
            }
            else{
                // when word is already in the hashmap, then check if the arrayList has the filename, if not add it
                ArrayList<String> list = wordsinfile.get(word);
                if(!list.contains(f.getName())){
                  list.add(f.getName());  
                }
                // check if this list has the word
                //wordsinfile.put(word,list.add(f.toString()));
            }     
        }
    }
    
    private void buildWordFileMap(){
        wordsinfile.clear();
         DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
            }   
    
    }
    
    private int maxNumber(){
        int maxNum=0;
        for (String s:wordsinfile.keySet()){
        ArrayList<String> list = wordsinfile.get(s);
        if(list.size()> maxNum){
        maxNum = list.size();
        } 
                
        }
        return maxNum;   
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> list= new ArrayList<String>();
        for (String s:wordsinfile.keySet()){
            ArrayList<String> listt = wordsinfile.get(s);
            if(listt.size()== number){
                list.add(s);
            }    
        }
        return list;
    }
    
    private void printFilesln(String word){ 
        ArrayList<String> list = wordsinfile.get(word);
        for(int i=0; i< list.size();i++){
        System.out.println(list.get(i));        
        }         
    }
    
    public void tester(){
        buildWordFileMap();
        System.out.println("The maximum number of files any word is in , is "+ maxNumber());
        ArrayList<String> listS= wordsInNumFiles(maxNumber());
        System.out.println("The following words are in the max number of files: ");
        for(int i=0; i< listS.size();i++){
        System.out.println("The word "+ listS.get(i)+ "is in the following file ");
        printFilesln(listS.get(i));
        }  
    
    
    }
    
}
