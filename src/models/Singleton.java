package models;

public class Singleton {
    private static Singleton single_instance = null;
    public int boardWidth;
    public int boardHeight;
    public int shipWidth;
    public int shipHeight;
    public int playerShipX;
    public int playerShipY;
    public int playerShipSpeed;
    public int alienShipSpeed;
    public int alienShipDownSpeed;
    public int alienShipAmount;
    public int alienShipRowCount;
    public int alienShipStartCordX;
    public int alienShipStartCordY;
    public int bulletWidth;
    public int bulletHeight;
    public int bulletSpeed;
    public int borderX;
    public int borderY;
    public int borderWidth;
    public int borderHeight;    private Singleton(){
        this.boardWidth = 500;
        this.boardHeight = 500;

        this.shipWidth = 20;
        this.shipHeight = 20;

        this.playerShipX = this.boardWidth/2 - this.shipWidth;
        this.playerShipY = this.boardHeight - this.shipHeight * 5; //500 - (20 * 5) = 400
        this.playerShipSpeed = 10;

        this.alienShipSpeed = 4;
        this.alienShipDownSpeed = 20;
        this.alienShipAmount = 10;
        this.alienShipRowCount = 2;
        this.alienShipStartCordX = 10;
        this.alienShipStartCordY = 10;

        this.bulletWidth = 3;
        this.bulletHeight = 10;
        this.bulletSpeed = 10;

        this.borderX = 0;
        this.borderY = this.playerShipY - shipHeight; // 400 - 20 = 380
        this.borderWidth = boardWidth;
        this.borderHeight = 2;
    }

    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }

}
