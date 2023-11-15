package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.elements.Element;
import model.elements.motionless.MotionlessElementFactory;

public class Road extends Observable implements IRoad {
    /** The width. */
    private int width;

    /** The height. */
    private int height;

    /** The on the road. */
    private Element[][] onTheRoad;

    Road(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheRoad = new Element[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                Element element = MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]);
                Element defaultElement = MotionlessElementFactory.getFromFileSymbol('*');
                // Vérifiez si l'élément est différent de null avant de l'ajouter au tableau
                if (element != null) {
                    this.setOnTheRoadXY(element, x, y);
                } else {
                    // Si l'élément est null, initialisez la case avec un élément par défaut
                    this.setOnTheRoadXY(defaultElement, x, y);
                }
                System.out.println(element);
            }

            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }


    @Override
    public final int getWidth() {
        return this.width;
    }

    private void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public final int getHeight() {
        return this.height;
    }

    private void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public final Element getOnTheRoadXY(final int x, final int y) {
        return this.onTheRoad[x][y];
    }


    private void setOnTheRoadXY(final Element element, final int x, final int y) {
        this.onTheRoad[x][y] = element;
    }


    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }


    @Override
    public Observable getObservable() {
        return this;
    }
}
