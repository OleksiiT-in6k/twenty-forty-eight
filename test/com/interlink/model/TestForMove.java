package com.interlink.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Created by employee on 7/19/16.
 */
public class TestForMove {
    FieldModel fieldModel;

    @Before
    public void initialize() {
        fieldModel = new FieldModel(4, 4,
                "0 0 0 0\n" +
                        "0 2 0 0\n" +
                        "0 4 8 0\n" +
                        "0 0 0 0"
        );
    }

    @Test
    public void testForMoveUp() throws Exception {
        fieldModel.moveUp();
        FieldModel expectedField = new FieldModel(4, 4,
                "0 2 8 0\n" +
                        "0 4 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0"
        );

        assertThat(fieldModel.getCells(), containsInAnyOrder(expectedField.getCells().toArray()));
    }

    @Test
    public void testForMoveDown() throws Exception {
        fieldModel.moveDown();
        FieldModel expectedField = new FieldModel(4, 4,
                "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 2 0 0\n" +
                        "0 4 8 0"
        );
        assertThat(fieldModel.getCells(), containsInAnyOrder(expectedField.getCells().toArray()));
    }

    @Test
    public void testForMoveRight() throws Exception {
        fieldModel.moveRight();
        FieldModel expectedField = new FieldModel(4, 4,
                "0 0 0 0\n" +
                        "0 0 0 2\n" +
                        "0 0 4 8\n" +
                        "0 0 0 0"
        );
        assertThat(fieldModel.getCells(), containsInAnyOrder(expectedField.getCells().toArray()));
    }

    @Test
    public void testForMoveLeft() throws Exception {
        fieldModel.moveLeft();
        FieldModel expectedField = new FieldModel(4, 4,
                "0 0 0 0\n" +
                        "2 0 0 0\n" +
                        "4 8 0 0\n" +
                        "0 0 0 0"
        );
        assertThat(fieldModel.getCells(), containsInAnyOrder(expectedField.getCells().toArray()));
    }
}
