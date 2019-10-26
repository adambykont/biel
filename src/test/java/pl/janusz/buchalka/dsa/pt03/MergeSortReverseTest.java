package pl.janusz.buchalka.dsa.pt03;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class MergeSortReverseTest {

    @Test
    public void sortOne() {

        Integer[] array = new Integer[]{1};
        MergeSortReverse.sort(array);
        assertThat(array, is(arrayContaining(1)));
    }

    @Test
    public void sortSortedtwo() {

        Integer[] array = new Integer[]{2, 1};
        MergeSortReverse.sort(array);
        assertThat(array, is(arrayContaining(2, 1)));
    }

    @Test
    public void sortUnsortedtwo() {

        Integer[] array = new Integer[]{1, 2};
        MergeSortReverse.sort(array);
        assertThat(array, is(arrayContaining(2, 1)));
    }

    @Test
    public void sort() {

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MergeSortReverse.sort(array);
        assertThat(array, is(arrayContaining(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
    }
}