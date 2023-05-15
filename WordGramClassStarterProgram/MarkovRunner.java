package WordGramClassStarterProgram;


/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markovWord = new MarkovWord(5); 
        runModel(markovWord, st,50, 844); 
    } 

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 
    
    public void testHashMap(){
    FileResource fr = new FileResource();
    String st = fr.asString();
    st = st.replace('\n', ' ');
    //String st= "this is a test yes this is really a test yes a test this is wow";
    int size = 50;
    EfficientMarkovWord effMarkov= new EfficientMarkovWord(5);
    runMode(effMarkov,st,size,531);
    }
    public void runMode(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
    } 
    public void compareMethods(){
        String path="E:/Dropbox/W3/Java/WordGramClassStarterProgram/data/merkel.txt";
        FileResource fr = new FileResource(path); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        
        long startTime1 = System.nanoTime();
        MarkovWord markovWord = new MarkovWord(2); 
        runModel(markovWord, st,100, 42); 
        long endTime1 = System.nanoTime();
        
        long startTime2 = System.nanoTime();
        EfficientMarkovWord effMarkov= new EfficientMarkovWord(2);
        runModel(effMarkov,st,100, 42);
        long endTime2 = System.nanoTime();
        
        long elapsedTime1 = endTime1 - startTime1;
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Time elapsed for Markovword: " + elapsedTime1 );
        System.out.println("Time elapsed for EfficientMarkovword: " + elapsedTime2 );
    }

}
