package com.interlink.model;


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

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (value != cell.value) return false;
        return coordinate != null ? coordinate.equals(cell.coordinate) : cell.coordinate == null;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        return result;
    }
}
