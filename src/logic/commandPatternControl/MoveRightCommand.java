package logic.commandPatternControl;

import models.PlayerShip;

public class MoveRightCommand implements Command{
    private PlayerShip playerShip;

    public MoveRightCommand(PlayerShip ps){
        playerShip = ps;
    }
    @Override
    public void execute() {
        playerShip.moveRight();
    }
}
