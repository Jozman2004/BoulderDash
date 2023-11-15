package model.elements.motionless;

import model.elements.Permeability;
import model.elements.Sprite;

public class Wall extends MotionlessElement {
    
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('#', "src\\model\\elements\\sprite\\wall.png");

    /**
     * Instantiates a new Wall.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
