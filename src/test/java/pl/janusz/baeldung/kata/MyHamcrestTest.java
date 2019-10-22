package pl.janusz.baeldung.kata;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class MyHamcrestTest {

    @Test
    public void listTests() {

        final Integer[] integers = {2, 3, 4, 5};
        final List<Integer> list = Arrays.asList(integers);

        assertThat(list, hasItems(integers));
        assertThat(list, hasItems(3, 4, 5));
        assertThat(list,contains(integers));
        assertThat(list,containsInAnyOrder(integers));
        assertThat(list,everyItem(greaterThanOrEqualTo(2)));
        assertThat(list,everyItem(lessThanOrEqualTo(5)));
    }
}