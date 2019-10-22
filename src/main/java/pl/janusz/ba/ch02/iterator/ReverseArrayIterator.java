package pl.janusz.ba.ch02.iterator;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class ReverseArrayIterator implements Iterator {

    private ArrayIterator arrayIterator;

    public ReverseArrayIterator(ArrayIterator arrayIterator) {

        this.arrayIterator = arrayIterator;
    }

    @Override
    public void first() {

        arrayIterator.last();
    }

    @Override
    public void last() {

        arrayIterator.first();
    }

    @Override
    public void next() {

        arrayIterator.previous();
    }

    @Override
    public void previous() {

        arrayIterator.next();
    }

    @Override
    public boolean isdone() {

        return arrayIterator.isdone();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {

        return arrayIterator.current();
    }
}
