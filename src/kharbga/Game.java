package kharbga;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextLayout;

public class Game {
    static JLabel textLabel = new JLabel();
    static String currentPlayer = "Player 1";




    static Solider brown1 = new Solider(90,90,"soliderBrown",0);
    static Solider brown2 = new Solider(380,90,"soliderBrown",1);
    static Solider brown3 = new Solider(670,90,"soliderBrown",2);

    //middle test

    static Solider middle1 = new Solider(90,350,3);
    static Solider middle2 = new Solider(380,350,4);
    static Solider middle3 = new Solider(670,350,5);

    static Solider green1 = new Solider(90,650,"soliderGreen",6);
    static Solider green2 = new Solider(380,650,"soliderGreen",7);
    static Solider green3 = new Solider(670,650,"soliderGreen",8);

    //declaration
    static int[][] positions = {
            {90,90},
            {380,90},
            {670,90},
            {90,350},
            {380,350},
            {670,350},
            {90,650},
            {380,650},
            {670,650},
    };
    static int [] availablePositions={3,4,5};
    static Solider[] tableOfSoliders = {brown1,brown2,brown3,middle1,middle2,middle3,green1,green2,green3};
    static int[][] mouvesChoice ={
            {1,3,5},
            {0,2,4},
            {1,4,5},
            {0,4,6},
            {0,1,2,3,5,6,7,8},
            {2,4,8},
            {3,4,7},
            {4,6,8},
            {7,4,5}
    };




    public static void main(String[] args) {



        //interface
        JFrame frame = new JFrame("Kharbga");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Kharbga kharbgaGame = new Kharbga(800,800);
        //frame.add(kharbgaGame);
        //Rock token = new Rock(100,100,"images/ludo_token.webp");
        //frame.add(token);
        JPanel application = new JPanel();
        JPanel intefaceGame = new JPanel();
        application.setBackground(Color.white);
        application.setLayout(null);
        intefaceGame.setBackground(Color.white);
        frame.add(application);
       application.add(intefaceGame);
        //intefaceGame.setBounds(100,100,600,600);
        intefaceGame.add(kharbgaGame);
        //application.setComponentZOrder(intefaceGame, 0);
        application.repaint();


        //JButton b1 = new JButton("b1");
        //JButton b2 = new JButton("b2");
        //JButton b3 = new JButton("b3");
        //b1.setBounds(90,650,50,50);
        //b2.setBounds(380,650,50,50);
        //b3.setBounds(670,650,50,50);
        //green
        //green1 = new Solider(90,650,"soliderGreen");
        //green2 = new Solider(380,650,"soliderGreen");
        //green3 = new Solider(670,650,"soliderGreen");
        application.add(green1);
        application.add(green2);
        application.add(green3);
        //brown
        brown1 = new Solider(90,90,"soliderBrown",0);
        brown2 = new Solider(380,90,"soliderBrown",1);
        brown3 = new Solider(670,90,"soliderBrown",2);
        application.add(brown1);
        application.add(brown2);
        application.add(brown3);

        //middle test
        //Solider middle1 = new Solider(90,350,"invade");
        //Solider middle2 = new Solider(380,350,"invade");
        //Solider middle3 = new Solider(670,350,"invade");
        //middle1 = new Solider(90,350);
        //middle2 = new Solider(380,350);
        //middle3 = new Solider(670,350);

        //middle2.setImage("invade");
        //Solider brown3 = new Solider(90,670,"soliderBrown");
        application.add(middle1);
        application.add(middle2);
        application.add(middle3);

        application.setComponentZOrder(intefaceGame, 0);
        //intefaceGame.setComponentZOrder(kharbgaGame, 0);
        intefaceGame.setVisible(true);

        //textlabel
        //static JLabel textLabel = new JLabel();
        JPanel textPanel = new JPanel();
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial",Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Player : "+Game.currentPlayer);
        textLabel.setOpaque(true);

        //text panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel,BorderLayout.NORTH);

        textPanel.setVisible(true);
        frame.add(textPanel);
        frame.setVisible(true);
        application.setBackground(Color.black);
        intefaceGame.setBackground(Color.lightGray);
        kharbgaGame.setBackground(Color.lightGray);




        //game:
        //event listener
        MyListener listener = new MyListener();
        //add Solider to my listener
        /*green1.addActionListener(listener);
        green2.addActionListener(listener);
        green3.addActionListener(listener);


        brown1.addActionListener(listener);
        brown2.addActionListener(listener);
        brown3.addActionListener(listener);*/





    }
}
