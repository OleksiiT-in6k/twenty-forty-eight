package com.interlink.model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 7/19/16.
 */
public class FieldTest {
    FieldModel field;
    Point point = new Point(0, 0);
    @Before
    public void initialize() {
        field = new FieldModel(4, 4) {
            @Override
            public Point generateRandomCoordinates() {
                point.translate(1, 1);
                return point;
            }

            @Override
            public int generateRandomValue() {
                return 0;
            }
        };
    }


    @org.junit.Test
    public void testForGeneratingNewCell() throws Exception {
        field.addCellToField();
        assertThat(field.getCells().size(), is(1));
    }

    @Test
    public void testForGeneratingNewCellWithXYCoordinates() throws Exception {
        field.addCellToField();
        point.setLocation(2, 3);
        assertThat(field.getCells().get(0).getCoordinate(), is(new Point(2, 3)));
    }

    @Test
    public void testForGeneratingTwoCellsWithDifferentCoordinates() {
        point.setLocation(0, 0);
        field.addCellToField();
        point.setLocation(0, 0);
        field.addCellToField();
        assertThat(field.getCells().get(0).getCoordinate(), is(not(field.getCells().get(1).getCoordinate())));
    }
}
