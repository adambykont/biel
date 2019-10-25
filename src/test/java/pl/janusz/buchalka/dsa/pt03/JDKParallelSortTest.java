package pl.janusz.buchalka.dsa.pt03;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class JDKParallelSortTest {
    private Integer[] unsortedNumbers;
    private Integer[] sortedNumbers;

    @Test
    public void shuldSortManualExample() {

        Integer[] unsortedOne = new Integer[]{20, 25, -15, 7, 55, 1, -22};
        Integer[] sortedOne = unsortedOne.clone();
        Arrays.sort(sortedOne);

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldsortReversedData() {

        Integer[] unsortedOne = new Integer[]{4, 3, 2, 1};
        Integer[] sortedOne = new Integer[]{1, 2, 3, 4};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shuldSortAlreadySortedManualExample() {

        Integer[] unsortedOne = new Integer[]{20, 25, -15, 7, 55, 1, -22};
        Integer[] sortedOne = unsortedOne.clone();
        Arrays.sort(sortedOne);
        Integer[] sortedTwo = sortedOne.clone();

        JDKParallelSort.sort(sortedOne);

        assertThat(sortedOne, is(arrayContaining(sortedTwo)));
    }

    @Test
    public void shouldSortOneElementArray() {

        Integer[] unsortedOne = new Integer[]{7};
        Integer[] sortedOne = new Integer[]{7};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortTwoElementsUnsortedArray() {

        Integer[] unsortedOne = new Integer[]{7, 4};
        Integer[] sortedOne = new Integer[]{4, 7};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortTwoElementsSortedArray() {

        Integer[] unsortedOne = new Integer[]{4, 7};
        Integer[] sortedOne = new Integer[]{4, 7};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortThreeElementsUnsortedArray() {

        Integer[] unsortedOne = new Integer[]{7, 4, 5};
        Integer[] sortedOne = new Integer[]{4, 5, 7};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortThreeElementsSortedArray() {

        Integer[] unsortedOne = new Integer[]{4, 5, 7};
        Integer[] sortedOne = new Integer[]{4, 5, 7};

        JDKParallelSort.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Before
    public void setUp() throws Exception {

        unsortedNumbers = new Integer[]{23, 70, -34, 2, 2, -15, 5, 11, 5, 2, -11, 23, 3};
        sortedNumbers = unsortedNumbers.clone();
        Arrays.sort(sortedNumbers);
    }

    @Test
    public void shouldSort() {

        JDKParallelSort.sort(unsortedNumbers);

        assertThat(unsortedNumbers, is(arrayContaining(sortedNumbers)));
    }

}