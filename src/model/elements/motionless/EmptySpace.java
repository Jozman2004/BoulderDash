package model.elements.motionless;

import java.awt.image.BufferedImage;

import model.MapSprite;
import model.elements.Permeability;
import model.elements.Sprite;

public class EmptySpace extends MotionlessElement {

    MapSprite sprite = new MapSprite();
    BufferedImage[] sprites = sprite.getSprites();
    BufferedImage image = sprites[4];

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "src\\model\\elements\\sprite\\wall.png");

    /**
     * Instantiates a new EmptySpace.
     */
    EmptySpace() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
