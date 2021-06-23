/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametinhmat;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mypc
 */
public class QuanLyCell {

    ArrayList<Cell> lst = new ArrayList<>();
    int soluong;
    int screen_width, screen_heigh;
    Random random;
    float r, g, b, a;
    float lv = (float) 0.1;

    public QuanLyCell() {
    }

    public void generateCell() {
        for (int i = 0; i < soluong*soluong; i++) {
                lst.add(new Cell(screen_width / soluong, getSameColor()));
                        System.out.println(getSameColor());

        }
        int index = random.nextInt(soluong * soluong);
        lst.get(index).setIsOther(true);
        lst.get(index).setColor(getDColor());
    }

    public void generateColor() {
        r = (float) random.nextFloat();
        g = (float) random.nextFloat();
        b = (float) random.nextFloat();
        a = (float)0.5;
    }

    public Color getSameColor() {
        return new Color(r, g, b, a);
    }

    public Color getDColor() {
        a-=lv;
        return new Color(r, g, b, a);
    }

    public ArrayList<Cell> getLst() {
            generateColor();
            generateCell();
        return lst;
    }

    public void setLst(ArrayList<Cell> lst) {
        this.lst = lst;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getScreen_width() {
        return screen_width;
    }

    public void setScreen_width(int screen_width) {
        this.screen_width = screen_width;
    }

    public int getScreen_heigh() {
        return screen_heigh;
    }

    public void setScreen_heigh(int screen_heigh) {
        this.screen_heigh = screen_heigh;
    }

    public QuanLyCell(int soluong, int screen_width, int screen_heigh) {
        random = new Random();
        this.soluong = soluong;
        this.screen_width = screen_width;
        this.screen_heigh = screen_heigh;
    }

}
