import models.Bullet;
import models.Singleton;
import org.junit.Assert;
import org.junit.Test;

public class BulletMovingTests {

    @Test
    public void shouldBeAssignedWithPlayerYCoordinate(){
        //arrange
        Singleton metrics = Singleton.getInstance();
        Bullet bullet = new Bullet(metrics.playerShipX, 0, metrics.bulletWidth, metrics.bulletHeight, metrics.bulletSpeed);

        //act
        bullet.moveUp();

        //assert
        Assert.assertEquals(metrics.playerShipY, bullet.getCoordinateY());
    }
}

