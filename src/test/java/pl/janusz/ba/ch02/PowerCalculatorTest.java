package pl.janusz.ba.ch02;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class PowerCalculatorTest {

    @Parameterized.Parameter(0)
    public int base;
    @Parameterized.Parameter(1)
    public int exponent;
    @Parameterized.Parameter(2)
    public int product;

    private PowerCalculator calculator;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0, 0, 1},
                {1, 0, 1},
                {2, 0, 1},
                {3, 0, 1},
                {4, 0, 1},
                {5, 0, 1},
                {0, 1, 0},
                {1, 1, 1},
                {2, 1, 2},
                {3, 1, 3},
                {4, 1, 4},
                {5, 1, 5},
                {0, 2, 0},
                {1, 2, 1},
                {2, 2, 4},
                {3, 2, 9},
                {4, 2, 16},
                {5, 2, 25},
                {0, 3, 0},
                {1, 3, 1},
                {2, 3, 8},
                {3, 3, 27},
                {4, 3, 64},
                {5, 3, 125},
                {0, 4, 0},
                {1, 4, 1},
                {2, 4, 16},
                {3, 4, 81},
                {4, 4, 256},
                {5, 4, 625},
                {0, 5, 0},
                {1, 5, 1},
                {2, 5, 32},
                {3, 5, 243},
                {4, 5, 1024},
                {5, 5, 3125}
        });
    }

    @Before
    public void setUp() throws Exception {

        calculator = new PowerCalculator();
    }

    @Test
    public void shouldCalculatePower() {

//        when
        int result = calculator.calculatePower(base, exponent);
//        then
        final String message = String.format("%d ^ %d = %d, calculated %d", base, exponent, product, result);
        assertThat(message, result, is(product));
    }
}