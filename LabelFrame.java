package pizza.servings.calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LabelFrame extends JFrame {
    private final JLabel title;
    private final JLabel labelPrompt;
    private final JTextField textField;
    private final JPanel lineTwo;
    private final JButton calcButt;
    private final JLabel finalServings;
    
    public LabelFrame() {
        super("Pizza Servings Calculator");
        this.setLayout(new GridLayout(4,1));
        
        title = new JLabel("Pizza Servings Calculator");
        title.setForeground(Color.RED);
        title.setFont(new Font("Serif", Font.BOLD, 26));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        labelPrompt = new JLabel("Enter the size of the pizza in inches:");
        
        textField = new JTextField(4);
        lineTwo = new JPanel();
        lineTwo.add(labelPrompt);
        lineTwo.add(textField);
        add(lineTwo);
        
        calcButt = new JButton("Calculate Servings");
        add(calcButt);
        
        finalServings = new JLabel();
        add(finalServings);
        
        ButtonHandler handler = new ButtonHandler();
        calcButt.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            double size = Double.parseDouble(textField.getText());
            double servings = (size/8) * (size/8);
            
            finalServings.setText(String.format("A %d %s%.2f people.", (int)size, "inch pizza will serve ", servings));
            finalServings.setHorizontalAlignment(JLabel.CENTER);
        }
    }
}
