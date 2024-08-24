package kharbga;

import javax.swing.*;

public class Main {


    static Sound sound = new Sound();

    public static void main(String[] args) {
        //start song
        sound.setFile(1);
        sound.play();
        sound.loop();

        JFrame frame = new JFrame("My Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 850);
        frame.add(new Screen());
        frame.setVisible(true);


    }
}
