package com.interlink.model;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by employee on 7/19/16.
 */
public class FieldTest {
    FieldModel field;

    @Before
    public void initialize() {
        field = new FieldModel();
    }

    @org.junit.Test
    public void testForGeneratingNewCell() throws Exception {
        field.generateRandomCell();
        assertThat(field.getCells().size(), is(1));
    }
}
