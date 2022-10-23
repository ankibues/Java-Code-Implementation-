import edu.duke.*;


/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part4
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part4
     */
    public Part4()
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
    public void printYoutubelink()
    {
        // put your code here
         URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
         String K;   
         for (String word : ur.words()) {
             
             
             // check if youtube.com is in this word
             String stringa = "youtube.com";
             int l1= stringa.length();
             int l2= word.length();
             if(l1>l2)
             {
                 continue;
             }
        
             // check index of 
               int startIndex = word.indexOf("youtube.com"); 
               if(startIndex == -1)
               {
                continue;
               }
                int firstIndex= word.indexOf("\"");
                int secondIndex= word.indexOf("\"",startIndex);
                K = word.substring(firstIndex+1,secondIndex);
                System.out.println(K + "\n"); 
             }  
             
            }
    }
    

