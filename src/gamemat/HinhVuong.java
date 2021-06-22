/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemat;

/**
 *
 * @author Mypc
 */
public class HinhVuong {
    private int soLuong;
    private int chieuDaiMan;

    public HinhVuong() {
    }

    public HinhVuong(int soLuong, int chieuDaiMan) {
        this.soLuong = soLuong;
        this.chieuDaiMan = chieuDaiMan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getChieuDaiMan() {
        return chieuDaiMan;
    }

    public void setChieuDaiMan(int chieuDaiMan) {
        this.chieuDaiMan = chieuDaiMan;
    }
    public int getCanh(int x){
        return (int)chieuDaiMan/x;
    }
}
