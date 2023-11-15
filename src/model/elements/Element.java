package model.elements;

import java.awt.Image;

public abstract class Element {

    private Sprite sprite;
    private Permeability permeability;

    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }


    // @Override
    public final Sprite getSprite() {
        return this.sprite;
    }


    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    // @Override
    public final Permeability getPermeability() {
        return this.permeability;
    }

    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }


    // @Override
    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
