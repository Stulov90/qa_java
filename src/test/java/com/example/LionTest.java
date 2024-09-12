package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void lionGetKittensTest() {
        int expected = 3;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void lionExceptionTest() {
        try {
            new Lion("Львёночек", feline);
        } catch (Exception e) {
            String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}