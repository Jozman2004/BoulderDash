package model;

import java.io.IOException;

import model.elements.mobile.Mobile;
import model.elements.mobile.Player;

public class BoulderDashModel implements IBoulderDashModel {
    /** The road. */
    private IRoad road;

    private Mobile player;

     public BoulderDashModel(final String fileName, final int playerStartX, final int playerStartY)
             throws IOException {
         this.setRoad(new Road(fileName));
         this.setPlayer(new Player(playerStartX, playerStartY, this.getRoad()));
     }

    // @Override
    public final IRoad getRoad() {
        return this.road;
    }

    private void setRoad(final IRoad road) {
        this.road = road;
    }

    // @Override
    public final Mobile getPlayer() {
        return this.player;
    }

    private void setPlayer(final Mobile player) {
        this.player = player;
    }
}
