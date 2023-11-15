package model.elements.mobile;

import java.awt.Point;

import model.IRoad;
import model.elements.Element;
import model.elements.Permeability;
import model.elements.Sprite;

public class Mobile extends Element {
    
    private Point position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IRoad   road;

    // /** The board. */
    // private IBoard  board;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IRoad road, final Permeability permeability) {
        super(sprite, permeability);
        this.setRoad(road);
        this.position = new Point();
    }

    Mobile(final int x, final int y, final Sprite sprite, final IRoad road, final Permeability permeability) {
        this(sprite, road, permeability);
        this.setX(x);
        this.setY(y);
    }

    // @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    // @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    // @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    // @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    // @Override
    public void doNothing() {
        this.setHasMoved();
    }

    private void setHasMoved() {
        this.getRoad().setMobileHasChanged();
    }

    // @Override
    public final int getX() {
        return this.getPosition().x;
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    // @Override
    public final int getY() {
        return this.getPosition().y;
    }

    public final void setY(final int y) {
        this.getPosition().y = (y + this.getRoad().getHeight()) % this.getRoad().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    public IRoad getRoad() {
        return this.road;
    }

    private void setRoad(final IRoad road) {
        this.road = road;
    }

    // @Override
    public Boolean isAlive() {
        return this.alive;
    }

    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    // @Override
    public Boolean isCrashed() {
        return ((Element) this.getRoad().getOnTheRoadXY(this.getX(), this.getY())).getPermeability() == Permeability.BLOCKING;
    }


    // @Override
    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    // protected IBoard getBoard() {
    //     return this.board;
    // }

}

