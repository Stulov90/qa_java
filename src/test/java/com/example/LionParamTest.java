package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion(sex, feline);
    }

    @Parameterized.Parameters
    public static Object[][] hasManeDataTest() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testDoesHaveMane() {
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }
}