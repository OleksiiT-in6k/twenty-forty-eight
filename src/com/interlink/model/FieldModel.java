package com.interlink.model;

import java.util.ArrayList;
import java.util.List;

import static com.interlink.model.Direction.*;


/**
 * Created by employee on 7/19/16.
 */
public class FieldModel implements MoveAble {

    private List<Cell> cells;
    private int xSize;
    private int ySize;
    private ValueGenerator valueGenerator;
    private CellSelector cellSelector;

    FieldModel(int xSize, int ySize) {
        cells = new ArrayList<>();
        this.xSize = xSize;
        this.ySize = ySize;
    }

    FieldModel(int xSize, int ySize, String cellEnumeration) {
        this(xSize, ySize);
        for (int y = 0; y < cellEnumeration.split("\n").length; y++) {
            String cellRow = cellEnumeration.split("\n")[y];
            for (int x = 0; x < cellRow.split(" ").length; x++) {
                int value = Integer.parseInt(cellRow.split(" ")[x]);
                if (value != 0)
                    cells.add(new Cell(value, new Point(x, y)));
            }
        }
    }


    protected FieldModel(int xSize, int ySize, List<Cell> cells) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.cells = cells;
    }

    public void addCellToField() {
        Cell cell = cellSelector.selectCell(getListWithEmptyCells());
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
        Direction direction = LEFT;
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

    public void setValueGenerator(ValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    public void setCellSelector(CellSelector cellSelector) {
        this.cellSelector = cellSelector;
    }

    private Point getCoordinateForDirection(Cell cell, Direction direction) {
        Point result = null;
        switch (direction) {
            case UP: {
                result = new Point(cell.getCoordinate().getX(), cell.getCoordinate().getY() - 1);
                break;
            }
            case DOWN: {
                result = new Point(cell.getCoordinate().getX(), cell.getCoordinate().getY() + 1);
                break;
            }
            case RIGHT: {
                result = new Point(cell.getCoordinate().getX() + 1, cell.getCoordinate().getY());
                break;
            }
            case LEFT: {
                result = new Point(cell.getCoordinate().getX() - 1, cell.getCoordinate().getY());
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
        return valueGenerator.generateValue();
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
}
