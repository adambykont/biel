package pl.janusz.buchalka.dsa.pt09;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public abstract class BSTTest {

    protected BST<Integer> tree;
    protected Integer[] numbers;

    @Before
    public void setUp() throws Exception {

        tree = getTree();

        numbers = new Integer[]{10, 5, 15, 3, 7, 8, 17};
    }

    protected abstract BST getTree();

    @Test
    public void emptyAtTheBeginning() {

        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void oneElementTreeDoesNotContainOtherElements() {

        tree.insert(7);
        assertThat(tree.contains(-3), is(false));
        assertThat(tree.contains(-1), is(false));
        assertThat(tree.contains(0), is(false));
        assertThat(tree.contains(1), is(false));
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(3), is(false));
        assertThat(tree.contains(4), is(false));
        assertThat(tree.contains(5), is(false));
        assertThat(tree.contains(6), is(false));
        assertThat(tree.contains(13), is(false));
    }

    @Test
    public void insertOneElement() {

        tree.insert(5);
        final boolean contains = tree.contains(5);
        assertThat(contains, is(true));
    }

    @Test
    public void insertTwoelementsSecondToLeft() {

        tree.insert(5);
        tree.insert(3);
        boolean contains;
        contains = tree.contains(5);
        assertThat(contains, is(true));
        contains = tree.contains(3);
        assertThat(contains, is(true));
    }

    @Test
    public void insertTwoelementsSecondToRight() {

        tree.insert(5);
        tree.insert(7);
        boolean contains;
        contains = tree.contains(7);
        assertThat(contains, is(true));
        contains = tree.contains(5);
        assertThat(contains, is(true));
    }

    @Test
    public void insertMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number), is(true));
        }
    }

    @Test
    public void insertManyNotContainsOthet() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number + 20), is(false));
        }
    }

    @Test
    public void minOfEmptyTreeIsNull() {

        assertThat(tree.min(), is(nullValue()));
    }

    @Test
    public void minOfOneElementTree() {

        tree.insert(7);
        assertThat(tree.min(), is(7));
    }

    @Test
    public void minOfThreeElementsTree() {

        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        assertThat(tree.min(), is(3));
    }

    @Test
    public void maxOfEmptyTreeIsNull() {

        assertThat(tree.max(), is(nullValue()));
    }

    @Test
    public void maxOfOneElementTree() {

        tree.insert(7);
        assertThat(tree.max(), is(7));
    }

    @Test
    public void maxOfThreeElementsTree() {

        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        assertThat(tree.max(), is(9));
    }

    @Test
    public void minInMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        assertThat(tree.min(), is(3));
    }

    @Test
    public void maxInMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        assertThat(tree.max(), is(17));
    }
}