package models;

import interfaces.MoveX;

public class PlayerShip extends Character implements MoveX {
    public PlayerShip(int coordinateX, int coordinateY,int width, int height, int speed) {
        super(coordinateX, coordinateY, width, height, speed);
    }
    @Override
    public void moveLeft() {
        if(getCoordinateX() - getSpeed() >= 10){
            setCoordinateX(getCoordinateX() - getSpeed());
        }
    }
    @Override
    public void moveRight() {
        if(getCoordinateX() + getSpeed() < Singleton.getInstance().boardWidth - (getWidth() + 10)) {
            setCoordinateX(getCoordinateX() + getSpeed());
        }
    }

}
