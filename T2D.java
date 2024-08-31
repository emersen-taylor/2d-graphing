import java.awt.geom.Line2D;

/** The T2D class creates a 2-dimensional triangle by taking
 * three points -- it can return the area and perimeter of the 
 * triangle and evaluate whether another triangle or point is 
 * inside of or overlaps it.
 */

public class T2D {
    
    Point p1;
    Point p2;
    Point p3;
    
    // no-arg constructor
    T2D(){
        p1 = new Point(0,0);
        p2 = new Point(1,1);
        p3 = new Point(1,-1);
    }
    
    // constructor that takes three Points
    T2D(Point point1, Point point2, Point point3){
        p1 = point1;
        p2 = point2;
        p3 = point3;
    }
     
    /** The getArea method returns the area of the triangle using the formula found 
     * here: https://www.omnicalculator.com/math/area-triangle-coordinates
     */ 
    
    double getArea(){
        return .5 * Math.abs(( (p1.getX() * (p2.getY()-p3.getY())) +  (p2.getX() * (p3.getY()-p1.getY())) + (p3.getX() * (p1.getY() - p2.getY()))));
    }
    
    /** The getPerimeter method returns the perimeter of the triangle
     * by calculating the sum of length of the sides.
     * 
     * Each side's length is calculated using the distance formula. Further explanation
     * can be found here: https://www.omnicalculator.com/math/area-triangle-coordinates
     */
    double getPerimeter(){
        double side1, side2, side3;
        
        // p1 to p2
        side1 = Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2)+Math.pow(p2.getY()-p1.getY(), 2));
        
        // p2 to p3
        side2 = Math.sqrt(Math.pow(p3.getX()-p2.getX(), 2)+Math.pow(p3.getY()-p2.getY(), 2));
        
        // p3 to p1
        side3 = Math.sqrt(Math.pow(p1.getX()-p3.getX(), 2)+Math.pow(p1.getY()-p3.getY(), 2));
    
        return side1 + side2 + side3;   
    }

    /** This contains method evaluates whether a point is inside the triangle by
     * checking if the area of the triangle is equal to the sum of areas of the subtriangles
     * created by the point. 
     * 
     * It returns true if the given point is inside of this triangle.
     * 
     * See "Triangles Area Approach" at https://www.baeldung.com/cs/check-if-point-is-in-2d-triangle 
     * for a diagram and further explanation of how this method determines whether a 2d triangle contains
     * a given point.
     */
    
    boolean contains(Point p){
        // flag variable
        boolean isInside = false;
        
        // create 3 subtriangles with Point p and 2dtriangle t
        T2D subTriangle1 = new T2D(p, p2, p3);
        T2D subTriangle2 = new T2D(p1, p, p3);
        T2D subTriangle3 = new T2D(p1, p2, p);
        
        if (this.getArea() == subTriangle1.getArea() + subTriangle2.getArea() + subTriangle3.getArea())
            isInside = true;
        
        return isInside;
        
    }
   
    
    /** This contains method evaluates whether another triangle is inside of this
     * triangle by calling another overloaded contains method and checking whether
     * all three points of a given triangle are contained inside this triangle.
     * 
     * It returns true if the given triangle is inside of this triangle.
     */
    
    boolean contains(T2D t){
        return this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3);
    }
    
    /** The overlaps method checks whether another triangle overlaps this triangle
     * by using the Line2D class's intersectsLine method and checking whether the
     * sides of this triangle intersect any of the lines of the given triangle.
     * 
     * It returns true if the triangles overlap.
     */
    
    boolean overlaps(T2D t){
        boolean overlaps = false;
      
        // creating triangle 1 sides
        // side 1 = p1 to p2
        Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(),p2.getX(),p2.getY());       
        // side 2 = p2 to p3
        Line2D side2 = new Line2D.Double(p2.getX(), p2.getY(),p3.getX(),p3.getY());       
        // side 3 = p3 to p1
        Line2D side3 = new Line2D.Double(p3.getX(), p3.getY(),p1.getX(),p1.getY());        
        
        // creating triangle 2 sides
        // side 4 = t.p1 to t.p2
        Line2D side4 = new Line2D.Double(t.p1.getX(), t.p1.getY(),t.p2.getX(),t.p2.getY());       
        // side 5 = t.p2 to t.p3
        Line2D side5 = new Line2D.Double(t.p2.getX(), t.p2.getY(),t.p3.getX(),t.p3.getY());       
        // side 6 = t.p3 to t.p1
        Line2D side6 = new Line2D.Double(t.p3.getX(), t.p3.getY(),t.p1.getX(),t.p1.getY());
        
        if (side1.intersectsLine(side4) || side1.intersectsLine(side5) || side1.intersectsLine(side6))
            overlaps = true;
        
        else if (side2.intersectsLine(side4) || side2.intersectsLine(side5) || side2.intersectsLine(side6))
            overlaps = true;
        
        else if (side3.intersectsLine(side4) || side3.intersectsLine(side5) || side3.intersectsLine(side6))
            overlaps = true;
        
        return overlaps;
    }

}
