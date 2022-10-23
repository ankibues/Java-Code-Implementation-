import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class Parsing103 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parsing103
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Parsing103
     */
    public Parsing103()
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
    public double avgTempInFile(CSVParser parser)
    {
        double TempSum= 0.0;
        double count = 0.0;
        for(CSVRecord record:parser){
        if(record.get("TemperatureF").equals("-9999")){break;}
        TempSum = TempSum + Double.parseDouble(record.get("TemperatureF"));
        count = count+ 1.0;
        }
        return TempSum/count;   
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Averge temperature in file is "+ avgTempInFile(parser) );
        
    
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        double TempSum= 0.0;
        double count = 0.0;
        for(CSVRecord record:parser){
        if(record.get("TemperatureF").equals("-9999")){break;}
        if(record.get("Humidity").equals("N/A")){break;}
        if( Integer.parseInt(record.get("Humidity")) >= value)
        {
        TempSum = TempSum + Double.parseDouble(record.get("TemperatureF"));
        count = count + 1.0;
        }     
        }
        
        if(TempSum == 0.0 && count == 0.0){return 0.0;}
        else{
        return TempSum/count;
        }   
    }
    
    public void testaverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double result= averageTemperatureWithHighHumidityInFile(parser,80);
        if(result== 0.0){
        System.out.println(" No temperatures with that humidity " );
        }
        else 
        {
        System.out.println("Averge temperature in file is "+ result );   
        }
    
    }
}
