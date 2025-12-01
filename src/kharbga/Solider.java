package kharbga;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Solider extends JButton  implements ActionListener {
    int positionHeight;
    int positionWidth;
    String name;
    String type;
    int position;
    //Solider previousPosition;
    Integer previousPosition;
    int imageWidth = 40;
    int imageHeight = 60;

    ImageIcon image;
    Solider(int width,int height,String name,int position){
        this.positionHeight = height;
        this.positionWidth = width;
        this.name = name;
        this.position = position;
        //this.type = "solider";
        if (name.equalsIgnoreCase("soliderBrown")){
            setBackground(Color.red);
        }else if (name.equalsIgnoreCase("soliderGreen")){
            setBackground(Color.blue);
        }

        Image soliderImage = new ImageIcon(getClass().getResource("./images/"+name+".png")).getImage();
        image = new ImageIcon(soliderImage.getScaledInstance(imageWidth,imageHeight, Image.SCALE_SMOOTH));
        //JButton token = new JButton(name);
        setBounds(this.positionWidth,this.positionHeight,imageWidth,imageHeight);
        setIcon(image);
        addActionListener(this); // Adding ActionListener

        //setBorder(null);
        //setBorderPainted(false);
        //setContentAreaFilled(false);
        //setOpaque(false);
        //setBorderPainted(false);
        //setContentAreaFilled(false);
        //setFocusPainted(false);
        //setOpaque(false);


    }
    Solider(int width, int height,int position){
        this.positionHeight = height;
        this.positionWidth = width;
        //JButton token = new JButton(name);
        setBounds(this.positionWidth,this.positionHeight,40,60);
        this.image = null;
        this.type = "choice";
        this.position = position;
        this.previousPosition = null;

        addActionListener(this); // Adding ActionListener

        //setIcon(image);
        //setBorder(null);
        //setBorderPainted(false);
        //setContentAreaFilled(false);
        //setOpaque(false);
        //setBackground(Color.green);

    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }



    public int getPositionHeight() {
        return positionHeight;
    }

    public void setPositionHeight(int positionHeight) {
        this.positionHeight = positionHeight;
    }

    public int getPositionWidth() {
        return positionWidth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setPositionWidth(int positionWidth) {
        this.positionWidth = positionWidth;
    }
    public void setImage(String name){
        setIcon(null);
        Image soliderImage = new ImageIcon(getClass().getResource("./images/"+name+".png")).getImage();
        this.image = new ImageIcon(soliderImage.getScaledInstance(40,60, Image.SCALE_SMOOTH));
        setBounds(this.positionWidth,this.positionHeight,40,60);
        setIcon(image);
    }

    public Integer getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(Integer previousPosition) {
        this.previousPosition = previousPosition;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public JButton getToken() {
        return this;
    }
    int[] getBrownTeamPosition(Solider[] array){
        int[] BrownTeamPosition = new int[3];
        int index = 0;
        for(int i =0; i < array.length ; i++){
            if (array[i].getName().equalsIgnoreCase("soliderBrown")){
                BrownTeamPosition[index++] = array[i].getPosition();
            }
        }
        return BrownTeamPosition;
    }
    int[] getGreenTeamPosition(Solider[] array){
        int[] GreenTeamPosition = new int[3];
        int index = 0;
        for(int i =0; i < array.length ; i++){
            if (array[i].getName().equalsIgnoreCase("soliderGreen")){
                GreenTeamPosition[index++] = array[i].getPosition();

            }
        }
        return GreenTeamPosition;
    }

    public boolean checkWinnder(String name){
        int[] positions = new int[3];
        if(name.equalsIgnoreCase("soliderGreen")){
            positions = getGreenTeamPosition(Screen.tableOfSoliders);
        }else if(name.equalsIgnoreCase("soliderBrown")) {
            positions = getBrownTeamPosition(Screen.tableOfSoliders);
        }
        Arrays.sort(positions);
        if (((positions[2] - positions[0]) == 2) && (Screen.stepGreen >= 4) && (Screen.stepBrown >=4) && (positions[0]==0 || positions[0]==3|| positions[0]==6)){
            return true;
        } else if (((positions[1] - positions[0]) == 3) && ((positions[2] - positions[1]) == 3)){
            return true;
        }else if (((positions[1] - positions[0]) == 4) && ((positions[2] - positions[1]) == 4)){
            return true;
        }else if((positions[0] == 2) && (positions[1] ==4) && (positions[2]) == 6){
            return true;
        } else{
            return false;
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(this.getType());
        //verifier player or choice
        if ((this.getName().equalsIgnoreCase("soliderBrown")) && (Screen.currentPlayer.equalsIgnoreCase("Player 1"))) {//playerone
            //find the choices

            int myPos = this.getPosition();
            //System.out.print("choices valid:");
            for(int i: Screen.availablePositions){
                for (int j : Screen.mouvesChoice[myPos]){
                    //System.out.println(j);
                    if (j == i){
                        //System.out.print("\t"+j);;

                        if (Screen.tableOfSoliders[j].getBackground() == Color.green){
                            //System.out.println("verriféé :"+i);
                            Screen.tableOfSoliders[j].setBackground(Color.white);
                            Screen.tableOfSoliders[j].setPreviousPosition(null);

                        }else{
                            //System.out.println(i);
                            Screen.tableOfSoliders[j].setBackground(Color.green);
                            Screen.tableOfSoliders[j].setPreviousPosition(this.getPosition()); //save my position
                        }

                    }
                }
            }
        }else if ((this.getName().equalsIgnoreCase("soliderGreen")) && (Screen.currentPlayer.equalsIgnoreCase("Player 2"))){//playertwo
            //System.out.println(this.getName());
            //System.out.println("bb");
            //find the choices

            int myPos = this.getPosition();
            //System.out.print("choices valid:");
            for(int i: Screen.availablePositions){
                for (int j : Screen.mouvesChoice[myPos]){
                    //System.out.println(j);
                    if (j == i){
                        System.out.print("\t"+j);;

                        if (Screen.tableOfSoliders[j].getBackground() == Color.green){
                            //System.out.println("verriféé :"+i);
                            Screen.tableOfSoliders[j].setBackground(Color.white);
                            Screen.tableOfSoliders[j].setPreviousPosition(null);

                        }else{
                            //System.out.println(i);
                            Screen.tableOfSoliders[j].setBackground(Color.green);
                            Screen.tableOfSoliders[j].setPreviousPosition(this.getPosition()); //save my position
                        }

                    }
                }
            }

        }else if (( (!Screen.gameOver) &&(this.getName().equalsIgnoreCase("x")) && (this.getBackground() == Color.green) && this.getPreviousPosition() != null )){
            //save values

            //position li jina menha
            int oldPosition = this.getPreviousPosition();
            //position Token li jina mennou
            int[] tokenOldChoices = Screen.mouvesChoice[oldPosition];
            //position li a7na feha taw
            int actualPosition = this.getPosition();

            //l token li jina menha
            Solider previousToken = Screen.tableOfSoliders[oldPosition];

            //width w height li jina menhom
            int prev_width = previousToken.getPositionWidth();
            int prev_height = previousToken.getPositionHeight();
            //width w height li jinehom (jdod)
            int actual_width = this.getPositionWidth();
            int actual_height = this.getPositionHeight();
            String name = previousToken.getName();


            // 1 - update available positions
            for(int i = 0; i <3; i++){
                if (Screen.availablePositions[i] == actualPosition){
                    Screen.availablePositions[i] = oldPosition; //5dhit position li mchitelha w lo5ra fer8et wallet available
                }
            }
            // 2 - update el position mta3 Solider
            Screen.tableOfSoliders[oldPosition].setPosition(this.getPosition());
            Screen.tableOfSoliders[actualPosition].setPosition(oldPosition);
            //System.out.println("Solider Position :"+Screen.tableOfSoliders[oldPosition].getPosition());
            //System.out.println("this Position :"+this.getPosition());


            //3- change color & image
            for(int i : tokenOldChoices){
                if (Screen.tableOfSoliders[i].getBackground() == Color.green){
                    //na7i couleur
                    Screen.tableOfSoliders[i].setBackground(Color.white);
                    Screen.tableOfSoliders[i].setPreviousPosition(null);
                }
            }


            //4 - nbadel bi tokens (positions)(deja msavi values)
            Screen.tableOfSoliders[oldPosition].setPositionWidth(this.getPositionWidth());
            Screen.tableOfSoliders[oldPosition].setPositionHeight(this.getPositionHeight());
            Screen.tableOfSoliders[oldPosition].setLocation(actual_width, actual_height);
            this.setLocation(prev_width,prev_height);
            //badel width w height
            this.setPositionWidth(prev_width);
            this.setPositionHeight(prev_height);
            repaint();


            //5 - badel position fel table mta3 soliders
            Screen.tableOfSoliders[actualPosition]  = Screen.tableOfSoliders[oldPosition] ; //hazina player lel position li nzelna feha

            Screen.tableOfSoliders[oldPosition]  = this ; // 7attina el choice hedhi fel position li fer8et






            //voir available positions
            for (int i: Screen.availablePositions){
                System.out.println("available :"+i);
            }
            repaint();
            Screen.currentPlayer = Screen.currentPlayer.equalsIgnoreCase("Player 1")?"Player 2" : "Player 1";
            //System.out.println(Screen.currentPlayer);
            if (Screen.currentPlayer.equalsIgnoreCase("Player 1")){
                Screen.textLabel.setForeground(Color.red);
            }else{
                Screen.textLabel.setForeground(Color.blue);
            }

            Screen.textLabel.setText("Player :" +Screen.currentPlayer);
            //Screen.textLabel.setText("Player :");

            repaint();
            //check winner
            if (name.equalsIgnoreCase("soliderGreen")){
                Screen.stepGreen ++;
            }else if (name.equalsIgnoreCase("soliderBrown")) {
                Screen.stepBrown ++;
            }
            System.out.println(checkWinnder(name));
            if(checkWinnder(name)){
                if (name.equalsIgnoreCase("soliderBrown")){
                    int[] posGreen = getGreenTeamPosition(Screen.tableOfSoliders);
                    Screen.textLabel.setText("Player :" +Screen.currentPlayer+" won");

                    for(int i :posGreen){
                        Screen.tableOfSoliders[i].setImage("hosted");
                        Screen.textLabel.setForeground(Color.red);
                        //Screen.winner = "Player 1";
                        Screen.gameOver= true;
                        repaint();

                    }
                    Screen.gameOverPanel.setBounds(0, 200, 700, 200);
                    /*for (int i =3 ; i < 6;i++){
                        Screen.interfaceGame.remove(Screen.tableOfSoliders[i]);

                    }*/
                    Screen.interfaceGame.remove(Screen.tableOfSoliders[3]);
                    Screen.interfaceGame.remove(Screen.tableOfSoliders[5]);


                }else if (name.equalsIgnoreCase("soliderGreen")){
                    int[] posBrown = getBrownTeamPosition(Screen.tableOfSoliders);
                    Screen.textLabel.setText("Player :" +Screen.currentPlayer+" won");

                    for(int i :posBrown){
                        Screen.tableOfSoliders[i].setImage("hosted");
                        Screen.textLabel.setForeground(Color.red);
                        //Screen.winner = "Player 2";
                        Screen.gameOver= true;
                        repaint();

                    }
                    /*for (int i =3 ; i < 6;i++){
                        Screen.interfaceGame.remove(Screen.tableOfSoliders[i]);
                    }*/

                    Screen.gameOverPanel.setBounds(0, 200, 700, 300);
                    for(Solider s  : Screen.tableOfSoliders){
                        s.setImageWidth(70);
                        s.setImageHeight(110);
                    }
                    Screen.interfaceGame.remove(Screen.tableOfSoliders[3]);
                    Screen.interfaceGame.remove(Screen.tableOfSoliders[5]);

                    repaint();

                }
                //voice
                Main.sound.stop();
                Sound sound = new Sound();

                sound.setFile(0);
                sound.play();
            }

            //System.out.println("cc");
            int[] poss = getGreenTeamPosition(Screen.tableOfSoliders);
            for (int element : poss){
                //System.out.print("\t,"+element);
            }

        } else{
            //Screen.textLabel.setForeground(Color.yellow);
            Screen.textLabel.setText("Player :" +Screen.currentPlayer);
            repaint();
            //Screen.gameOverPanel.setBounds(0, 200, 700, 200);
            //System.exit(0);


            System.out.println("mch dawreek");
        }
    }
}

