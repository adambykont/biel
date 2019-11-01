package pl.janusz.buchalka.dsa.pt03;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class InsertionSortRecursiveTest {

    private static final int BIG_SIZE = 1_000;
    private Integer[] unsortedNumbers;
    private Integer[] sortedNumbers;

    @Test
    public void shuldSortManualExample() {

        Integer[] unsortedOne = new Integer[]{20, 25, -15, 7, 55, 1, -22};
        Integer[] sortedOne = unsortedOne.clone();
        Arrays.sort(sortedOne);

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void sortMilllionElements() {

        Integer[] unsorted = new Integer[BIG_SIZE];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = ThreadLocalRandom.current().nextInt();
        }

        Integer[] sorted = unsorted.clone();
        Arrays.parallelSort(sorted);

        InsertionSortRecursive.sort(unsorted);

        assertThat(unsorted, is(arrayContaining(sorted)));
    }

    @Test
    public void shouldsortReversedData() {

        Integer[] unsortedOne = new Integer[]{4, 3, 2, 1};
        Integer[] sortedOne = new Integer[]{1, 2, 3, 4};

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shuldSortAlreadySortedManualExample() {

        Integer[] unsortedOne = new Integer[]{20, 25, -15, 7, 55, 1, -22};
        Integer[] sortedOne = unsortedOne.clone();
        Arrays.sort(sortedOne);
        Integer[] sortedTwo = sortedOne.clone();

        InsertionSortRecursive.sort(sortedOne);

        assertThat(sortedOne, is(arrayContaining(sortedTwo)));
    }

    @Test
    public void shouldSortOneElementArray() {

        Integer[] unsortedOne = new Integer[]{7};
        Integer[] sortedOne = new Integer[]{7};

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortTwoElementsUnsortedArray() {

        Integer[] unsortedOne = new Integer[]{7, 4};
        Integer[] sortedOne = new Integer[]{4, 7};

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortTwoElementsSortedArray() {

        Integer[] unsortedOne = new Integer[]{4, 7};
        Integer[] sortedOne = new Integer[]{4, 7};

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortThreeElementsUnsortedArray() {

        Integer[] unsortedOne = new Integer[]{7, 4, 5};
        Integer[] sortedOne = new Integer[]{4, 5, 7};

        InsertionSortRecursive.sort(unsortedOne);

        assertThat(unsortedOne, is(arrayContaining(sortedOne)));
    }

    @Test
    public void shouldSortThreeElementsSortedArray() {

        Integer[] unsortedOne = new Integer[]{4, 5, 7};
        Integer[] sortedOne = new Integer[]{4, 5, 7};

        InsertionSortRecursive.sort(unsortedOne);

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

        InsertionSortRecursive.sort(unsortedNumbers);

        assertThat(unsortedNumbers, is(arrayContaining(sortedNumbers)));
    }
}