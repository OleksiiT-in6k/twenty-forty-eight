package com.interlink.model;

import java.awt.*;

/**
 * Created by employee on 7/19/16.
 */
public class Cell {
    Point coordinate;

    Cell(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Point getCoordinate() {
        return coordinate;
    }
}
