/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applications;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author roman
 */
public class JButtonF extends JButton {
    public JButtonF(String s) {
        super(s);
        Font BigFont = new Font("TimesRoman", Font.BOLD, 40);
        this.setFont(BigFont);
    }
}
