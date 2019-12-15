/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applications;

import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author roman
 */
public class ColorPicker extends JFrame {
    static final int WIDTH = 600;
    static final int HEIGHT = 300;
    
    JSlider redSlider = new JSlider(0, 255, 125);
    JSlider greenSlider = new JSlider(0, 255, 125);
    JSlider blueSlider = new JSlider(0, 255, 125);
    
    JLabel redLabel = new JLabel("Red:");
    JLabel greenLabel = new JLabel("Green:");
    JLabel blueLabel = new JLabel("Blue:");
    JLabel rL = new JLabel();
    JLabel gL = new JLabel();
    JLabel bL = new JLabel();
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    int r = 125;
    int g = 125;
    int b = 125;
    
    public ColorPicker() {
        setSize(WIDTH, HEIGHT);
        setTitle("ColorPicker");
        setLocationByPlatform(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new GridLayout());
        panel1.setPreferredSize(new Dimension(WIDTH/3,HEIGHT));
        add(panel1,WEST);
        add(panel2, CENTER);
        panel1.setBackground(Color.LIGHT_GRAY);
        
        JPanel square = new JPanel();
        square.setPreferredSize(new Dimension(150, 150));
        String redHex = Integer.toHexString(r);
        String greenHex = Integer.toHexString(g);
        String blueHex = Integer.toHexString(b);
        String hexColor = "#" + redHex + greenHex + blueHex;
        square.setToolTipText(hexColor);
        StringSelection stringSelection = new StringSelection(hexColor);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
        
        JPanel colorChange = new JPanel(new GridLayout(6,1));
        
        ChangeListener onColorsChange = new ChangeListener() {
        @Override
            public void stateChanged(ChangeEvent evt) {
                r = redSlider.getValue();
                g = greenSlider.getValue();
                b = blueSlider.getValue();
                square.setBackground(new Color(r,g,b));
                String redHex = Integer.toHexString(r);
                String greenHex = Integer.toHexString(g);
                String blueHex = Integer.toHexString(b);
                if (r<17) redHex = "0" + redHex;
                if (g<17) greenHex = "0" + greenHex;
                if (b<17) blueHex = "0" + blueHex;
                String hexColor = "#" + redHex + greenHex + blueHex;
                square.setToolTipText(hexColor);
                StringSelection stringSelection = new StringSelection(hexColor);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                rL.setText("Red:"+Integer.toString(redSlider.getValue()));
                gL.setText("Red:"+Integer.toString(greenSlider.getValue()));
                bL.setText("Red:"+Integer.toString(blueSlider.getValue()));
            }
        };
        panel2.add(colorChange);
        
        colorChange.add(redLabel);
        colorChange.add(redSlider);
        redSlider.addChangeListener(onColorsChange);
        redSlider.setPaintLabels(true);
        redSlider.setPaintTicks(true);
        redSlider.setMajorTickSpacing(25);
        redSlider.setSnapToTicks(true);
        redSlider.setMajorTickSpacing(5);
        
        colorChange.add(greenLabel);
        colorChange.add(greenSlider);
        greenSlider.addChangeListener(onColorsChange);
        greenSlider.setPaintLabels(true);
        greenSlider.setPaintTicks(true);
        greenSlider.setSnapToTicks(true);
        greenSlider.setMajorTickSpacing(25);
        greenSlider.setMajorTickSpacing(5);
        
        colorChange.add(blueLabel);
        colorChange.add(blueSlider);
        blueSlider.addChangeListener(onColorsChange);
        blueSlider.setPaintLabels(true);
        blueSlider.setPaintTicks(true);
        blueSlider.setSnapToTicks(true);
        blueSlider.setMajorTickSpacing(25);
        blueSlider.setMajorTickSpacing(5);
        
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.weightx = 150;
        constraints.gridwidth = 3;
        constraints.gridy = 0;
        constraints.gridx = 0;
        panel1.add(square, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.gridx = 0;
        panel1.add(rL, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = 2;
        constraints.gridx = 0;
        panel1.add(gL, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.gridx = 0;
        panel1.add(bL, constraints);
        
    }
}
