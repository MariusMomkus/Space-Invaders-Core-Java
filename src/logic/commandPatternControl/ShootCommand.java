package logic.commandPatternControl;

import models.Bullet;
import models.PlayerShip;

public class ShootCommand implements Command{
    Bullet bullet;
    PlayerShip player;

    public ShootCommand(Bullet b, PlayerShip ps){
        bullet = b;
        player = ps;
    }
    @Override
    public void execute() {
        bullet.setKeepMoving(true);
        bullet.setCoordinateY(player.getCoordinateY());
        bullet.setCoordinateX(player.getCoordinateX() + (player.getWidth() / 2));
        bullet.moveUp();
    }
}
