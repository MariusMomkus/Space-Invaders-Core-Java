package logic.commandPatternControl;

import models.PlayerShip;

public class MoveLeftCommand implements Command{
    private PlayerShip playerShip;

    public MoveLeftCommand(PlayerShip ps){
        playerShip = ps;
    }
    @Override
    public void execute() {
        playerShip.moveLeft();
    }
}
