/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametinhmat;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Mypc
 */
public class Cell extends JButton {

    private static final long serialVersionUID = 1L;
    int dodaicanh;
    Color color;
    boolean isOther;

    public Cell() {

    }

    public Cell(int dodaicanh, Color color) {
        this.dodaicanh = dodaicanh;
        this.color = color;
        isOther = false;
        this.setSize(dodaicanh, dodaicanh);
        this.setBackground(color);
        setActionListener(null);
        setRolloverEnabled(false);
    }

    public int getDodaicanh() {
        return dodaicanh;
    }

    public void setDodaicanh(int dodaicanh) {
        this.dodaicanh = dodaicanh;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getIsOther() {
        return isOther;
    }

    public void setIsOther(boolean isOther) {
        this.isOther = isOther;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
    
}
