import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        Location loc = new Location(39.7392, -104.9903);
        //Filter f = new MinMagFilter(4.0); 
        //Filter f= new MagnitudeFilter(3.5,4.5,"Magnitude");
        //Filter f2= new DepthFilter(-55000.0, -20000.0,"Depth");
        Filter f = new DistanceFilter(1000000,loc,"Distance");
        Filter f2 = new PhraseFilter("end","a","Phrase");
        
        ArrayList<QuakeEntry> m7  = filter(list, f);
        ArrayList<QuakeEntry> md = filter(m7,f2);
        
        for (QuakeEntry qe: md) { 
            System.out.println(qe);
        } 
        System.out.println("Quakes that match the criteria are "+ md.size()+" quakes");
    }
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);      
        /*
        for(QuakeEntry qe:list){
        System.out.println(qe);
        }
        */
        Filter maf = new MatchAllFilter();
        Filter f = new MagnitudeFilter(1.0,4.0,"Magnitude"); 
        Filter f1 = new DepthFilter(-180000,-30000,"Depth");
        Filter f2 = new PhraseFilter("any","o","Phrase");
        maf.addFilter(f);
        maf.addFilter(f1);
        maf.addFilter(f2);
        ArrayList<QuakeEntry> qee= filter(list,maf);
        for(QuakeEntry qe:qee){
        System.out.println(qe);
        }
        
        System.out.println("Quakes that match criteria are "+ qee.size()+" quakes");
        System.out.println("Filters used are"+ maf.getName() );
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);      
        /*
        for(QuakeEntry qe:list){
        System.out.println(qe);
        }
        */
        Location loc = new Location(55.7308, 9.1153);
        Filter maf = new MatchAllFilter();
        Filter f = new MagnitudeFilter(0.0,5.0,"Magnitude"); 
        Filter f1 = new DistanceFilter(3000000,loc, "Distance");
        //Filter f1 = new DepthFilter(-100000,-10000);
        Filter f2 = new PhraseFilter("any","e", "Phrase");
        maf.addFilter(f);
        maf.addFilter(f1);
        maf.addFilter(f2);
        ArrayList<QuakeEntry> qee= filter(list,maf);
        for(QuakeEntry qe:qee){
        System.out.println(qe);
        }
        
        System.out.println("Quakes that match criteria are "+ qee.size()+" quakes");
    
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
