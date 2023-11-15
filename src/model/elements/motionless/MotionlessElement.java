package model.elements.motionless;

import model.elements.Element;
import model.elements.Permeability;
import model.elements.Sprite;

abstract class MotionlessElement extends Element {

    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
