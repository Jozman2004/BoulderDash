package model;

import java.util.Observable;

import model.elements.Element;

public interface IRoad {
    int getWidth();


    int getHeight();


    Element getOnTheRoadXY(int x, int y);


    void setMobileHasChanged();


    Observable getObservable();
}
