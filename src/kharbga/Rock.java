package kharbga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Rock extends JPanel {
    private int row;
    private int column;
    private String team;

    ImageIcon img = new ImageIcon("/Images/redToken.png");
    public Rock(int row,int column,String path){
        this.row = row;
        this.column = column;
        setLocation(null);
        //labelPic =


    }

    public void paint ( Graphics g){
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
