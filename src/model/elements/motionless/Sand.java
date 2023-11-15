package model.elements.motionless;

import model.elements.Permeability;
import model.elements.Sprite;

public class Sand extends MotionlessElement {
    
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('*', "src\\model\\elements\\sprite\\wall.png");

    /**
     * Instantiates a new Sand.
     */
    Sand() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
