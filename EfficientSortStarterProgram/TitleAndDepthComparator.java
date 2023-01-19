package EfficientSortStarterProgram;

import java.util.*;
/**
 * Write a description of class TitleAndDepthComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TitleAndDepthComparator
     */    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if (q1.getInfo().compareTo(q2.getInfo())==0){
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
        return q1.getInfo().compareTo(q2.getInfo());
        }
  
    }
