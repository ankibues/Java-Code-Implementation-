import edu.duke.*;
/**
 * Write a description of class wordcount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class wordcount
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class wordcount
     */
    public wordcount()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String[] getCommon(){
        FileResource resource = new FileResource("common.txt");  // 
        String[] common = new String[20];
        int index= 0;
        for(String s: resource.words()){
            common[index]=s;
            index += 1;       
        }
        return common;
    
    }
    public void countShakespeare()
    {
        String[] plays= {"caesar.txt", "errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int k=0; k<plays.length; k++){
            FileResource resource = new FileResource(plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with"+ plays[k]);
        }
        
        for(int k=0;k<common.length; k++){
        System.out.println(common[k]+ "\t"+ counts[k]);        
        }
        
        }
    public int indexOf(String[] list, String word){
        for(int k=0; k<list.length; k++){
            if(list[k].equals(word)){
                return k;
            }
            
        }
        return -1;
    }    
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if(index != -1){
            counts[index] += 1;
            }
        
        
        }
    
    
    } 
        
        
        

}
