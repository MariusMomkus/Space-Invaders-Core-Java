package logic;

import logic.commandPatternControl.KeyboardController;
import logic.commandPatternControl.MoveLeftCommand;
import logic.commandPatternControl.MoveRightCommand;
import logic.commandPatternControl.ShootCommand;
import models.AlienShip;
import models.Bullet;
import models.PlayerShip;
import models.Singleton;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JPanel{
    private Timer gameRunnerTimer;
    //board metrics
    private Singleton boardProperties;
    //characters
    private PlayerShip player;
    private AlienShip[] alienShips ;
    private Bullet bullet;
    private boolean aliensWon;
    private boolean playerWon;
    public GameGraphics(Dimension dimension) {
        boardProperties = Singleton.getInstance();
        aliensWon = false;
        playerWon = false;

        //characters
        player = new PlayerShip(boardProperties.playerShipX, boardProperties.playerShipY,boardProperties.shipWidth, boardProperties.shipHeight, boardProperties.playerShipSpeed);
        bullet = new Bullet(0,0, boardProperties.bulletWidth, boardProperties.bulletHeight, boardProperties.bulletSpeed);

        //to generate coordinates for alien ships
        alienShips = new AlienShip[boardProperties.alienShipAmount];
        generateAlienShips();

        //repainting
        if (gameRunnerTimer == null) {
            gameRunnerTimer = new Timer(1, ae -> repaint());
            gameRunnerTimer.start();
        }

        //environment + controls
        setBackground(Color.black);
        setSize(dimension);
        setPreferredSize(dimension);

        //keyboard input controlling
        KeyboardController keyboardController = new KeyboardController();
        keyboardController.setCommand(39, new MoveRightCommand(player));
        keyboardController.setCommand(37, new MoveLeftCommand(player));
        keyboardController.setCommand(32, new ShootCommand(bullet, player));
        addKeyListener(keyboardController);
        setFocusable(true);
    }

    private void generateAlienShips() {
        int alienX = boardProperties.alienShipStartCordX, alienY = boardProperties.alienShipStartCordY;

        for (int i = 0; i < boardProperties.alienShipAmount; i++) {
            alienShips[i] = new AlienShip(alienX, alienY,boardProperties.shipWidth, boardProperties.shipHeight, boardProperties.alienShipSpeed, boardProperties.alienShipDownSpeed);
            alienX += boardProperties.shipWidth + 20;
            if (i == boardProperties.alienShipAmount/boardProperties.alienShipRowCount - 1){
                alienX = boardProperties.alienShipStartCordX;
                alienY += boardProperties.shipHeight + 20;
            }
        }
    }
    public void paintComponent (Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        playerWinningDetection();
        checkBorderReach();

        //background
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, boardProperties.boardWidth, boardProperties.boardHeight);

        //border
        graphics2D.setColor(Color.PINK);
        graphics2D.fillRect(boardProperties.borderX, boardProperties.borderY , boardProperties.borderWidth, boardProperties.borderHeight);

        //player ship
        player.drawCharacter(graphics2D, Color.BLACK);

        //bullet
        if (bullet.isKeepMoving()){
            bullet.moveUp();
            bullet.drawCharacter(graphics2D, Color.RED);
        }

        //alien ships
        hitDetecting();
        for (AlienShip alienShip : alienShips) {
            if(alienShip.isAlive()) {
                alienShip.drawCharacter(graphics2D, Color.GRAY);
            }
        }
        moveAlienShips();

        if(playerWon || aliensWon){
            gameRunnerTimer.stop();
            drawGameEndScreen(graphics2D);
        }
        graphics2D.dispose();
    }

    public void hitDetecting() {
        for (AlienShip alienShip : alienShips) {
            if(alienShip.isAlive() &&
            bullet.getCoordinateX() + bullet.getWidth() >= alienShip.getCoordinateX() &&
            bullet.getCoordinateY() + bullet.getHeight() >=alienShip.getCoordinateY() &&
            bullet.getCoordinateX() <= alienShip.getCoordinateX() + alienShip.getWidth() &&
            bullet.getCoordinateY() <= alienShip.getCoordinateY() + alienShip.getHeight()){
                alienShip.setAlive(false);
                bullet.setCoordinateY(-1);
            }
        }
    }

    public void playerWinningDetection(){
        int deadCount = 0;
        for (AlienShip alienShip: alienShips) {
             if(!alienShip.isAlive()) deadCount++;
        }
        if(deadCount == boardProperties.alienShipAmount){
            playerWon = true;
        }else{
            deadCount = 0;
        }
    }

    public void checkBorderReach() {
        for (AlienShip alienShip: alienShips) {
            if (alienShip.isAlive() &&
                    alienShip.getCoordinateY() + boardProperties.shipHeight >= boardProperties.borderY) {
                aliensWon = true;
                break;
            }
        }
    }
    public void moveAlienShips(){
        for (AlienShip alienShip : alienShips) {
            if (alienShip.getDirectionX()) {
                alienShip.moveRight();
            } else {
                alienShip.moveLeft();
            }
        }
        if (alienShips[boardProperties.alienShipAmount - 1].getCoordinateX() >= boardProperties.boardWidth - (boardProperties.shipWidth + 10) ||
                alienShips[0].getCoordinateX() <=  10){
            alienShipDirectionChanger();
        }
    }
    public void alienShipDirectionChanger(){
        if(alienShips[0].getDirectionX()){
            for (AlienShip alienShip : alienShips) {
                alienShip.setDirectionX(false);
                alienShip.moveDown();
            }
        }else {
            for (AlienShip alienShip : alienShips) {
                alienShip.setDirectionX(true);
                alienShip.moveDown();
            }
        }
    }
    public void drawGameEndScreen(Graphics2D graphics2D){
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0, boardProperties.boardWidth,boardProperties.boardHeight);
        Font forTitle = new Font("Helvetica", Font.BOLD, 25);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(forTitle);

        if(aliensWon && !playerWon){
            graphics2D.drawString("YOU LOST", boardProperties.boardWidth / 2 - 75, boardProperties.boardHeight / 2 - 25);
        }else {
            graphics2D.drawString("YOU WON", boardProperties.boardWidth / 2 - 75, boardProperties.boardHeight / 2 - 25);
        }
    }
}
