/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametinhmat;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mypc
 */
public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    int screen_heigh=600,screen_width=600;
    int soluong = 2;
    QuanLyCell ql = new QuanLyCell(soluong, screen_width, screen_heigh);
    boolean running=false;
    public GamePanel() {
        setLayout(new GridLayout(soluong, soluong));
        this.setPreferredSize(new Dimension(screen_width, screen_heigh));
        this.setVisible(true);
        addButtonToPanel();
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
    }
    public void addButtonToPanel(){
        ArrayList<Cell> lst = ql.getLst();
        for(Cell x:lst){
            x.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkIsOher(e);
                }
            });
            this.add(x);
        }
    }
    public void startGame(){
        
    }
    public void checkIsOher(ActionEvent e){
        
        System.out.println(e.getActionCommand());
    }
}
