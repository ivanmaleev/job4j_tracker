package ru.job4j.list;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrixTest() {
        Integer[][] array = new Integer[2][2];
        array[0][0] = 2;
        array[0][1] = 19;
        array[1][0] = 45;
        array[1][1] = 56;
        List<Integer> expected = Matrix.matrixToArray(array);
        List<Integer> rsl = List.of(2, 19, 45, 56);
        assertThat(rsl, is(expected));
    }

}