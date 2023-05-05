import logic.GameGraphics;
import models.Singleton;

import javax.swing.*;
import java.awt.*;

public class RunSpaceInvaders extends JFrame {
    public RunSpaceInvaders(){
        Singleton boardProperties = Singleton.getInstance();

        Dimension dimension = new Dimension(boardProperties.boardWidth, boardProperties.boardHeight);
        add(new GameGraphics(dimension));

        setTitle("Space Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(boardProperties.boardWidth, boardProperties.boardHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new RunSpaceInvaders();
    }
}
