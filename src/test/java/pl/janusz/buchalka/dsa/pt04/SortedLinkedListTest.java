package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public class SortedLinkedListTest {

    private SortedLinkedList list;

    @Before
    public void setUp() throws Exception {

        list = new SortedLinkedList();
    }

    @Test
    public void addOne() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));

        list.insert(1);

        assertThat(list.getSize(), is(1));
        assertThat(list.isEmpty(), is(false));

        final Integer first = list.getFirst();

        assertThat(first, is(1));
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void addOneTwo() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));

        list.insert(1);
        assertThat(list.getSize(), is(1));
        assertThat(list.isEmpty(), is(false));
        list.insert(2);
        assertThat(list.getSize(), is(2));
        assertThat(list.isEmpty(), is(false));

        Integer element;
        element = list.getFirst();
        assertThat(element, is(1));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(1));
        element = list.getFirst();
        assertThat(element, is(2));
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void addTwoOne() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));

        list.insert(2);
        assertThat(list.getSize(), is(1));
        assertThat(list.isEmpty(), is(false));
        list.insert(1);
        assertThat(list.getSize(), is(2));
        assertThat(list.isEmpty(), is(false));

        Integer element;
        element = list.getFirst();
        assertThat(element, is(1));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(1));
        element = list.getFirst();
        assertThat(element, is(2));
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void addOneTwoThree() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));

        list.insert(1);
        assertThat(list.getSize(), is(1));
        assertThat(list.isEmpty(), is(false));
        list.insert(2);
        assertThat(list.getSize(), is(2));
        assertThat(list.isEmpty(), is(false));
        list.insert(3);
        assertThat(list.getSize(), is(3));
        assertThat(list.isEmpty(), is(false));

        Integer element;
        element = list.getFirst();
        assertThat(element, is(1));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(2));
        element = list.getFirst();
        assertThat(element, is(2));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(1));
        element = list.getFirst();
        assertThat(element, is(3));
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void addThreeTwoOne() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));

        list.insert(3);
        assertThat(list.getSize(), is(1));
        assertThat(list.isEmpty(), is(false));
        list.insert(2);
        assertThat(list.getSize(), is(2));
        assertThat(list.isEmpty(), is(false));
        list.insert(1);
        assertThat(list.getSize(), is(3));
        assertThat(list.isEmpty(), is(false));

        Integer element;
        element = list.getFirst();
        assertThat(element, is(1));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(2));
        element = list.getFirst();
        assertThat(element, is(2));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.getSize(), is(1));
        element = list.getFirst();
        assertThat(element, is(3));
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void insert4to1() {

        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        assertThat(list.getFirst(), is(1));
        assertThat(list.getFirst(), is(2));
        assertThat(list.getFirst(), is(3));
        assertThat(list.getFirst(), is(4));
    }

    @Test
    public void insert4to1Shuffled() {

        list.insert(4);
        list.insert(1);
        list.insert(3);
        list.insert(2);

        assertThat(list.getFirst(), is(1));
        assertThat(list.getFirst(), is(2));
        assertThat(list.getFirst(), is(3));
        assertThat(list.getFirst(), is(4));
    }

    @Test
    public void insert312() {

        list.insert(3);
        list.insert(1);
        list.insert(2);
        assertThat(list.getFirst(), is(1));
        assertThat(list.getFirst(), is(2));
        assertThat(list.getFirst(), is(3));
    }

    @Test
    public void addTenToOnoByOne() {

        list.insert(10);
        list.insert(1);
        list.insert(8);
        list.insert(3);
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(7);
        list.insert(2);
        list.insert(9);
        assertThat(list.getSize(), is(10));
        for (int i = 0; i < 10; i++) {
            assertThat(list.getSize(), is(10 - i));
            assertThat(list.getFirst(), is(i + 1));
        }

        assertThat(list.getSize(), is(0));
    }
}