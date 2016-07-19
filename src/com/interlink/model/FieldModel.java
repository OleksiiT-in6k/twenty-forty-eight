package com.interlink.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 7/19/16.
 */
public class FieldModel implements RandomGenerator {

    List<Cell> cells;
    int xSize;
    int ySize;

    FieldModel(int xSize, int ySize) {
        cells = new ArrayList<>();
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void addCellToField() {
        Point coordinate = getCellCoordinate();
        int value = getCellValue();
        cells.add(new Cell(value, coordinate));

    }


    private Point getCellCoordinate() {
        Point coordinate = null;
        boolean isAdded = false;
        while (!isAdded) {
            coordinate = generateRandomCoordinates();
            if (isEmpty(coordinate)) {
                isAdded = true;
            }
        }
        return coordinate;
    }

    private int getCellValue() {
        return generateRandomValue();
    }


    public List<Cell> getCells() {
        return cells;
    }

    private boolean isEmpty(Point point) {
        boolean result = true;
        for (Cell cell : getCells()) {
            if (point.equals(cell.getCoordinate())) {
                result = false;
            }
        }
        return result;
    }


    @Override
    public Point generateRandomCoordinates() {
        Point point = new Point((int) (Math.random() * xSize), (int) (Math.random() * ySize));
        return point;
    }

    @Override
    public int generateRandomValue() {
        return 0;
    }


}
