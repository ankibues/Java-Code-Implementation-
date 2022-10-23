
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = 0;
    }
    
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3) {
            break;
        }
        
        
        //try{
        System.out.println("index " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        //}
        //catch(Exception e) {System.out.println("Something went wrong in "+ input);}
        index = input.indexOf("abc", index+3);
        System.out.println("index after updating " + index);
    }
    }
    public void test() {
    //findAbc("abcd");
     findAbc("abcabcabcabca");
    //findAbc("yabcyabc");
    //findAbc("woiehabchi");
    //findAbc("aaaaabc");
    //findAbc("abcbbbabcdddabc");
    //findAbc("eusabce");
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    }
