/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametinhmat;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Mypc
 */
public class GameFrame extends JFrame{

    public GameFrame() throws HeadlessException {
        this.add(new GamePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
