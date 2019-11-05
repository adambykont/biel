package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTreeRecursive<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

        if (contains(element)) {
            return;
        }

        root = insertRec(root, element);
    }

    @Override
    public boolean contains(E element) {

        return findRec(root, element);
    }

    @Override
    public E min() {

        if (root == null) {
            return null;
        }

        return recMin(root);
    }

    private E recMin(Node<E> node) {

        if (node.left == null) {
            return node.element;
        }

        return recMin(node.left);
    }

    @Override
    public E max() {

        if (root == null) {
            return null;
        }

        return recMax(root);
    }

    private E recMax(Node<E> node) {

        if (node.right == null) {
            return node.element;
        }

        return recMax(node.right);
    }

    private boolean findRec(Node<E> node, E element) {

        if (node == null) {
            return false;
        }

        if (element.compareTo(node.element) == 0) {
            return true;
        }

        if (element.compareTo(node.element) < 0) {
            return findRec(node.left, element);
        } else {
            return findRec(node.right, element);
        }
    }

    private Node<E> insertRec(Node<E> node, E element) {

        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insertRec(node.left, element);
        } else {
            node.right = insertRec(node.right, element);
        }

        return node;
    }

    private class Node<E> {

        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node(E element) {

            this.element = element;
        }
    }
}
