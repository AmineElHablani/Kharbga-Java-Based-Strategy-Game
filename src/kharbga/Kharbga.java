package kharbga;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Kharbga extends JPanel{
    int boarderWidth;
    int bordaerHeight;
    public Kharbga(int width,int height){
        this.boarderWidth = width;
        this.bordaerHeight = height;
        setPreferredSize(new Dimension(this.boarderWidth,this.bordaerHeight));
        setVisible(true);
        setBackground(Color.white);
    }

    public void paint(Graphics g){
        super.paint(g);
        //g.drawLine(0,0,800,800);
        g.drawLine(100, 0, 910, 800);
        g.drawLine(0,700,700,0);
        g.drawLine(0,298,700,298);
        g.drawLine(402,0,402,700);
        g.drawRect(102,0,595,592);
    }

}
