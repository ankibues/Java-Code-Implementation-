package EfficientSortStarterProgram;

import java.util.*;
/**
 * Write a description of class TitleAndDepthComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleAndMagnitudeComparator implements Comparator<QuakeEntry> {
          
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if (q1.getLastWord().compareTo(q2.getLastWord())==0){
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return q1.getLastWord().compareTo(q2.getLastWord());
        }
         
    }
