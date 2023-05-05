package models;

import java.awt.*;

public class Character {
    private int coordinateX;
    private int coordinateY;
    private int width;
    private int height;
    private int speed;
    public Character(int coordinateX, int coordinateY, int width, int height, int speed) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;

        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    public void drawCharacter(Graphics2D graphics2D, Color color){
        graphics2D.setColor(color);
        graphics2D.fillRect(this.coordinateX, this.coordinateY, this.width, this.height);
    }
    public int getCoordinateX() {
        return coordinateX;
    }
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    public int getSpeed() {
        return speed;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
