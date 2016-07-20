package com.interlink.model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 7/19/16.
 */
public class FieldTest {
    FieldModel field;
    int value;

    @Before
    public void initialize() {
        field = new FieldModel(4, 4) {
            @Override
            public Cell selectCell(List<Cell> emptyCells) {
                return emptyCells.get(0);
            }

            @Override
            public int generateValue() {
                return value;
            }
        };
    }

    @Test
    public void testForGeneratingNewCell() throws Exception {
        field.addCellToField();
        assertThat(field.getCells().size(), is(1));
    }


    @Test
    public void testForGeneratingTwoCellsWithDifferentCoordinates() {
        field.addCellToField();
        field.addCellToField();
        assertThat(field.getCells().get(0).getCoordinate(), is(not(field.getCells().get(1).getCoordinate())));
    }

    @Test
    public void testForGeneratingNumbersWithRightValues() throws Exception {
        value = 2;
        field.addCellToField();
        value = 4;
        field.addCellToField();
        value = 2;
        field.addCellToField();
        assertThat(field.getCells().get(0).getValue() == 2 &&
                field.getCells().get(1).getValue() == 4 &&
                field.getCells().get(2).getValue() == 2, is(true));
    }

    @Test
    public void testForSelectingCellsWithRightCoordinates() throws Exception {
        field.addCellToField();
        field.addCellToField();
        field.addCellToField();
        List expectedCells = new ArrayList();
        expectedCells.add(new Cell(0, new Point(0, 0)));
        expectedCells.add(new Cell(0, new Point(0, 1)));
        expectedCells.add(new Cell(0, new Point(0, 2)));
        assertThat(field.getCells(), is(expectedCells));
    }
}
