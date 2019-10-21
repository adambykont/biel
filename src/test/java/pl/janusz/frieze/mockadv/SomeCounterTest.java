package pl.janusz.frieze.mockadv;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class SomeCounterTest {

    @Test
    public void contsToFive() {

        final SomeCounter mock = Mockito.mock(SomeCounter.class);

        Mockito
                .when(mock.getCount())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);

        assertThat(mock.getCount(), is(1));
        Mockito
                .verify(mock, Mockito.times(1))
                .getCount();

        assertThat(mock.getCount(), is(2));
        Mockito
                .verify(mock, Mockito.times(2))
                .getCount();

        assertThat(mock.getCount(), is(3));
        Mockito
                .verify(mock, Mockito.times(3))
                .getCount();

        assertThat(mock.getCount(), is(4));
        Mockito
                .verify(mock, Mockito.times(4))
                .getCount();

        assertThat(mock.getCount(), is(5));
        Mockito
                .verify(mock, Mockito.times(5))
                .getCount();

        assertThat(mock.getCount(), is(5));
        Mockito
                .verify(mock, Mockito.times(6))
                .getCount();
    }
}