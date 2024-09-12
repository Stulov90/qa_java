package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private Animal animal;
    private final String animalKind;
    private final List<String> food;

    public AnimalParamTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }
    @Parameterized.Parameters
    public static Object[][] getFoodDataTest() {
        return new Object[][]{
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") },
                { "Неизвестное животное", null }
        };
    }
    @Test
    public void animalGetFoodTest() throws Exception {
        if (food == null) {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
            String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            String actual = exception.getMessage();
            assertEquals(expected, actual);
        } else {
            assertEquals(food, animal.getFood(animalKind));
        }
    }
}