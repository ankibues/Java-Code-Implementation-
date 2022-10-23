
/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part3
     */
    public Part3()
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
    public boolean  twoOccurrences(String stringa, String stringb)
    {
        // calculate length of both strings and check that l1>l2; if not send a message
        int l1= stringa.length();
        int l2= stringb.length();
        if(l1>l2)
        {
            System.out.println("The First string should be smaller than the second one. Please try again!");
            return false;
        }
        int count = 0;
        for(int i=0; i<(l2-l1); i++)
        {
        String K;
        if((i+l1)>l2)
            {
             K = stringb.substring(i);
            }
            else
            {
             K = stringb.substring(i,i+l1);
            }
                   
         if(stringa.equals(K))
         {
             count = count +1;
         }
                
        }
        if(count>=2)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    
        // take a substring from stringb, and check if that is equal to stringa; if so , add it to a counter
        // if counter >=2, return true
    }
    
    public String  LastPart(String stringa, String stringb)
    {    
        
        String result="";
        
        int l1= stringa.length();
        int l2= stringb.length();
        
        if(l1>l2)
        {
            String K= "The First string should be smaller than the second one. Please try again!";
            return K;
        }
        
        for(int i=0; i<(l2-l1); i++)
        {
        String K;
        if((i+l1)>l2)
            {
             K = stringb.substring(i);
            }
            else
            {
             K = stringb.substring(i,i+l1);
            }
                   
         if(stringa.equals(K) && (i+l1)<=(l2-1))
         {
             result= stringb.substring(i+l1);
             break;
         }
                 
        }
        if (result=="")
        {
            result= stringb;
        }
        return result;
    }
        
        
    
        // take a substring from stringb, and check if that is equal to stringa; if so , add it to a counter
        // if counter >=2, return true
    
    
    public void testing()
    {
       String a1= "bye";
       String a2 = "A ";
       System.out.println("The two strings are " + a1 + " and " + a2);
       System.out.println("The result is " + twoOccurrences(a1, a2)); 
        
       String a3= "an";
       String a4 = "banana";
       System.out.println("The two strings are " + a3 + " and " + a4);
       System.out.println("The result is " + twoOccurrences(a3, a4)); 
       System.out.println("The last part is " + LastPart(a3,a4) ); 
       
      
    
       
    }
}

