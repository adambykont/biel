package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public interface BST<E extends Comparable<? super E>> {

    void insert(E element);

    boolean contains(E element);

    E min();

    E max();
}
