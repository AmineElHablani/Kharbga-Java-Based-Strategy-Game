package kharbga;

import javax.swing.*;
import java.awt.*;

public class NextStep extends JButton {
    int positionHeight;
    int positionWidth;
    NextStep(int width,int height){
        this.positionHeight = height;
        this.positionWidth = width;
        setBounds(this.positionWidth,this.positionHeight,60,70);
        setText(".");
        setBackground(Color.green);
    }
}
