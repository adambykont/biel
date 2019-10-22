package pl.janusz.ba.ch02.iterator;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class IteratorOutOfBoundsException extends RuntimeException {

    public IteratorOutOfBoundsException(String message) {

        super(message);
    }

    public IteratorOutOfBoundsException() {

        this(null);
    }
}
