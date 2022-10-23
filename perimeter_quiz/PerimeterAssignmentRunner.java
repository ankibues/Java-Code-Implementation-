import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for (Point currPt : s.getPoints()) {
           num=num +1;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
         // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim/getNumPoints(s);
        
    }

    public double getLargestSide(Shape s) {
         double largestside = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // condition that if currDist> largestside, then Largestside=currDist
            if(currDist>largestside){
                largestside = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestside;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // condition that if currDist> largestside, then Largestside=currDist
            if(currX > largestX){
                largestX = currX;
            }
        }
            // Update prevPt to be currPt
            
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double lgst_perimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > lgst_perimeter){
                lgst_perimeter = length;
            }
            
        }
        return lgst_perimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double lgst_perimeter = 0.0;
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > lgst_perimeter){
                lgst_perimeter = length;
                temp = f;
            }
            
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numb= getNumPoints(s);
        System.out.println("Number of Points = " + numb);
        double avglength= getAverageLength(s);
        System.out.println("Average length = " + avglength);
        double lgsd = getLargestSide(s);
        System.out.println("Largest Side = " + lgsd);
        double lgx= getLargestX(s);
        System.out.println("Largest X = " + lgx);
    }
    
    public void testPerimeterMultipleFiles() {
        double lgp= getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + lgp);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println("File with Largest Perimeter = " + name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();

    }
}
