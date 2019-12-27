/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applications;

import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author roman
 */
public class Calculator extends JFrame {
    static final int WIDTH = 400;
    static final int HEIGHT = 600;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonCE;
    private JButton buttonPoint;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMult;
    private JButton buttonDev;
    private JButton buttonEq;
    
    private JLabel label;
    
    public Calculator() {
        setSize(WIDTH, HEIGHT);
        setTitle("Calculator");
        setLocationByPlatform(true);
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(WIDTH, 80));
        panel1.setVisible(true);
        panel1.setBackground(Color.red);
        add(panel1, NORTH);
        label = new JLabel("");
        label.setPreferredSize(new Dimension(WIDTH, 50));
        label.setFont(new Font("TimesRoman", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel1.add(label);
        
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel2.setVisible(true);
        panel3.setVisible(true);
        add(panel2,CENTER);
        add(panel3,SOUTH);
        panel2.setLayout(new GridLayout(4,4,0,0));
        panel3.setLayout(new GridLayout(1,1,0,0));
        panel3.setPreferredSize(new Dimension(WIDTH,50));
        panel3.setBackground(Color.YELLOW);
        
        panel2.add(button7 = new JButtonF("7"));
        panel2.add(button8 = new JButtonF("8"));
        panel2.add(button9 = new JButtonF("9"));
        panel2.add(buttonPlus = new JButtonF("+"));
        panel2.add(button4 = new JButtonF("4"));
        panel2.add(button5 = new JButtonF("5"));
        panel2.add(button6 = new JButtonF("6"));
        panel2.add(buttonMinus = new JButtonF("-"));
        panel2.add(button1 = new JButtonF("1"));
        panel2.add(button2 = new JButtonF("2"));
        panel2.add(button3 = new JButtonF("3"));
        panel2.add(buttonMult = new JButtonF("*"));
        panel2.add(buttonCE = new JButtonF("CE"));
        panel2.add(button0 = new JButtonF("0"));
        panel2.add(buttonPoint = new JButtonF("."));
        panel2.add(buttonDev = new JButtonF("/"));
        
        panel3.add(buttonEq = new JButtonF("="));
        
        double[] buffer = new double[2];
        String[] sign = new String[1];
        sign[0] = "";
        int[] start = new int[1];
        start[0] = 1;
        int[] mark = new int[1];
        
        MouseListener buttonMouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(start[0] == 1) {
                    JButton button = (JButton) e.getComponent();
                    label.setText(label.getText() + button.getText());
                    buffer[0] = Double.parseDouble(label.getText());
                }
                else if(start[0] == 0) {
                    JButton button = (JButton) e.getComponent();
                    label.setText(label.getText() + button.getText());
                    buffer[1] = Double.parseDouble(label.getText());
                    mark[0] = 1;
                }
                else if (start[0] == -1) {
                    label.setText("");
                    JButton button = (JButton) e.getComponent();
                    label.setText(label.getText() + button.getText());
                    buffer[1] = Double.parseDouble(label.getText());
                    start[0] = 0;
                    mark[0] = 1;
                }
                
            }
            
        };
        button0.addMouseListener(buttonMouse);
        button1.addMouseListener(buttonMouse);
        button2.addMouseListener(buttonMouse);
        button3.addMouseListener(buttonMouse);
        button4.addMouseListener(buttonMouse);
        button5.addMouseListener(buttonMouse);
        button6.addMouseListener(buttonMouse);
        button7.addMouseListener(buttonMouse);
        button8.addMouseListener(buttonMouse);
        button9.addMouseListener(buttonMouse);
        buttonPoint.addMouseListener(buttonMouse);
        
        MouseListener buttonCEMouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                label.setText("");
                buffer[0] = 0;
                buffer[1] = 0;
                start[0] = 1;
                sign[0] = "";
                mark[0] = 0;
            }
           
        };
        buttonCE.addMouseListener(buttonCEMouse);
        
        MouseListener buttonSign = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton button = (JButton) e.getComponent();
                if (button.getText() != "=") {
//                    sign[0] = button.getText();
                    switch(sign[0]) {
                            case("+"):
                                buffer[0] = buffer[0] + buffer[1];
                                break;
                            case("-"):
                                buffer[0] = buffer[0] - buffer[1];
                                break;
                            case("*"):
                                if(mark[0] == 0) {
                                    buffer[0] = buffer[0];
                                    break;
                                }
                                else {
                                    buffer[0] = buffer[0] * buffer[1];
                                    break;
                                }
                            case("/"):
                                if(mark[0] == 0) {
                                    buffer[0] = buffer[0];
                                    break;
                                }
                                else {
                                    buffer[0] = buffer[0] / buffer[1];
                                    break;
                                }
                    }
                    start[0] = -1;
                    mark[0] = 0;
                }
                else {
                    switch(sign[0]) {
                            case("+"):
                                buffer[0] = buffer[0] + buffer[1];
                                break;
                            case("-"):
                                buffer[0] = buffer[0] - buffer[1];
                                break;
                            case("*"):
                                buffer[0] = buffer[0] * buffer[1];
                                break;
                            case("/"):
                                buffer[0] = buffer[0] / buffer[1];
                                break;
                    }
                    buffer[1] = 0;
                    start[0] = 1;
                }
                sign[0] = button.getText();
                label.setText(Double.toString(buffer[0]));
                
            }
        };
        buttonPlus.addMouseListener(buttonSign);
        buttonMinus.addMouseListener(buttonSign);
        buttonMult.addMouseListener(buttonSign);
        buttonDev.addMouseListener(buttonSign);
        buttonEq.addMouseListener(buttonSign);
    }
    
}
