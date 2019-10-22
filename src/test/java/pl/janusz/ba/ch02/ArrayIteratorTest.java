package pl.janusz.ba.ch02;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class ArrayIteratorTest {

    @Test
    public void iterationsRespectBounds() {

        Object[] array = {"A", "B", "C", "D", "E", "F"};
        final ArrayIterator iterator = new ArrayIterator(array, 1, 3);

        iterator.first();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[1]));

        iterator.next();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[2]));

        iterator.next();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[3]));

        iterator.next();
        assertThat(iterator.isdone(), is(true));
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            assertThat(e, instanceOf(IteratorOutOfBoundsException.class));
        }
    }

    @Test
    public void shouldIterateBackwards() {

        Object[] array = {"A", "B", "C"};
        final ArrayIterator iterator = new ArrayIterator(array);

        iterator.last();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[2]));

        iterator.previous();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[1]));

        iterator.previous();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[0]));

        iterator.previous();
        assertThat(iterator.isdone(), is(true));
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            assertThat(e, instanceOf(IteratorOutOfBoundsException.class));
        }
    }
}