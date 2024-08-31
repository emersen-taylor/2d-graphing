
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

/** The TriangleDrawing class creates a graphic panel for drawing
 * two triangles and one point based on the user inputs in the
 * T2DGUI class.
 * 
 * It paints graphics by overriding the paintComponent method. It
 * utilizes the repaint method so that the program can draw
 * multiple different graphs without needing to be closed and 
 * ran again by the user.
 */

public class TriangleDrawing extends JPanel {  
    
    private T2D td1 = new T2D(new Point(0,0), new Point(0,0), new Point(0,0));
    private T2D td2 = new T2D(new Point(0,0), new Point(0,0), new Point(0,0));
    private Point pd1 = new Point();
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        
        // for centering x and y coordinates on graph
        final double X_SCALE = 225d;
        final double Y_SCALE = 225d;
                
        Graphics2D g2d = (Graphics2D) g;

        // setting up x and y axis on graph
        g2d.setColor(Color.BLACK);
        g2d.drawLine(225,0,225,450);
        g2d.drawLine(0, 225, 450, 225);
        
        // drawing triangle 1
        g2d.setColor(Color.RED);
        g2d.draw(new Line2D.Double(td1.p1.getX()+X_SCALE,Y_SCALE-td1.p1.getY(),td1.p2.getX()+X_SCALE,Y_SCALE-td1.p2.getY()));
        g2d.draw(new Line2D.Double(td1.p2.getX()+X_SCALE,Y_SCALE-td1.p2.getY(),td1.p3.getX()+X_SCALE,Y_SCALE-td1.p3.getY()));
        g2d.draw(new Line2D.Double(td1.p3.getX()+X_SCALE,Y_SCALE-td1.p3.getY(),td1.p1.getX()+X_SCALE,Y_SCALE-td1.p1.getY()));
                
        // drawing triangle 2
        g2d.setColor(Color.BLUE);
        g2d.draw(new Line2D.Double(td2.p1.getX()+X_SCALE,Y_SCALE-td2.p1.getY(),td2.p2.getX()+X_SCALE,Y_SCALE-td2.p2.getY()));
        g2d.draw(new Line2D.Double(td2.p2.getX()+X_SCALE,Y_SCALE-td2.p2.getY(),td2.p3.getX()+X_SCALE,Y_SCALE-td2.p3.getY()));
        g2d.draw(new Line2D.Double(td2.p3.getX()+X_SCALE,Y_SCALE-td2.p3.getY(),td2.p1.getX()+X_SCALE,Y_SCALE-td2.p1.getY()));
                
        // drawing point 1
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(6f));
        g2d.draw(new Line2D.Double(pd1.getX()+X_SCALE,Y_SCALE-pd1.getY(),pd1.getX()+X_SCALE,Y_SCALE-pd1.getY()));
    }
    
    public void drawTriangle1(T2D t){
        td1.p1 = t.p1;
        td1.p2 = t.p2;
        td1.p3 = t.p3;
        repaint();
    }
    
    public void drawTriangle2(T2D t){
        td2.p1 = t.p1;
        td2.p2 = t.p2;
        td2.p3 = t.p3;
        repaint();
    }
    
    public void drawPoint(Point p){
        pd1.x = p.x;
        pd1.y = p.y;
        repaint();
    }
}
