package model.elements.mobile;

import java.io.IOException;

import model.IRoad;
import model.elements.Permeability;
import model.elements.Sprite;

public class Rock extends Mobile{
    /** The SPRITE. */
    private Sprite player;

    /** The spriteTurnLeft. */
    private Sprite playerTurnLeft;

    /** The spriteTurnRight. */
    private Sprite playerTurnRight;

    /** The spriteExplode. */
    private Sprite playerDie = new Sprite('O', "src\\model\\elements\\sprite\\ground.png");

    public Rock(final int x, final int y, final IRoad road) throws IOException {
        super(x, y, null, road, Permeability.BLOCKING);
       
        player = new Sprite('O', "src\\model\\elements\\sprite\\ground.png");
        playerTurnLeft = new Sprite('O', "src\\model\\elements\\sprite\\ground.png");
        playerTurnRight = new Sprite('O', "src\\model\\elements\\sprite\\ground.png");
        playerDie = new Sprite('O', "src\\model\\elements\\sprite\\ground.png");

        // playerTurnLeft.loadImage();
        // playerTurnRight.loadImage();
        // playerDie.loadImage();
        this.setSprite(player);
    }

    @Override
    public  void moveLeft() {
        super.moveLeft();
        this.setSprite(playerTurnLeft);
    }

    @Override
    public  void moveRight() {
        super.moveRight();
        this.setSprite(playerTurnRight);
    }

    @Override
    protected  void die() {
        //super.die();
        this.setSprite(playerDie);
    }

    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(player);
    }
}
