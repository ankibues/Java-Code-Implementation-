
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
    public ArrayList<String> IPVisitsOnDay(String someday){
         ArrayList<String> IPvisitsOnDay = new ArrayList<String>();
         for(LogEntry le: records){
            Date date = le.getAccessTime();
            String str= date.toString();
            String ipAddr = le.getIpAddress();
            if(str.contains(someday)){ 
                IPvisitsOnDay.add(ipAddr);
             }
            }
        
        return IPvisitsOnDay;
        
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
    
    public HashMap<String, Integer> countVisitsPerIP(){
        
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        
        for(LogEntry le: records){
             String ipAddr = le.getIpAddress();
             if(!count.containsKey(ipAddr)){ 
                count.put(ipAddr,1);
                }
                else {
                count.put(ipAddr,count.get(ipAddr)+1);
            }                 
        }
        return count;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> count){
        int num = 0;
        for(String w : count.keySet()){
                if(count.get(w)> num){
                num = count.get(w);
                }
            }
        return num;    
    } 
    
    public ArrayList<String> iPsMostVisits(HashMap <String, Integer> count){
         ArrayList<String> iPsMostVisits = new ArrayList<String>();
         int num_max = mostNumberVisitsByIP(countVisitsPerIP());
         
         for(String w : count.keySet()){
                if(count.get(w) == num_max){
                iPsMostVisits.add(w);
                }
            }
         return iPsMostVisits;
    
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> ipfordays = new HashMap<String, ArrayList<String>>();
        for(LogEntry le: records){
            Date date = le.getAccessTime();
            String Day= date.toString();
            String Days = Day.substring(4,10);
            ipfordays.put(Days,new ArrayList<String>());
            ArrayList<String> list = ipfordays.get(Days);
            list = IPVisitsOnDay(Days);
            ipfordays.put(Days,list);
        }  
        return ipfordays;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsForDays){
        String dayMostvisits = null;
        int size=0;
        for(String w:iPsForDays.keySet()){
            if (iPsForDays.get(w).size()>size){
                dayMostvisits = w;
                size = iPsForDays.get(w).size();
            }
        }
        return dayMostvisits;    
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> iPsForDays, String Day){
    
        ArrayList<String> iPswithMostVisits = new ArrayList<String>();
        HashMap <String, Integer> count = new HashMap <String, Integer> ();
        ArrayList<String> iPsForDay= new ArrayList<String>();
        iPsForDay = iPsForDays.get(Day);
               
        for(String str:iPsForDay ){
            
            if(!count.containsKey(str)){ 
                count.put(str,1);
                }
                else {
                count.put(str,count.get(str)+1);                
            }                
        }
        
        //iPswithMostVisits = iPsMostVisits(count); 
         int num_max = mostNumberVisitsByIP(count);
         
         for(String w : count.keySet()){
                if(count.get(w) == num_max){
                iPswithMostVisits.add(w);
                }
            }        
        return iPswithMostVisits;
    }
}
