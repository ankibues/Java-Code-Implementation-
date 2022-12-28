import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
            for(QuakeEntry qe: quakeData){
                if(qe.getMagnitude()>magMin){
                    answer.add(qe);
                }
        
            }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: quakeData){
            if(from.distanceTo(qe.getLocation()) < distMax){
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
    double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: quakeData){
            if(qe.getDepth() < maxDepth && qe.getDepth()> minDepth ){
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where,
                        String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: quakeData){
            if(where.equals("start") && qe.getInfo().startsWith(phrase)){
                answer.add(qe);
            }
            else if(where.equals("end") && qe.getInfo().endsWith(phrase)){
                answer.add(qe);
            }
            else if(where.equals("any") && qe.getInfo().contains(phrase)){
                answer.add(qe);
            }
        }
        
        return answer;          
                        
    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> depcheck = filterByDepth(list,-4000.0,-2000.0);
        for (QuakeEntry qe : depcheck) {
            //System.out.println(qe);
        }
        System.out.println("Found "+ depcheck.size()+ " earthquakes with this criteria");
    
    }
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
      /* 
        // testing 1st case......
        ArrayList<QuakeEntry> depcheck = filterByPhrase(list,"end","California");
        
        for (QuakeEntry qe : depcheck) {
            // System.out.println(qe);
        }
        System.out.println("Found "+ depcheck.size()+ " earthquakes that match" 
                + "California at the end");
       */         
        // testing 2nd case......
        ArrayList<QuakeEntry> phrscheck1 = filterByPhrase(list,"any","Can");
        for (QuakeEntry qe : phrscheck1) {
            //System.out.println(qe);
        }
        System.out.println("Found "+ phrscheck1.size()+ " earthquakes that match the criteria" );
                
    /*
        // testing 3rd case......
        ArrayList<QuakeEntry> phrscheck2 = filterByPhrase(list,"start","Explosion");
        for (QuakeEntry qe : phrscheck2) {
            //System.out.println(qe);
        }
        System.out.println("Found "+ phrscheck2.size()+ " earthquakes that match" 
                + "Explosion at the start");
    */
    
    }
    
    
    
    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    
    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> magcheck = filterByMagnitude(list,5.0);
        for (QuakeEntry qe : magcheck) {
            System.out.println(qe);
        }
        System.out.println("Found "+ magcheck.size()+ " earthquakes with this criteria");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        
        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);
        
        
        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        
        ArrayList<QuakeEntry> filtered = filterByDistanceFrom(list, 1000000,city);
        
        for (QuakeEntry qe : filtered) {
            System.out.println(city.distanceTo(qe.getLocation())/1000 + "\t" +  qe.getInfo());
        }
        System.out.println("Found "+ filtered.size()+ " earthquakes with this criteria");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
