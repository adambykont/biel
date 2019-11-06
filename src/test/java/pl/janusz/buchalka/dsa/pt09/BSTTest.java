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
    public void insertTwoElementsSecondToLeft() {

        tree.insert(5);
        tree.insert(3);
        boolean contains;
        contains = tree.contains(5);
        assertThat(contains, is(true));
        contains = tree.contains(3);
        assertThat(contains, is(true));
    }

    @Test
    public void insertTwoElementsSecondToRight() {

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

    @Test
    public void deleteFromEmptyTree() {

        assertThat(tree.contains(1), is(false));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void deleteFromOneElementTree() {

        tree.insert(1);
        assertThat(tree.contains(1), is(true));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void deleteParentFromTwoElementsTreeChildonleft() {

        tree.insert(2);
        tree.insert(1);
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(2), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(1), is(true));
    }

    @Test
    public void deleteParentFromTwoElementsTreeChildOnRight() {

        tree.insert(2);
        tree.insert(3);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteParentFromThreeElementsTreeChildOnRightAndLeft() {

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(1), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteLeftChildFromThreeElementsTreeChildOnRightAndLeft() {

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(1), is(true));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnRight() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(12);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(12), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(12), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnLeft() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(7);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(7), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(7), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnLeftAndRight() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(7), is(true));
        assertThat(tree.contains(12), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(7), is(true));
        assertThat(tree.contains(12), is(true));
    }

    @Test
    public void deleteAllNumbersFromBiggerTree() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number), is(true));
        }

        for (Integer number : numbers) {
            tree.delete(number);
            assertThat(tree.contains(number), is(false));
        }
    }
}