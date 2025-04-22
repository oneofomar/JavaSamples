/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseMotionAdapter;


/**
 *
 * @author acv
 */
public class DrawingApplicationFrame extends JFrame
{

    // Create the panels for the top of the application. One panel for each
    // line and one to contain both of those panels.

    // create the widgets for the firstLine Panel.

    //create the widgets for the secondLine Panel.

    // Variables for drawPanel.

    // add status label
  
    // Constructor for DrawingApplicationFrame
    
    private final JPanel turquoise;
    private final JPanel firstLine;
    private final JPanel secondLine;
    private final String[] shapeList = {"Line", "Oval", "Rectangle"};
    private final JLabel shapeLabel;
    private final JComboBox shapeComboBox;
    private final JButton firstColor;
    private final JButton secondColor;
    private final JButton undo;
    private final JButton clear;
    private final JLabel optionsLabel;
    private final JCheckBox filled;
    private final JCheckBox gradient;
    private final JCheckBox dashed;
    private final JLabel widthLabel;
    private final JSpinner widthSpinner;
    private final JLabel lengthLabel;
    private final JSpinner lengthSpinner;
    private final DrawPanel drawingPanel;
    private final JPanel statusBar;
    private JLabel mouseLocation;
    
    private Color firstColorSelected = Color.BLACK;
    private Color secondColorSelected = Color.BLACK;
    private Stroke stroke = new BasicStroke(10.0f);
    private ArrayList<MyShapes> myShapeList = new ArrayList<MyShapes>();
    private MyShapes tempShape;
    private String shapeSelected = "Line";
    
    public DrawingApplicationFrame()
    {
        // add widgets to panels
        super("Java 2D Drawings");
        this.setLayout(new BorderLayout());
        
       
        // firstLine widgets
        turquoise = new JPanel();
        turquoise.setBackground(new Color(0,255,255));
        
        firstLine = new JPanel();
        
        shapeLabel = new JLabel("Shape:");
        firstLine.add(shapeLabel);
        
        shapeComboBox = new JComboBox<>(shapeList);
        shapeComboBox.setMaximumRowCount(3);
        firstLine.add(shapeComboBox);
        
        firstColor = new JButton("1st Color...");
        firstLine.add(firstColor);
        
        secondColor = new JButton("2nd Color...");
        firstLine.add(secondColor);
        
        undo = new JButton("Undo");
        firstLine.add(undo);
        
        clear = new JButton("Clear");
        firstLine.add(clear);
        
        // secondLine widgets
        
        secondLine = new JPanel();
        
        optionsLabel = new JLabel("Options:");
        secondLine.add(optionsLabel);
        
        filled = new JCheckBox("Filled");
        secondLine.add(filled);
        
        gradient = new JCheckBox("Gradient");
        secondLine.add(gradient);
        
        dashed = new JCheckBox("Dashed");
        secondLine.add(dashed);
        
        widthLabel = new JLabel("Line Width:");
        secondLine.add(widthLabel);
        
        widthSpinner = new JSpinner(new SpinnerNumberModel (10,1,99,1));
        secondLine.add(widthSpinner);
        
        lengthLabel = new JLabel("Dash Length:");
        secondLine.add(lengthLabel);
        
        lengthSpinner = new JSpinner(new SpinnerNumberModel (10,1,99,1));
        secondLine.add(lengthSpinner);
        
        turquoise.setLayout(new BorderLayout());
        firstLine.setBackground(new Color(0,255,255));
        secondLine.setBackground(new Color(0,255,255));
        turquoise.add(firstLine, BorderLayout.NORTH);
        turquoise.add(secondLine, BorderLayout.SOUTH);
        
        mouseLocation = new JLabel();
        drawingPanel = new DrawPanel();
        drawingPanel.setBackground(Color.WHITE);
        statusBar = new JPanel();
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusBar.setLayout(new BorderLayout());
        //mouseLocation = new JLabel("Location");
        statusBar.add(mouseLocation, BorderLayout.WEST);
        
        add(turquoise, BorderLayout.NORTH);
        
        add(drawingPanel, BorderLayout.CENTER);
        
        add(statusBar, BorderLayout.SOUTH);

        // add top panel of two panels

        // add topPanel to North, drawPanel to Center, and statusLabel to South
        
        //add listeners and event handlers
        ButtonHandler buttonHandler = new ButtonHandler();
        
        firstColor.addActionListener(buttonHandler);
        secondColor.addActionListener(buttonHandler);
        undo.addActionListener(buttonHandler);
        clear.addActionListener(buttonHandler);
        CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
        
        filled.addItemListener(checkBoxHandler);
        gradient.addItemListener(checkBoxHandler);
        dashed.addItemListener(checkBoxHandler);
        
        shapeComboBox.addItemListener(
            new ItemListener()
            {
        
                @Override
                public void itemStateChanged(ItemEvent event)
                {
                    if (event.getStateChange() == ItemEvent.SELECTED){
                        shapeSelected = shapeList[shapeComboBox.getSelectedIndex()];
                    }
                }

            }
        );
        
        
        
    }

    
    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event){
            if ("1st Color...".equals(event.getActionCommand())){
                firstColorSelected = JColorChooser.showDialog(null, "Choose first color",firstColorSelected);
                
                if (firstColorSelected == null){
                    firstColorSelected = Color.LIGHT_GRAY;
                }
            } else if ("2nd Color...".equals(event.getActionCommand())){
                
                secondColorSelected = JColorChooser.showDialog(null, "Choose second color",secondColorSelected);
                if (secondColorSelected == null){
                    secondColorSelected = Color.LIGHT_GRAY;
                }
            }
            else if ("Undo".equals(event.getActionCommand())){
                tempShape = null;
                if (myShapeList.isEmpty() == false) {
                    int index = myShapeList.size() - 1;
                    myShapeList.remove(index);
                    repaint();  
                }
                
               
            }
            else if ("Clear".equals(event.getActionCommand())) {
                myShapeList.clear();
                repaint();
            }           
        }
    }
    
    private class CheckBoxHandler implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent event){
        }
    }
 

    // Create event handlers, if needed

    // Create a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel
    {
        
        
        public DrawPanel()
        {
            MouseHandler mouseHandler = new MouseHandler();
            this.addMouseListener(mouseHandler);
            this.addMouseMotionListener(mouseHandler);
            
            this.add(mouseLocation);
            addMouseMotionListener(mouseHandler);

        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            

            //loop through and draw each shape in the shapes arraylist
            if (tempShape != null)
                tempShape.draw(g2d);
            for (MyShapes shape: myShapeList){
                shape.draw(g2d);
            }
                
            

        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {
            private Point pointA = new Point(0,0);
            private Paint paint;
            //private Stroke stroke;

            @Override
            public void mousePressed(MouseEvent event)
            {
                pointA.x = event.getX();
                pointA.y = event.getY(); 
                
                
                
            }

            @Override
            public void mouseReleased(MouseEvent event)
            {
                myShapeList.add(tempShape);
                repaint(); 
            }

            @Override
            public void mouseDragged(MouseEvent event)
            {
                mouseLocation.setText(String.format("(%d, %d)", event.getX(), event.getY()));
                Point pointB = new Point();
                pointB.x = event.getX();
                pointB.y = event.getY();
                Point newPointA = new Point();
                newPointA.x = (int) pointA.getX();
                newPointA.y = (int) pointA.getY();
                
                if(gradient.isSelected()){
                    paint = new GradientPaint(5,30,firstColorSelected,35,100,secondColorSelected, true);
                }
                else {
                    paint = firstColorSelected;
                }
                
                if (dashed.isSelected()){
                    stroke = new BasicStroke((Integer)widthSpinner.getValue(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{(Integer)lengthSpinner.getValue()}, 0);
                }
                else{
                    stroke = new BasicStroke((Integer)widthSpinner.getValue() , BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                }
                
                
                if ("Line".equals(shapeSelected)){
                    MyLine line = new MyLine(newPointA,pointB,paint, stroke);
                    tempShape = line;
                }
                else if ("Oval".equals(shapeSelected)){
                    MyOval oval = new MyOval(newPointA,pointB,paint,stroke,filled.isSelected());
                    tempShape = oval;
                
                }
                else if ("Rectangle".equals(shapeSelected)) {
                    MyRectangle rectangle = new MyRectangle(newPointA,pointB,paint,stroke,filled.isSelected());
                    tempShape = rectangle;  
                }

                repaint(); 
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {
               mouseLocation.setText(String.format("(%d, %d)", event.getX(), event.getY())); 
            }
        }

    }
}
