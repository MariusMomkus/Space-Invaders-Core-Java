import models.PlayerShip;
import models.Singleton;
import org.junit.Assert;
import org.junit.Test;

public class PlayerMovingBoundariesTests{
    @Test
    public void shouldNotMoveLeft(){
        //arrange
        Singleton metrics = Singleton.getInstance();
        PlayerShip playerShip = new PlayerShip(10, metrics.playerShipY, metrics.shipWidth, metrics.shipHeight, metrics.playerShipSpeed);

        //act
        playerShip.moveLeft();

        //assert
        Assert.assertEquals(10, playerShip.getCoordinateX());
    }

    @Test
    public void shouldNotMoveRight(){
        //arrange
        Singleton metrics = Singleton.getInstance();
        PlayerShip playerShip = new PlayerShip(metrics.boardWidth - 5, metrics.playerShipY, metrics.shipWidth, metrics.shipHeight, metrics.playerShipSpeed);

        //act
        playerShip.moveRight();

        //assert
        Assert.assertEquals(metrics.boardWidth - 5, playerShip.getCoordinateX());
    }
}
