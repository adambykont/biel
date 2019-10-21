package pl.janusz.frieze.mockadv;

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
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class SomeInterfaceTest {

    @Parameterized.Parameter(0)
    public int a;
    @Parameterized.Parameter(1)
    public int size;

    private SomeInterface mock;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 4},
                {3, 9},
                {4, 16},
                {5, 25}
        });
    }

    @Before
    public void setUp() throws Exception {

        mock = Mockito.mock(SomeInterface.class);
        Mockito
                .when(mock.getMatchingSize(1, 1))
                .thenReturn(1);
        Mockito
                .when(mock.getMatchingSize(2, 2))
                .thenReturn(4);
        Mockito
                .when(mock.getMatchingSize(3, 3))
                .thenReturn(9);
        Mockito
                .when(mock.getMatchingSize(4, 4))
                .thenReturn(16);
        Mockito
                .when(mock.getMatchingSize(5, 5))
                .thenReturn(25);
    }

    @Test
    public void returnsSize() {

        final int matchingSize = mock.getMatchingSize(a, a);
        assertThat(matchingSize, is(equalTo(size)));
    }
}