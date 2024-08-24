package kharbga.Images;import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyPanel extends JPanel {
    private Image backgroundImage;

    public MyPanel() {
        setLayout(null); // Use null layout for manual positioning

        // Load the background image
        URL imageUrl = getClass().getResource("./Images/war_map.jpg");
        if (imageUrl != null) {
            backgroundImage = new ImageIcon(imageUrl).getImage();
        } else {
            System.err.println("Error: Could not load background image");
        }

        // Create the interfaceGame panel
        JPanel interfaceGame = new JPanel() {
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
        interfaceGame.setBounds(100, 100, 600, 600);

        // Create buttons
        JButton button1 = new JButton("Button 1");

        // Position button partially outside the interfaceGame panel
        int buttonWidth = 100;
        int buttonHeight = 30;
        int buttonX = 100; // X-coordinate partially inside the panel
        int buttonY = 50; // Y-coordinate inside the panel
        button1.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

        // Add interfaceGame panel
        add(interfaceGame);

        // Add button to MyPanel
        add(button1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new MyPanel());
        frame.setVisible(true);
    }
}
