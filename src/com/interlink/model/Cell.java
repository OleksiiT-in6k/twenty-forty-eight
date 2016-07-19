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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return coordinate != null ? coordinate.equals(cell.coordinate) : cell.coordinate == null;

    }

    @Override
    public int hashCode() {
        return coordinate != null ? coordinate.hashCode() : 0;
    }
}
