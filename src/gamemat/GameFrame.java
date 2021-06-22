/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemat;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Mypc
 */
public class GameFrame extends JFrame{

    public GameFrame() {
        this.add(new GamePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setVisible(true);
    }
    
}
