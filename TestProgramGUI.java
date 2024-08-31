import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** The TestProgramGUI class creates a JFrame to display the test program
 * given in the project instructions.
 * 
 * A button is included that allows the user to continue to the main T2DGUI frame.
 */ 

public class TestProgramGUI extends JFrame {

    T2D t1;
    JPanel panel;
    JLabel testResultsLabel;
    JButton continueButton;
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 200;
    
    public TestProgramGUI(){
        
        setTitle("Test Program");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel = new JPanel();
        testResultsLabel = new JLabel();
        continueButton = new JButton("Continue");
        continueButton.addActionListener(e->nextWindow());
        
        // implementing T2D and Point classes as given in project instructions
        t1 = new T2D(new Point(2.5, 2), new Point(4.2, 3),new Point(5, 3.5));

        String text = "";
        text += "<html><br>T1: {{2.5,2), (4.2, 3), (5, 3.5)}, Area = " + 
                String.format("%.4f",t1.getArea()) + ", Perimeter = " + String.format("%.4f", t1.getPerimeter());
        text += "<br>t1.contains(new Point(3,3)) is " + t1.contains(new Point(3,3));
        text += "<br>t1.contains(new T2D(new Point(2.9, 2), new Point (4,1), new Point (1, 3.4)) is " + 
                t1.contains(new T2D(new Point(2.9, 2), new Point(4,1), new Point(1, 3.4))); 
        text += "<br>t1.overlaps(new T2D(new Point(2,5.5), new Point(4,-3), new Point(2,6.5)) is " + 
                t1.overlaps(new T2D(new Point(2,5.5), new Point(4,-3), new Point(2,6.5)));
        text += "<br><br>";
        testResultsLabel.setText(text);
        
        panel.add(testResultsLabel);
        panel.add(continueButton);
        add(panel);
        
        
        // specify exit operation for window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // center window on screen
        setLocationRelativeTo(null);
        
        // display the window
        setVisible(true);
        
    }
   
    /** The nextWindow method is passed an ActionEvent object by the Continue button
     * so that the user can open the T2DGUI and hide this frame.
     */ 
    
    void nextWindow(){
        this.hide();
        new T2DGUI();
    } 
}
