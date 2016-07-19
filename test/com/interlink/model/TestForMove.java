package com.interlink.model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 7/19/16.
 */
public class TestForMove {
    FieldModel fieldModel;

    @Before
    public void initialize() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(2, new Point(1, 1)));
        cells.add(new Cell(4, new Point(1, 2)));
        cells.add(new Cell(8, new Point(2, 2)));
        fieldModel = new FieldModel(4, 4, cells);
    }

    @Test
    public void testForMoveUp() throws Exception {
        fieldModel.moveUp();
        List expectedCells = new ArrayList();
        expectedCells.add(new Cell(2, new Point(1, 0)));
        expectedCells.add(new Cell(4, new Point(1, 1)));
        expectedCells.add(new Cell(8, new Point(2, 0)));
        assertThat(fieldModel.getCells(), is(expectedCells));
    }


}
