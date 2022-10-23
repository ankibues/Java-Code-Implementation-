
import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of class Parsing101 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parsing101
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Parsing101
     */
    public Parsing101()
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
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Malawi"));
        //parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Malaysia"));
        //parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Macedonia"));
        //parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Brazil"));
        
        //System.out.println(numberOfExporters(parser,"cocoa"));
        bigExporters(parser,"$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country)
    {
        String result= "";
        for(CSVRecord record:parser){
        String countryname= record.get("Country");
        if(countryname.contains(country)){
        result = countryname+ ": "+ record.get("Exports")+ " "+ record.get("Value (dollars)") ;
        }
        }
        if(result == ""){
        result = "NOT FOUND";
        }
        return result;
    
    }
    
    public String listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        String result="";
        
        for(CSVRecord record:parser){
        String Exportitems= record.get("Exports");
        if(Exportitems.contains(exportItem1) && Exportitems.contains(exportItem2)){
                        result = result + record.get("Country") + "\n";
        }
        }
    return result;
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int noex=0;
        
        for(CSVRecord record:parser){
        String Exportitems= record.get("Exports");
        if(Exportitems.contains(exportItem)){
                        noex = noex+1;
         }
        }    
        return noex;
    }
    
    public void bigExporters(CSVParser parser, String value){
         for(CSVRecord record:parser){
        String countryvalue= record.get("Value (dollars)");
        if(countryvalue.length()> value.length()){
                        String result =  record.get("Country") +  countryvalue + "\n";
                        System.out.println(result);
        }
        }
    
    
    }
    
    
}
