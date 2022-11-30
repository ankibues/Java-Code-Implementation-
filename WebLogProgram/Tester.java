
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
        log1.readFile("short-test_log");
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
        log1.readFile("weblog1_log");
        ArrayList<String> uIPOnDay = new ArrayList<String>();
        uIPOnDay= log1.uniqueIPVisitsOnDay("Mar 24");
        for(String str:uIPOnDay){
            System.out.println(str);        
        } 
    }
    
    public void testcountUniqueIPsInRange(){
        LogAnalyzer log1 = new LogAnalyzer();
        log1.readFile("weblog1_log");
        System.out.println(log1.countUniqueIPsInRange(200,299));
        //System.out.println(log1.countUniqueIPsInRange(300,399));
    }
}
