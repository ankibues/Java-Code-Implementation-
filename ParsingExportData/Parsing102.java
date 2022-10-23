import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of class Parsing102 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parsing102
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Parsing102
     */
    public Parsing102()
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
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord LowestTemp= null;
        for(CSVRecord record:parser){
        
        if(LowestTemp==null){
            LowestTemp = record;        
        }
        else
        {
         Double currenttemp= Double.parseDouble(record.get("TemperatureF"));
         Double Lowesttemp= Double.parseDouble(LowestTemp.get("TemperatureF"));
         
         if(record.get("TemperatureF").equals("-9999")){ break;}
         
         if(currenttemp< Lowesttemp){
            LowestTemp = record;
            }     
        }
        }
        return LowestTemp;   
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record= coldestHourInFile(parser);
        System.out.println("On " + record.get("DateUTC") +" ,the coldest temperature was "+ record.get("TemperatureF") );
        
    
    }
    
    public File fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        File f_lowest = null;
        for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        CSVRecord current = coldestHourInFile(fr.getCSVParser());
        
        if(f_lowest==null){
            f_lowest = f;        
        }
        else
        {
         Double currenttemp= Double.parseDouble(current.get("TemperatureF"));
         FileResource ff_lowest = new FileResource(f_lowest);
         Double Lowesttemp= Double.parseDouble(coldestHourInFile(ff_lowest.getCSVParser()).get("TemperatureF"));
         
         if(current.get("TemperatureF").equals("-9999")){ break;}
         
         if(currenttemp< Lowesttemp){
            f_lowest = f;
            }     
        }      
        
        }
        return f_lowest;
        }
        
        public void testFileWithColdestTemperature(){
        File F = fileWithColdestTemperature();
        System.out.println("Coldest day was in file "+ F.getName());
        FileResource fr = new FileResource(F);
        CSVParser parser = fr.getCSVParser();
        CSVRecord record= coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + record.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were: \n");
        parser = fr.getCSVParser();
        for(CSVRecord rec:parser){
        System.out.println(rec.get("DateUTC") + " " + rec.get("TemperatureF") );
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord LowestHum= null;
        for(CSVRecord record:parser){
        
        if(LowestHum==null){
            LowestHum = record;        
        }
        else
        {
         if(record.get("Humidity").equals("N/A")){ break;}
         Double currenthum= Double.parseDouble(record.get("Humidity"));
         Double Lowesthum= Double.parseDouble(LowestHum.get("Humidity"));     
         
         if(currenthum< Lowesthum){
            LowestHum = record;
            }     
        }
        }
        return LowestHum;   
    }
    
    public void testlowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record= lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was "+ record.get("Humidity")+  " at " + record.get("DateUTC"));
        
    
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord LowestHum= null;
        
        for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
        
        if(LowestHum==null){
            LowestHum = current;        
        }
        else
        {
         Double currenthum = Double.parseDouble(current.get("Humidity"));
         Double Lowesthum= Double.parseDouble(LowestHum.get("Humidity"));      
         
         if(currenthum< Lowesthum){
            LowestHum = current;
            }     
        }      
        
        }
        return LowestHum;
        }
        
        public void testlowestHumidityInManyFiles(){
        CSVRecord record = lowestHumidityInManyFiles();       
        System.out.println("Lowest humidity was "+ record.get("Humidity")+  " at " + record.get("DateUTC"));
        
    
    }
    
}
        

