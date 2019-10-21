package pl.janusz.frieze.mockadv;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class SomeInterfaceAnsweredTest {

    @Parameterized.Parameter(0)
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int s;
    private SomeInterface mock;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {2, 3, 6},
                {3, 4, 12},
                {2, 8, 16},
                {3, 9, 27},
        });
    }

    @Before
    public void setUp() throws Exception {

        mock = Mockito.mock(SomeInterface.class);

        Mockito
                .when(mock.getMatchingSize(Mockito.anyInt(), Mockito.anyInt()))
                .thenAnswer(new Answer<Integer>() {

                    @Override
                    public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                        return (int) invocationOnMock.getArguments()[0] * (int) invocationOnMock.getArguments()[1];
                    }
                });
    }

    @Test
    public void shouldReturnMatchingSize() {

        final int matchingSize = mock.getMatchingSize(a, b);
        assertThat(matchingSize, is(s));
    }
}