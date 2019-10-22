package pl.janusz.ut28minutes.mockbasics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class ListUtlsTest {

    private List mock;
    private String in28m;

    @Before
    public void setUp() throws Exception {

        mock = Mockito.mock(List.class);
        in28m = "In 28 Minutes";
    }

    @Test
    public void shouldReturnIncrementingValuesFrom0to3() {

        Mockito
                .when(mock.size())
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3);

        assertThat(mock.size(), is(0));
        assertThat(mock.size(), is(1));
        assertThat(mock.size(), is(2));
        assertThat(mock.size(), is(3));
        assertThat(mock.size(), is(3));
        assertThat(mock.size(), is(3));
    }

    @Test
    public void shouldReturnIn28MinutesFor0GivenAsArgument() {

        Mockito
                .when(mock.get(0))
                .thenReturn(in28m);

        assertThat(mock.get(0), is(equalTo(in28m)));
    }

    @Test
    public void shouldReturnNullAsDefaultValue() {

        assertThat(mock.get(0), is(nullValue()));
    }

    @Test
    public void shouldReturnIn28MinutesForAnyintAsArgument() {

        Mockito
                .when(mock.get(Mockito.anyInt()))
                .thenReturn(in28m);

        assertThat(mock.get(13), is(equalTo(in28m)));
    }

    @Test
    public void zeroArgumentThrowsException() {

        final String msg = "Zero not allowed";
        Mockito
                .when(mock.add(0))
                .thenThrow(new IllegalArgumentException(msg));

        try {
            mock.add(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo(msg)));
        }
    }
}