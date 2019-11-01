package pl.janusz.ba.ch02.iterator;

import org.junit.Test;
import pl.janusz.ba.ch02.iterator.ArrayIterator;
import pl.janusz.ba.ch02.iterator.IteratorOutOfBoundsException;
import pl.janusz.ba.ch02.iterator.ReverseArrayIterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class ReverseArrayIteratorTest {

    @Test
    public void forwardBecomesBackward() {

        Object[] array = new Object[]{"A", "B", "C"};

        final ReverseArrayIterator iterator = new ReverseArrayIterator(new ArrayIterator(array));

        iterator.first();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[2]));

        iterator.next();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[1]));

        iterator.next();
        assertThat(iterator.isdone(), is(false));
        assertThat(iterator.current(), is(array[0]));

        iterator.next();
        assertThat(iterator.isdone(), is(true));
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            assertThat(e, instanceOf(IteratorOutOfBoundsException.class));
        }
    }
}