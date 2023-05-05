package models;

import interfaces.MoveDown;
import interfaces.MoveX;

public class AlienShip extends Character implements MoveX, MoveDown {
    private boolean directionX;
    private boolean isAlive;
    private int downSpeed;
    public AlienShip(int coordinateX, int coordinateY, int width, int height, int speed, int downSpeed) {
        super(coordinateX, coordinateY, width, height, speed);
        this.directionX = true; // true - to the right, false - to the left
        this.isAlive = true;
        this.downSpeed = downSpeed;
    }
    public boolean getDirectionX() {
        return directionX;
    }
    public void setDirectionX(boolean directionX) {
        this.directionX = directionX;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    @Override
    public void moveLeft() {
        if(getCoordinateX() - getSpeed() >= 10){
            setCoordinateX(getCoordinateX() - getSpeed());
        }
    }
    @Override
    public void moveRight() {
        if (getCoordinateX() + getSpeed() <= Singleton.getInstance().boardWidth - (getWidth() + 10)) {
            setCoordinateX(getCoordinateX() + getSpeed());
        }
    }
    @Override
    public void moveDown() {
        setCoordinateY(getCoordinateY() + downSpeed);
    }
}
