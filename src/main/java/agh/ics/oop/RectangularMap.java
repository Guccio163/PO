package agh.ics.oop;

import agh.ics.oop.maps.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width1, int height1) {
        super(new Vector2d(0, 0), new Vector2d(width1, height1));
    }
}