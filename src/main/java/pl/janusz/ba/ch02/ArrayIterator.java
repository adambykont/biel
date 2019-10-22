package pl.janusz.ba.ch02;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class ArrayIterator implements Iterator {

    private Object[] array;
    private int firstElement;
    private int numberOfElements;

    private int current = -1;

    public ArrayIterator(Object[] array, int firstElement, int numberOfElements) {

        if (array == null) {
            throw new IllegalArgumentException("Array can not be null");
        }

        if (firstElement < 0 || firstElement >= array.length) {
            throw new IllegalArgumentException("First element outside the array");
        }

        if (numberOfElements < 0 || numberOfElements + firstElement - 1 > array.length) {
            throw new IllegalArgumentException("Number of elements reaching out the array");
        }

        this.array = array;
        this.firstElement = firstElement;
        this.numberOfElements = numberOfElements;
    }

    public ArrayIterator(Object[] array) {

        this(array, 0, array.length);
    }

    @Override
    public void first() {

        this.current = firstElement;
    }

    @Override
    public void last() {

        this.current = this.firstElement + this.numberOfElements - 1;
    }

    @Override
    public void next() {

        this.current++;
    }

    @Override
    public void previous() {

        this.current--;
    }

    @Override
    public boolean isdone() {

        return this.current > this.firstElement + this.numberOfElements - 1 || this.current < 0;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {

        if (isdone()) {
            throw new IteratorOutOfBoundsException();
        }

        return array[current];
    }
}
