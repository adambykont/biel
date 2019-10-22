package pl.janusz.baeldung.kata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class MySpyTest {

    @Test
    public void shouldDoArrayListJob() {

        final ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        final ArrayList spy = Mockito.spy(ArrayList.class);

        spy.add("Ala");
        spy.add("ma");
        spy.add("kota");

        final int size = spy
                .size();

        assertThat(size, is(3));

        Mockito
                .verify(spy, Mockito.times(3))
                .add(argumentCaptor.capture());

        final List<String> allValues = argumentCaptor.getAllValues();
        assertThat(allValues.get(0), is(equalTo("Ala")));
        assertThat(allValues.get(1), is(equalTo("ma")));
        assertThat(allValues.get(2), is(equalTo("kota")));
    }
}