package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

        if (contains(element)) {
            return;
        }

        final Node<E> node = new Node<>(element);

        if (root == null) {
            root = node;
        } else {
            Node<E> slider = root;
            while (true) {
                if (element.compareTo(slider.element) < 0) {
                    if (slider.left != null) {
                        slider = slider.left;
                    } else {
                        slider.left = node;
                        return;
                    }
                } else {
                    if (slider.right != null) {
                        slider = slider.right;
                    } else {
                        slider.right = node;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean contains(E element) {

        if (root == null) {
            return false;
        }

        Node<E> slider = root;
        while (slider != null) {
            if (element.compareTo(slider.element) == 0) {
                return true;
            }

            if (element.compareTo(slider.element) < 0) {
                slider = slider.left;
            } else {
                slider = slider.right;
            }
        }

        return false;
    }

    @Override
    public E min() {

        if (root == null) {
            return null;
        }

        Node<E> slider = root;

        while (slider.left != null) {
            slider = slider.left;
        }

        return slider.element;
    }

    @Override
    public E max() {

        if (root == null) {
            return null;
        }

        Node<E> slider = root;
        while (slider.right != null) {
            slider = slider.right;
        }

        return slider.element;
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
