package com.interlink.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.interlink.model.Direction.UP;

/**
 * Created by employee on 7/19/16.
 */
public class FieldModel implements RandomGenerator, MoveAction {

    List<Cell> cells;
    int xSize;
    int ySize;

    FieldModel(int xSize, int ySize) {
        cells = new ArrayList<>();
        this.xSize = xSize;
        this.ySize = ySize;
    }


    protected FieldModel(int xSize, int ySize, List<Cell> cells) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.cells = cells;
    }

    public void addCellToField() {
        Point coordinate = getCellCoordinate();
        int value = getCellValue();
        cells.add(new Cell(value, coordinate));

    }

    @Override
    public void moveUp() {
        Direction direction = UP;
        for (int x = 0; x < xSize; x++) {
            boolean availableToMove = true;
            while (availableToMove) {
                availableToMove = false;
                for (Cell cell : getCellsFromColumnCoordinate(x)) {
                    if (isEmpty(getCoordinateForDirection(cell, direction))) {
                        availableToMove = true;
                        cell.setCoordinate(getCoordinateForDirection(cell, direction));
                    }
                }
            }
        }
    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }


    private Point getCoordinateForDirection(Cell cell, Direction direction) {
        Point result = null;
        switch (direction) {
            case UP: {
                result = new Point((int) cell.getCoordinate().getX(), (int) cell.getCoordinate().getY() - 1);
                break;
            }
            case DOWN: {
                result = new Point((int) cell.getCoordinate().getX(), (int) cell.getCoordinate().getY() + 1);
                break;
            }
            case RIGHT: {
                result = new Point((int) cell.getCoordinate().getX(), (int) cell.getCoordinate().getY() + 1);
                break;
            }
            case LEFT: {
                result = new Point((int) cell.getCoordinate().getX(), (int) cell.getCoordinate().getY() - 1);
                break;
            }
        }
        return result;
    }

    private List<Cell> getCellsFromRowCoordinate(int y) {
        List<Cell> cells = new ArrayList<>();
        for (Cell cell : this.cells) {
            if (cell.getCoordinate().getY() == y)
                cells.add(cell);
        }
        return cells;
    }

    private List<Cell> getCellsFromColumnCoordinate(int x) {
        List<Cell> cells = new ArrayList<>();
        for (Cell cell : this.cells) {
            if (cell.getCoordinate().getX() == x)
                cells.add(cell);
        }
        return cells;
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
        if (point.getX() >= xSize || point.getY() >= ySize || point.getX() < 0 || point.getY() < 0) {
            result = false;
        } else {
            for (Cell cell : getCells()) {
                if (point.equals(cell.getCoordinate())) {
                    result = false;
                }
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
