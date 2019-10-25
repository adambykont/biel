package pl.janusz.buchalka.dsa.pt03.benchmarks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class FactorialTest {

    @Parameterized.Parameter(0)
    public int n;
    @Parameterized.Parameter(1)
    public long fact;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0, 1l},
                {1, 1L},
                {2, 2L},
                {3, 6L},
                {4, 24L},
                {5, 120L},
                {6, 720L},
                {7, 5040L},
                {8, 40320L},
                {9, 362880L},
                {10, 3628800L}
        });
    }

    @Test
    public void iterativeFactorial() {

        final long result = Factorial.factorialIterative(n);
        final String format = String.format("%d! = %d%n, calculated %d%n", n, fact, result);
        assertThat(format, result, is(fact));
    }

    @Test
    public void recursiveFactorial() {

        final long result = Factorial.factorialRecursive(n);
        final String format = String.format("%d! = %d%n, calculated %d%n", n, fact, result);
        assertThat(format, result, is(fact));
    }

    @Test
    public void recursiveTailFactorial() {

        final long result = Factorial.factorialTailRecursive(n);
        final String format = String.format("%d! = %d%n, calculated %d%n", n, fact, result);
        assertThat(format, result, is(fact));
    }
}