package pl.janusz.ba.ch02;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public interface Iterator {

    void first();

    void last();

    void next();

    void previous();

    boolean isdone();

    Object current() throws IteratorOutOfBoundsException;
}
