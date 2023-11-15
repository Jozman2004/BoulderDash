package model.elements.motionless;

public abstract class MotionlessElementFactory {
    /** The Constant ditchRight. */
    private static final Wall WALL = new Wall();   
    private static final EmptySpace EMPTYSPACE = new EmptySpace();
    private static final Sand SAND = new Sand();
    
    private static MotionlessElement[] motionlessElements  = {
        WALL,
        EMPTYSPACE,
        SAND,
         };

    
    public static MotionlessElement createWall() {
        return WALL;
    }

    public static MotionlessElement createSand(){
        return SAND;
    }

    public static MotionlessElement createEmptyElement(){
        return EMPTYSPACE;
    }

    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return WALL;
    }
}
