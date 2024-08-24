package kharbga;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //Game.currentPlayer =   Game.currentPlayer == "Player 1"?"Player 2":"Player 1";
        //Game.textLabel.setText("Player : "+Game.currentPlayer );
        System.out.println("hello");
        if(e.getSource() == Game.green1){
            System.out.println("aaaaaaaaaaaaaaaaaaaa");
        }

    }
}
