package ru.job4j.lambda;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class CalcFunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcFunctions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = CalcFunctions.diapason(1, 3, x -> 3 * Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(6D, 17D);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    public void whenPowFunctionThenLinearResults() {
        List<Double> result = CalcFunctions.diapason(2, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D);
        assertThat(result, CoreMatchers.is(expected));
    }
}