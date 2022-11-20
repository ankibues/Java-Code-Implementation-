import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String,ArrayList<String>> myMap;
    private ArrayList<String> counts;
    private ArrayList<String> alreadyusedList;
    private int count;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap = new HashMap<String,ArrayList<String>>();
        counts = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        count= 0;
        alreadyusedList= new ArrayList<String>();
    }
    
    public GladLibMap(String source){
        myMap = new HashMap<String,ArrayList<String>>();
        counts = new ArrayList<String>();
        initializeFromSource(source);
        myRandom = new Random();
        count= 0;
        alreadyusedList= new ArrayList<String>();
    }
    
    private void initializeFromSource(String source) {
        String[] array = {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
        for (String i: array){
            myMap.put(i,new ArrayList<String>());
            ArrayList<String> list = myMap.get(i);
            list = readIt(source +"/"+ i +".txt");
            myMap.put(i,list);
        
        }
        
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
            int index = counts.indexOf(label);
            if(index == -1){
                counts.add(label);
            }
            if(myMap.containsKey(label)) return randomFrom(myMap.get(label));
            if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
            }
            return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        count +=1;
        int index = alreadyusedList.indexOf(sub);
        if(index == -1){
            alreadyusedList.add(sub);
        }
        else
        { 
            System.out.println("Oh, seems like "+ sub + " has been used before!  \n ");
        }
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        alreadyusedList.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
        System.out.println(" \n total number of words replaced are"+ count);
        totalWordsInMap();
        totalWordsConsidered();
    }
    
    public void totalWordsInMap(){
        int num=0;
        for(String key:myMap.keySet()){
        num= num + myMap.get(key).size();    
        }
        
        System.out.println("\n Total number of words that were possible to pick from were " + num );
    
    
    }
    
    public void totalWordsConsidered(){
        int num=0;
        for(int i= 0; i<counts.size();i++){
            if((counts.get(i)).equals("number"))   continue;
            num = num + (myMap.get(counts.get(i))).size();
            }
        System.out.println("\n Total number of words considered " + num );
    }
    public void test(){
        String[] array = {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
        HashMap<String,ArrayList<String>> Map = new HashMap<String,ArrayList<String>>();
            for (String i: array){
                myMap.put(i,new ArrayList<String>());
                ArrayList<String> list = myMap.get(i);
                list = readIt(dataSourceDirectory +"/"+ i +".txt");
                myMap.put(i,list);
                System.out.println(myMap.get(i) + "\n");
                System.out.println(randomFrom(myMap.get("color")));
        
            }
        
    
    }

}
