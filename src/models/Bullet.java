package models;

import interfaces.MoveUp;

import java.awt.*;

public class Bullet extends Character implements MoveUp {
    private boolean keepMoving;
    public Bullet(int coordinateX, int coordinateY, int width, int height, int speed) {
        super(coordinateX, coordinateY, width, height, speed);
        keepMoving = false;
    }
    @Override
    public void moveUp() {
        if(getCoordinateY() <= 0){
            keepMoving = false;
            setCoordinateY(Singleton.getInstance().playerShipY);
        }
       else{
            setCoordinateY(getCoordinateY() - getSpeed());
        }
    }
    public boolean isKeepMoving() {
        return keepMoving;
    }
    public void setKeepMoving(boolean keepMoving) {
        this.keepMoving = keepMoving;
    }
    @Override
    public void drawCharacter(Graphics2D graphics2D, Color color){
        graphics2D.setColor(color);
        graphics2D.fillOval(getCoordinateX(), getCoordinateY(), getWidth(), getHeight());
    }

}
