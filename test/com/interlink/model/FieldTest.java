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
    Point pointForRandom = new Point(0, 0);
    Point point = new Point(0, 0);
    int value;
    @Before
    public void initialize() {
        field = new FieldModel(4, 4);
        field = new FieldModel(4, 4) {
            @Override
            public Point generateRandomCoordinates() {
                pointForRandom.translate(1, 1);
                return new Point((int) pointForRandom.getX(), (int) pointForRandom.getY());
            }

            @Override
            public int generateRandomValue() {
                return value;
            }
        };
    }



    @org.junit.Test
    public void testForGeneratingNewCell() throws Exception {
        field.addCellToField();
        assertThat(field.getCells().size(), is(1));
    }
    

    @Test
    public void testForGeneratingTwoCellsWithDifferentCoordinates() {
        pointForRandom.setLocation(0, 0);
        field.addCellToField();
        pointForRandom.setLocation(0, 0);
        field.addCellToField();
        assertThat(field.getCells().get(0).getCoordinate(), is(not(field.getCells().get(1).getCoordinate())));
    }

    @Test
    public void testForGeneratingNumbersWithDifferentValue() throws Exception {
        value = 2;
        field.addCellToField();
        value = 4;
        field.addCellToField();
        value = 2;
        field.addCellToField();
        assertThat(field.getCells().get(0).getValue() == 2 && field.getCells().get(1).getValue() == 4 &&
                field.getCells().get(2).getValue() == 2, is(true));
    }

}
