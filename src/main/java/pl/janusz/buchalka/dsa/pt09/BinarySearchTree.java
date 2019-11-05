package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTree<E> {

    private Node<E> root;

    private class Node<E> {

        private E element;
        private Node<E> left;
        private Node<E> right;
    }
}
