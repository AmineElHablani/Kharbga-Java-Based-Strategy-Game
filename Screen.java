package kharbga;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Screen extends JPanel {

    static JLabel textLabel = new JLabel();
    static String currentPlayer = "Player 1";
    static JPanel interfaceGame;
    static int stepGreen =0;
    static int stepBrown =0;
    static boolean gameOver;
    static JPanel gameOverPanel;


    static Solider brown1 = new Solider(40,40,"soliderBrown",0);
    static Solider brown2 = new Solider(320,40,"soliderBrown",1);
    static Solider brown3 = new Solider(610,40,"soliderBrown",2);

    //middle test

    static Solider middle1 = new Solider(40,320,"x",3);
    static Solider middle2 = new Solider(320,320,"x",4);
    static Solider middle3 = new Solider(610,320,"x",5);

    static Solider green1 = new Solider(40,600,"soliderGreen",6);
    static Solider green2 = new Solider(320,600,"soliderGreen",7);
    static Solider green3 = new Solider(610,600,"soliderGreen",8);

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
            {1,3,4},
            {0,2,4},
            {1,4,5},
            {0,4,6},
            {0,1,2,3,5,6,7,8},
            {2,4,8},
            {3,4,7},
            {4,6,8},
            {7,4,5}
    };

    private Image backgroundImage;

    public Screen() {
        setLayout(null); // Use null layout for manual positioning

        // Load the background image
        URL imageUrl = getClass().getResource("./Images/war_map2.jpg");
        if (imageUrl != null) {
            backgroundImage = new ImageIcon(imageUrl).getImage();
        } else {
            System.err.println("Error: Could not load background image");
        }
        //JPanel interfaceGame = new JPanel() {

        // Create the interfaceGame panel
        interfaceGame = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    // Draw the background image
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        interfaceGame.setLayout(null); // Set null layout for manual positioning
        interfaceGame.setBounds(100, 100, 700, 700);


        // Add interfaceGame panel
        add(interfaceGame);


        addButtons(interfaceGame);
        // Create and configure textLabel
        //JLabel textLabel = new JLabel();
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Player : " + Game.currentPlayer);
        textLabel.setOpaque(true);

        // Create textPanel and add textLabel to it
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.NORTH);
        setLayout(new BorderLayout());

        // Add textPanel to MyPanel
        add(textPanel);
        ///////////////////////::

        //JPanel np = new JPanel();
        //np.setBounds(200, 200, 300, 300);
        //interfaceGame.add(np);

        // Create the "Game Over" label and center it
        // Create a dark gray colored panel for text
        // Create the gameOverPanel
        // Create the gameOverPanel
        // Create the gameOverPanel
        // Call the function to create and add gameOverPanel
        if (gameOver){

        }
        gameOverPanel = createGameOverPanel();

        //JPanel gameOverPanel = createGameOverPanel();
        //gameOverPanel.setBounds(0, 200, 700, 200); // Set bounds for gameOverPanel
        interfaceGame.add(gameOverPanel);

        /*interfaceGame.add(gameOverPanel);
        for (int i =3 ; i < 6;i++){
            interfaceGame.remove(tableOfSoliders[i]);

        }*/


        //setVisible(true);
        //setSize(900, 900);
    }

    JPanel createGameOverPanel() {
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setBackground(Color.DARK_GRAY);
        gameOverPanel.setLayout(new BorderLayout());
        gameOverPanel.setOpaque(false);

        // Create and add image1 to the left of gameOverPanel
        URL imageURL1 = getClass().getResource("./Images/hosted.png");
        if (imageURL1 != null) {
            ImageIcon icon1 = new ImageIcon(imageURL1);
            Image scaledImage1 = icon1.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
            icon1 = new ImageIcon(scaledImage1);
            JLabel imageLabel1 = new JLabel(icon1);
            gameOverPanel.add(imageLabel1, BorderLayout.WEST);
        }

        // Create and add "Game Over" label to the center of gameOverPanel
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setForeground(Color.WHITE); // Set text color to white
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameOverPanel.add(gameOverLabel, BorderLayout.CENTER);

        // Create and add image2 to the right of gameOverPanel
        URL imageURL2 = getClass().getResource("./Images/winner.png");
        if (imageURL2 != null) {
            ImageIcon icon2 = new ImageIcon(imageURL2);
            Image scaledImage2 = icon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            icon2 = new ImageIcon(scaledImage2);
            JLabel imageLabel2 = new JLabel(icon2);
            gameOverPanel.add(imageLabel2, BorderLayout.EAST);
        }

        // Create and add user1 and user2 labels
        JLabel user1Label = new JLabel("user1", SwingConstants.CENTER);
        user1Label.setForeground(Color.WHITE); // Set text color to white
        user1Label.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel user2Label = new JLabel("user2", SwingConstants.CENTER);
        user2Label.setForeground(Color.WHITE); // Set text color to white
        user2Label.setFont(new Font("Arial", Font.BOLD, 18));

        // Create panel for user labels
        JPanel usersPanel = new JPanel(new GridLayout(1, 2));
        //usersPanel.setBackground(Color.DARK_GRAY);
        //usersPanel.add(user1Label);
        //usersPanel.add(user2Label);

        // Add usersPanel to gameOverPanel
        gameOverPanel.add(usersPanel, BorderLayout.SOUTH);

        return gameOverPanel;
    }
    public void addButtons(JPanel interfaceGame){
        for (int i =0 ; i < 9;i++){
            interfaceGame.add(tableOfSoliders[i]);

        }
    }


}
