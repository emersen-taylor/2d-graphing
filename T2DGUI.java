import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/** The T2DGUI class implements the T2D, Point, and TriangleDrawing classes and creates an interactive JFrame 
 * for the user to draw 2 triangles and 1 point and display information such as the triangles areas, perimeters, 
 * and whether the triangles contain/overlap each other and the point.
 */

public class T2DGUI extends JFrame {
        
    private JPanel mainPanel;
    private JPanel userPanel;
    private JPanel displayPanel;
    private JPanel summaryPanel;
    private JPanel testProgramPanel;
    
    private JLabel triangle1Label, triangle2Label, point1Label;
    
    private JTextField t1x1Field, t1y1Field;
    private JTextField t1x2Field, t1y2Field;
    private JTextField t1x3Field, t1y3Field;
    
    private JTextField t2x1Field, t2y1Field;
    private JTextField t2x2Field, t2y2Field;
    private JTextField t2x3Field, t2y3Field;
    
    private JTextField p1xField, p1yField;
    
    private JLabel t1x1Label, t1y1Label;
    private JLabel t1x2Label, t1y2Label;
    private JLabel t1x3Label, t1y3Label;
    
    private JLabel t2x1Label, t2y1Label;
    private JLabel t2x2Label, t2y2Label;
    private JLabel t2x3Label, t2y3Label;
    
    private JLabel p1xLabel, p1yLabel;
    
    private JButton drawButton;
    
    private JLabel summaryLabel;
    
    private TriangleDrawing triangleDrawing;
    
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 625;
    
    public T2D t1, t2;
    public Point p1;
    
    /**
     * Constructor
     */
    
    public T2DGUI(){

        setTitle("Triangle 2D Demo");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        

        // build user panel and add to west area of frame
        buildUserPanel();
        add(userPanel,BorderLayout.WEST);
        
        // build draw panel and add to center area of frame
        buildDisplayPanel();
        add(displayPanel, BorderLayout.CENTER);
        
        // build summary panel and add in the north area of frame
        buildSummaryPanel();
        add(summaryPanel,BorderLayout.NORTH);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void buildUserPanel(){
        
        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel,BoxLayout.Y_AXIS));
        Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        userPanel.setBorder(b);
        
        t1x1Field = new JTextField(5);
        t1y1Field = new JTextField(5);
        t1x2Field = new JTextField(5);
        t1y2Field = new JTextField(5);
        t1x3Field = new JTextField(5);
        t1y3Field = new JTextField(5);
        
        t2x1Field = new JTextField(5);
        t2y1Field = new JTextField(5);
        t2x2Field = new JTextField(5);
        t2y2Field = new JTextField(5);
        t2x3Field = new JTextField(5);
        t2y3Field = new JTextField(5);
        
        p1xField = new JTextField(5);
        p1yField = new JTextField(5);
        
        triangle1Label = new JLabel("Triangle 1");
        triangle1Label.setForeground(Color.RED);
        triangle2Label = new JLabel("Triangle 2");
        triangle2Label.setForeground(Color.BLUE);
        point1Label = new JLabel("Point 1");
        point1Label.setForeground(Color.BLACK);
        
        t1x1Label = new JLabel("x1: ");
        t1y1Label = new JLabel("y1: ");
        t1x2Label = new JLabel("x2: ");
        t1y2Label = new JLabel("y2: ");
        t1x3Label = new JLabel("x3: ");
        t1y3Label = new JLabel("y3: ");
        
        t2x1Label = new JLabel("x1: ");
        t2y1Label = new JLabel("y1: ");
        t2x2Label = new JLabel("x2: ");
        t2y2Label = new JLabel("y2: ");
        t2x3Label = new JLabel("x3: ");
        t2y3Label = new JLabel("y3: ");
        
        p1xLabel = new JLabel("x: ");
        p1yLabel = new JLabel("y: ");
        
        drawButton = new JButton("Draw!");
        
        drawButton.addActionListener(new DrawButtonListener());


        userPanel.add(triangle1Label);
        userPanel.add(buildXYPanel(t1x1Label,t1y1Label,t1x1Field,t1y1Field));
        userPanel.add(buildXYPanel(t1x2Label,t1y2Label,t1x2Field,t1y2Field));
        userPanel.add(buildXYPanel(t1x3Label,t1y3Label,t1x3Field,t1y3Field));
        
        userPanel.add(triangle2Label);
        userPanel.add(buildXYPanel(t2x1Label,t2y1Label,t2x1Field,t2y1Field));
        userPanel.add(buildXYPanel(t2x2Label,t2y2Label,t2x2Field,t2y2Field));
        userPanel.add(buildXYPanel(t2x3Label,t2y3Label,t2x3Field,t2y3Field));
        
        userPanel.add(point1Label);
        userPanel.add(buildXYPanel(p1xLabel,p1yLabel,p1xField,p1yField));
        
        userPanel.add(drawButton);
   
    }
 
    /** The buildXYPanel is a private method that helps the buildUserPanel method by returning a JPanel
     * that contains JLabels and JTextFields for the user to input x and y coordinates of points
     */
    
    private JPanel buildXYPanel(JLabel xLabel, JLabel yLabel, JTextField xField, JTextField yField){
        JPanel xyPanel = new JPanel();
        
        xyPanel.add(xLabel);
        xyPanel.add(xField);
        xyPanel.add(yLabel);
        xyPanel.add(yField);
        
        return xyPanel;
    }
    
    private void buildDisplayPanel(){
        displayPanel = new JPanel();
        Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        displayPanel.setBorder(b);
        triangleDrawing = new TriangleDrawing();
        triangleDrawing.setPreferredSize(new Dimension(450,450));
        displayPanel.add(triangleDrawing);
    }
    
    private void buildSummaryPanel(){
        summaryPanel = new JPanel();
        Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        summaryPanel.setBorder(b);
        summaryLabel = new JLabel("<html>------------------------------------------------------------------------------------------------------------------------------------------------"
                + "<br>Enter the coordinates for two triangles and one point in the text boxes "
                + "on the left side of the window.<br>Click \"Draw\" to display the triangles and point on "
                + "the graph below."
                + "<br>The range for X and Y values is [-225, 225].<br>"
                + "------------------------------------------------------------------------------------------------------------------------------------------------");
        summaryPanel.add(summaryLabel);
    }
    
    /** The DrawButtonListener private ActionListener class creates Triangles and Points based off the user's input
     * in the JTextFields and passes the Triangles/Points to the TriangleDrawing class's drawing methods so that
     * they are displayed in the TriangleDrawing panel.
     * 
     * The DrawButtonListener catches any NumberFormatExceptions that are thrown if the user clicks the Draw button while
     * some of the text fields are not filled in. It handles the exception by display a JOptionPane message instructing
     * the user to fill in all text fields before clicking the Draw button.
     */
    
    private class DrawButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e){
            
            try{
                // create triangle 1 based off user input 
                t1 = new T2D(new Point(Double.parseDouble(t1x1Field.getText()),Double.parseDouble(t1y1Field.getText())),
                                    new Point(Double.parseDouble(t1x2Field.getText()),Double.parseDouble(t1y2Field.getText())),
                                    new Point(Double.parseDouble(t1x3Field.getText()),Double.parseDouble(t1y3Field.getText())));

                // create triangle 2 based off user input
                t2 = new T2D(new Point(Double.parseDouble(t2x1Field.getText()),Double.parseDouble(t2y1Field.getText())),
                                    new Point(Double.parseDouble(t2x2Field.getText()),Double.parseDouble(t2y2Field.getText())),
                                    new Point(Double.parseDouble(t2x3Field.getText()),Double.parseDouble(t2y3Field.getText())));

                // create point 1 based off user input
                p1 = new Point(Double.parseDouble(p1xField.getText()),Double.parseDouble(p1yField.getText()));

                // writing summary of input and if they're "contained"
                String text = "<html>";

                text += "Point 1: (" + p1.getX() + ", " + p1.getY() + ")";
                text += "<br>Triangle 1: (" + t1.p1.getX() + ", " + t1.p1.getY() + "), (" +
                                            t1.p2.getX() + ", " + t1.p2.getY() + "), (" +
                                            t1.p3.getX() + ", " + t1.p3.getY() + "), Area = " +
                                            String.format("%.2f", t1.getArea()) + " , Perimeter = " + 
                                            String.format("%.2f",t1.getPerimeter());
                text += "<br>Triangle 2: (" + t2.p1.getX() + ", " + t2.p1.getY() + "), (" +
                                            t2.p2.getX() + ", " + t2.p2.getY() + "), (" +
                                            t2.p3.getX() + ", " + t2.p3.getY() + "), Area = " +
                                            String.format("%.2f",t2.getArea()) + ", Perimeter = " + 
                                            String.format("%.2f",t2.getPerimeter());

                if (t1.contains(p1)){
                    text += "<br>Point 1 is inside triangle 1. Point 1 is ";
                    if (t2.contains(p1))
                        text += "inside of triangle 2.";
                    else
                        text += "not inside of triangle 2.";
                }
                else{
                    text += "<br>Point 1 is not inside of triangle 1. Point 1 is ";
                    if (t2.contains(p1))
                        text += "inside of triangle 2.";
                    else
                        text += "not inside of triangle 2.";
                }

                if (t1.contains(t2))
                    text += "<br>Triangle 2 is inside of triangle 1";
                else if (t2.contains(t1))
                    text += "<br>Triangle 1 is inside of triangle 2.";
                else if (t1.overlaps(t2))
                    text += "<br>Triangle 2 overlaps triangle 1.";
                else
                    text += "<br>Triangle 2 is outside of triangle 1.";

                // add text summary to label that's being added to panel
                summaryLabel.setText(text);

                // draw triangles and point based off user input in text fields
                triangleDrawing.drawTriangle1(t1);
                triangleDrawing.drawTriangle2(t2);
                triangleDrawing.drawPoint(p1);
            }
            
            catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"Please enter values for every field before clicking \"Draw\"");
            }
 
        }
    }

}


