/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mypc
 */
public class GamePanel extends JPanel implements MouseListener {

    HinhVuong hv;
    int dodai = 600;
    int count = 2;
    int squareX = 0, squareY = 0;
    Random random;
    int x = 0, y = 0;
    JLabel thoiGian = new JLabel("Thời gian");
    JLabel timeLine = new JLabel("60");
    boolean running = false;
    int score = 0;
    int r = 0, gr = 0, b = 0;
    int lv = 20;
    Thread demgio;
    public GamePanel() {
        this.setPreferredSize(new Dimension(dodai, dodai));
        hv = new HinhVuong(count, dodai);
        this.setVisible(true);
        random = new Random();
        this.addMouseListener(this);
        startGame();
    }

    public void startGame() {
        running = true;
        this.add(thoiGian);
        this.add(timeLine);
        demgio =new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    int x = Integer.parseInt(timeLine.getText());
                    x--;
                    timeLine.setText(x + "");
                    if (x == 0) {
                        running = false;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        });
        demgio.start();
        getRandomColor();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public Color getSColor() {
        return new Color(r, gr, b);
    }

    public Color getDColor() {
        if (r - lv < 0) {
            r += lv;
        } else {
            r -= lv;
        }
        if (gr - lv < 0) {
            gr += lv;
        } else {
            gr -= lv;
        }
        if (b - lv < 0) {
            b += lv;
        } else {
            b -= lv;
        }
        return new Color(r, gr, b);
    }

    public void getRandomColor() {
        r = random.nextInt(254) ;
        gr = random.nextInt(254) ;
        b = random.nextInt(254) ;
    }

    public void draw(Graphics g) {
        if (running) {
            getRandomColor();
            g.setColor(getSColor());
            g.fillRect(0, 0, dodai, dodai);
            g.setColor(getDColor());
            g.fillRect(squareX, squareY, hv.getCanh(count), hv.getCanh(count));
            g.setColor(Color.white);
            for (int i = 1; i < hv.getSoLuong(); i++) {
                g.drawLine(i * hv.getCanh(count), 0, i * hv.getCanh(count), dodai);
                g.drawLine(0, i * hv.getCanh(count), dodai, i * hv.getCanh(count));
            }
        } else {
            gameOver();
            return;
        }
    }

    public void newSquare() {
        squareX = random.nextInt(count) * hv.getCanh(count);
        squareY = random.nextInt(count) * hv.getCanh(count);
    }

    public void checkHv() {
        if (x >= squareX && x <= (squareX + hv.getCanh(count)) && y >= squareY && y < (squareY + hv.getCanh(count)) && running) {
            count++;
            score++;
            hv.setSoLuong(count);
//            Graphics gr = getGraphics().create();
            newSquare();
//            draw(gr);
//            gr.dispose();
            if(count%5==0){
                lv-=3;                
            }
            this.repaint();
            System.out.println(count);            
        } else {
            running=false;
            gameOver();
           demgio.stop();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        checkHv();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public String danhGia(int score) {
        if (score < 5) {
            return "Mắt yếu";
        } else if (score < 10) {
            return "Bình thường";
        } else {
            return "Tốt";
        }

    }

    private void gameOver() {
        this.setBackground(Color.WHITE);
        Graphics g = getGraphics().create(0, 0, dodai, dodai);
        g.drawString("GameOver", 250, 300);
        g.drawString("Score: " + score, 250, 350);
        g.drawString("Đánh giá: " + danhGia(score), 250, 400);

    }

}
