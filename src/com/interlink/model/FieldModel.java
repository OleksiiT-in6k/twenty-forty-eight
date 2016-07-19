package com.interlink.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 7/19/16.
 */
public class FieldModel {

    List<Cell> cells;

    FieldModel() {
        cells = new ArrayList<>();
    }

    public void generateRandomCell() {
        cells.add(new Cell());
    }

    public List<Cell> getCells() {
        return cells;
    }
}
