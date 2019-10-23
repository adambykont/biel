package pl.janusz.buchalka.dsa.pt03.benchmarks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class FibonacciTest {

    @Parameterized.Parameter(0)
    public int n;
    @Parameterized.Parameter(1)
    public long fib;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0, 0L},
                {1, 1L},
                {2, 1L},
                {3, 2L},
                {4, 3L},
                {5, 5L},
                {6, 8L},
                {7, 13L},
                {8, 21L},
                {9, 34L},
                {10, 55L},
                {11, 89L},
                {12, 144L},
                {13, 233L},
                {14, 377L},
                {15, 610L},
                {16, 987L},
                {17, 1597L},
                {18, 2584L},
                {19, 4181L},
                {20, 6765L}
        });
    }

    @Test
    public void shouldCalculateFibonacciNumbersFrom0To20() {

        long result = Fibonacci.fib(n);
        final String msg = String.format("Fibonacci of %d = %d. Calculated %d", n, fib, result);
        assertThat(msg, result, is(fib));
    }
}