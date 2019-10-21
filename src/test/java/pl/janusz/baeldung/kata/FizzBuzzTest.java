package pl.janusz.baeldung.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class FizzBuzzTest {

    @Parameterized.Parameter(0)
    public int arg;

    @Parameterized.Parameter(1)
    public String fb;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1, "1"},
                {2, "2"},
                {3, "fizz"},
                {4, "4"},
                {5, "buzz"},
                {6, "fizz"},
                {7, "7"},
                {8, "8"},
                {9, "fizz"},
                {10, "buzz"},
                {11, "11"},
                {12, "fizz"},
                {13, "13"},
                {14, "14"},
                {15, "fizz-buzz"},
                {16, "16"},
                {17, "17"},
                {18, "fizz"},
                {19, "19"},
                {20, "buzz"}
        });
    }

    @Test
    public void shouldDoFizzBizz() {

        Object fizzbizzRessult = FizzBuzz.fizzBuzz(arg);
        final String msg = String.format("arg=%d fb=%s, fizzBuzz=%s", arg, fb, fizzbizzRessult);
        assertThat(msg, fb.equals(fizzbizzRessult), is(true));
    }
}