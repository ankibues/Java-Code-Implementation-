
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>(); 
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource resource = new FileResource(filename);
         for(String line : resource.lines()){
            
            records.add(WebLogParser.parseEntry(line));
            
            }
         
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        
        for(LogEntry le: records){
            String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)){
            uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
        }
        
     public void printAllHigherThanNum(int num){
        //ArrayList<String> higherthannum = new ArrayList<String>();
        
        for(LogEntry le: records){
            int statusCode = le.getStatusCode();
            if(statusCode>num){
            System.out.println(le);
            }
        }
        
        }
        
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIPvisitsOnDay = new ArrayList<String>();
         for(LogEntry le: records){
            Date date = le.getAccessTime();
            String str= date.toString();
            String ipAddr = le.getIpAddress();
            if(str.contains(someday)){ 
                if(!uniqueIPvisitsOnDay.contains(ipAddr)){
                uniqueIPvisitsOnDay.add(ipAddr);
                    }
            }
        }
        return uniqueIPvisitsOnDay;
        
    }
    
    public int countUniqueIPsInRange(int low, int high){
        int count=0;
         ArrayList<String> uniqueIPvisitsOnDay = new ArrayList<String>();
        for(LogEntry le: records){
            int statusCode = le.getStatusCode();
            String ipAddr = le.getIpAddress();
            if(statusCode>=low && statusCode<=high){
                if(!uniqueIPvisitsOnDay.contains(ipAddr)){
                uniqueIPvisitsOnDay.add(ipAddr);
                count++;
                    }
                    
            }   
        }
        return count;  
    }
}
