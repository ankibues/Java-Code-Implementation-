
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("short-test_log");
        log1.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        int uniqueIPs = log1.countUniqueIPs();
        System.out.println("there are "+ uniqueIPs + " unique IP addresses in total");
    
    }
    
    public void testPrinting(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog1_log");
        log1.printAllHigherThanNum(400);
    
    }
    
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        ArrayList<String> uIPOnDay = new ArrayList<String>();
        uIPOnDay= log1.uniqueIPVisitsOnDay("Sep 24");
        for(String str:uIPOnDay){
            System.out.println(str);        
        } 
    }
    
    public void testcountUniqueIPsInRange(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        System.out.println(log1.countUniqueIPsInRange(200,299));
        //System.out.println(log1.countUniqueIPsInRange(300,399));
    }
    
    public void testcountVisitsPerIP(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("short-test_log");
        HashMap<String, Integer> count = log1.countVisitsPerIP();
        
        for(String w : count.keySet()){
                System.out.println(" The IP address is "+ w + " and its count is  " + count.get(w));
            }
        
        }
    
    public void testmostNumberVisitsByIP(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        System.out.println(log1.mostNumberVisitsByIP(log1.countVisitsPerIP()));
    
    } 
    
    public void testiPsMostVisits(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        ArrayList<String> ipswithmostvisits = log1.iPsMostVisits(log1.countVisitsPerIP());
        System.out.println("IPs with most visits are as follows");
        for(String str:ipswithmostvisits){
            System.out.println(str);            
        }
        
    }
    
    public void testiPsForDays(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> ipsfordays = log1.iPsForDays();
        
        for(String key:ipsfordays.keySet()){
        System.out.println("For "+ key + " here are the following IPs: ");
        for(String str: ipsfordays.get(key)){
            System.out.println(str);
        }
        }
    }
    
    public void testdayWithMostIPVisits(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        System.out.println(log1.dayWithMostIPVisits(log1.iPsForDays()));
    }
    
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog2_log");
        String Day = "Sep 29";
        ArrayList<String> ipsmostvisted= log1.iPsWithMostVisitsOnDay(log1.iPsForDays(),Day);
        System.out.println("The most visited IPs on "+ Day + " are: ");
        for(String str: ipsmostvisted){
            System.out.println(str);
        }
    
    }
}
