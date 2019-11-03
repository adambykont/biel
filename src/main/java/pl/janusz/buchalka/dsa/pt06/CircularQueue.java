package pl.janusz.buchalka.dsa.pt06;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class CircularQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 32;

    private int capacity;
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public CircularQueue() {

        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int size) {

        this.capacity = size;
        clear();
    }

    @Override
    public void add(E element) {

        if (size == capacity) {
            throw new IndexOutOfBoundsException();
        }

        array[tail] = element;
        size++;
        tail = (tail + 1) % capacity;
    }

    @Override
    public E remove() {

        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        final E e = (E) array[head];
        array[head] = null;
        head = (head + 1) % capacity;
        size--;

        return e;
    }

    @Override
    public E peek() {

        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        return (E) array[head];
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    public void clear() {

        array = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }
}
