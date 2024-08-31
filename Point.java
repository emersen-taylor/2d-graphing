
/** The Point class creates a point with an x and y coordinate
 * and can be used to construct other 2D shapes such as a triangle.
 */

public class Point {
    double x;
    double y;
    
    Point (){
        x = 0;
        y = 0;
    }
    
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    } 
    
   public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
     
    public void printPoint(){
        System.out.println("(" + x + "," + y + ")");
    }
}
