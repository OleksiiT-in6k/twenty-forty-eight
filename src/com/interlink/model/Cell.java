package com.interlink.model;

import java.awt.*;

/**
 * Created by employee on 7/19/16.
 */
public class Cell {
    int value;
    Point coordinate;


    Cell(int value, Point coordinate) {
        this.value = value;
        this.coordinate = coordinate;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public int getValue() {
        return value;
    }

}
