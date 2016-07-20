package com.interlink.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.interlink.model.Direction.*;


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
        Cell cell = selectCell(getListWithEmptyCells());
        cell.setValue(getCellValue());
        cells.add(cell);
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
        Direction direction = DOWN;
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
    public void moveRight() {
        Direction direction = RIGHT;
        for (int y = 0; y < ySize; y++) {
            boolean availableToMove = true;
            while (availableToMove) {
                availableToMove = false;
                for (Cell cell : getCellsFromRowCoordinate(y)) {
                    if (isEmpty(getCoordinateForDirection(cell, direction))) {
                        availableToMove = true;
                        cell.setCoordinate(getCoordinateForDirection(cell, direction));
                    }
                }
            }
        }

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

    private List<Cell> getListWithEmptyCells() {
        List<Cell> result = new ArrayList<>();
        for (int x = 0; x < xSize; x++)
            for (int y = 0; y < ySize; y++)
                if (isEmpty(new Point(x, y))) {
                    result.add(new Cell(0, new Point(x, y)));
                }
        return result;
    }


    private int getCellValue() {
        return generateValue();
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
    public Cell selectCell(List<Cell> emptyCells) {
        int index = (int) (Math.random() * (emptyCells.size()));
        return emptyCells.get(index);
    }


    @Override
    public int generateValue() {
        return 0;
    }

}
