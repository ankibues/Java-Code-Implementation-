import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class assignment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class assignment
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class assignment
     */
    public assignment()
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
    public void totalBirths(FileResource fr)
    {
        int totalBirths = 0;
        int totalboyz = 0;
        int totalgals = 0;
        for(CSVRecord rec:fr.getCSVParser(false)) {
        int numBorn = Integer.parseInt(rec.get(2));
        if(rec.get(1).equals("F")){
        totalgals = totalgals + 1;
        }
        if(rec.get(1).equals("M")){
        totalboyz= totalboyz + 1;
        }
        totalBirths = totalBirths+ 1;      
        }
        System.out.println("total births= "+ totalBirths +" out of which, "+ totalboyz +" are boys and "+ totalgals+" are girls");
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender){
        int rank= -1;
        int rank_f=0;
        int rank_m=0;
        FileResource fr = new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false)) {
        
        if(rec.get(1).equals(gender)){
            rank_f += 1;
            if(rec.get(0).equals(name)){
                rank= rank_f;
                break;
            }
        }
        
        if(rec.get(1).equals(gender)){
            rank_m += 1;
            if(rec.get(0).equals(name)){
                rank= rank_m;
                break;
            }
        }     
        }
        return rank;
    }

    public void testgetRank(){
        String name= "Frank";
        int year= 2012;
        String gender="M";        
        System.out.println("the rank for  "+ name +" with gender "+ gender +" is "+ getRank(year,name,gender));
    }
    public String getName(int year, int rank, String gender){
        String name ="NO NAME";
        int rank_f=0;
        int rank_m=0;
        FileResource fr = new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false)) {
        
        if(rec.get(1).equals(gender)){
            rank_f += 1;
            if(rank==rank_f){
                name = rec.get(0);
                break;
            }
        }
        
        if(rec.get(1).equals(gender)){
            rank_m += 1;
            if(rank==rank_m){
                name = rec.get(0);
                break;
            }
        }     
        }
        return name ;    
    }
    
    public void testgetName(){
        int rank= 450;
        int year= 1982;
        String gender="M";        
        System.out.println("the name for rank  "+ rank +" with gender "+ gender +" is "+ getName(year,rank,gender));
    }
    
    void whatIsNameInYear(String name, int year,int newYear,String gender){
        int rank= getRank(year,name,gender);
        String new_name= getName(newYear,rank,gender);
        if(gender=="F"){
            System.out.println(name + "born in "+ year +" would be "+ new_name +" if she was born in "+ newYear);
        }
        else{
            System.out.println(name + "born in "+ year +" would be "+ new_name +" if he was born in "+ newYear);
        }
    }
    
    void test(){
        String name="Owen";
        int year = 1974;
        int newYear= 2014;
        String gender= "M";
        whatIsNameInYear(name,year,newYear,gender);   
    }
    public int getRank2(FileResource fr, String name, String gender){
        int rank= -1;
        int rank_f_m=0;
               
        for(CSVRecord rec:fr.getCSVParser(false)) {
        
        if(rec.get(1).equals(gender)){
            rank_f_m =rank_f_m + 1;
            if(rec.get(0).equals(name)){
                rank= rank_f_m;
                break;
            }
        }
             
        }
        return rank;
    }
    int yearOfHighestRank(String name, String gender){
        int minrank= Integer.MAX_VALUE;
        File f_lowest=null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        if(getRank2(fr,name,gender)==-1){break;}
        //if(getRank2(fr,name,gender)== minrank){break;}
        if(getRank2(fr,name,gender)< minrank){
        f_lowest= f;
        minrank=getRank2(fr,name,gender);
        }
        }
        if(f_lowest==null){
        return -1;
        }
        else{
        String file= f_lowest.getName();
        int value = Integer.parseInt(file.replaceAll("[^0-9]", ""));
        return value;
        }
    }
    void test2(){
        String name= "Genevieve";
        String gender="F";
        System.out.println("The year for which "+ name+ " has the highest rank is " + yearOfHighestRank(name,gender));
        System.out.println("Note if the value is -1, that means the name and gender were not in the list");
    }
    
    double getAverageRank(String name, String gender){
        double avgRank;
        double num = 0.0;
        int rank= 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        if(getRank2(fr,name,gender)==-1){break;}
        rank = rank+ getRank2(fr,name,gender);
        num = num + 1;
        }
        if(rank==0){
        return -1;
        }
        else{
        avgRank= rank/num;     
        return avgRank;
        }
    }
    
    void testavgRank(){
        String name= "Susan";
        String gender="F";
        System.out.println("Average rank for "+ name + " with gender "+ gender + " is " + getAverageRank(name,gender));
        
        String name1= "Robert";
        String gender1="M";
        System.out.println("Average rank for "+ name1 + " with gender "+ gender1 + " is " + getAverageRank(name1,gender1));
        
    }
    
    int getTotalBirthsRankedHigher(int year, String name, String gender){
        FileResource fr = new FileResource();
        int births=0;
        int ranktocompare= getRank2(fr,name,gender);
        int rank= 0;
        for(CSVRecord rec:fr.getCSVParser(false)) {
        
        if(rec.get(1).equals(gender)){
            rank = rank +  1;
            if(ranktocompare>rank){
                births = births + Integer.parseInt(rec.get(2));
            }
        }         
        }
        return births;
    }
    
    void testgetTotalBirthsRankedHigher(){
        int year= 1990;
        String name= "Drew";
        String gender = "M";
        System.out.println("Total births ranked higher than"+ name + " are " + getTotalBirthsRankedHigher(year,name,gender));
    
    
    }
    
    String reverse(String s){
    String res= "";
    
    for(int k=0; k<s.length();k +=1)
    {
     res= s.charAt(k) + res;
    }
    return res;
    }
    
    void testReversingstring(){
            String str= "Draw, O Caesar, erase a coward";
            System.out.println(" The reverse of "+ str + " is " + reverse(str));
    }
    
    }
    
