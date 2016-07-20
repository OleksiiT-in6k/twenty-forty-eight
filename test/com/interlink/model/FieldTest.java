package com.interlink.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 7/19/16.
 */
public class FieldTest implements ValueGenerator, CellSelector {
    private FieldModel field;
    private int indexForGenerateValue = 0;
    private int[] values = {2, 4, 2};

    @Override
    public Cell selectCell(List<Cell> emptyCells) {
        return emptyCells.get(0);
    }

    @Override
    public int generateValue() {
        int result = values[indexForGenerateValue];
        indexForGenerateValue++;
        return result;
    }

    @Before
    public void initialize() {
        field = new FieldModel(4, 4,
                "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0");
        field.setValueGenerator(this);
        field.setCellSelector(this);
    }

    @Test
    public void testForGeneratingNewCell() throws Exception {
        field.addCellToField();
        FieldModel expectedField = new FieldModel(4, 4,
                "2 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0"
        );
        assertThat(field.getCells(), is(expectedField.getCells()));
    }




    @Test
    public void testForSelectingCellsWithRightCoordinatesAndRightValue() throws Exception {
        field.addCellToField();
        field.addCellToField();
        field.addCellToField();
        FieldModel expectedField = new FieldModel(4, 4,
                "2 0 0 0\n" +
                        "4 0 0 0\n" +
                        "2 0 0 0\n" +
                        "0 0 0 0"
        );
        assertThat(field.getCells(), is(expectedField.getCells()));
    }
}
