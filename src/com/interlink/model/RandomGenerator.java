package com.interlink.model;


import java.util.List;

/**
 * Created by employee on 7/19/16.
 */
public interface RandomGenerator {
    Cell selectCell(List<Cell> cells);

    int generateValue();
}
