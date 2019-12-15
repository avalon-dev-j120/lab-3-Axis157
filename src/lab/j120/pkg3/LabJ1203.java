
package lab.j120.pkg3;

import Applications.Calculator;
import Applications.ColorPicker;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class LabJ1203 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(400, 200));
//        frame.setLocationByPlatform(true);
        frame.setLayout(new GridLayout(2,1));
        
        MouseListener calcListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) { 
                new Calculator();
            }
        };
        
        MouseListener colorPickerListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) { 
                new ColorPicker();
            }
        };
        
        JButton Calc = new JButton("Calculator");
        Calc.addMouseListener(calcListener);
        frame.add(Calc);
        
        JButton ColorPicker = new JButton("ColorPicker");
        ColorPicker.addMouseListener(colorPickerListener);
        frame.add(ColorPicker);
        
    }
    
}
