package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

//        if (contains(element)) {
//            return;
//        }
//
//        final Node<E> node = new Node<>(element);
//
//        if (root == null) {
//            root = node;
//        } else {
//            Node<E> slider = root;
//            while (true) {
//                if (element.compareTo(slider.element) < 0) {
//                    if (slider.left != null) {
//                        slider = slider.left;
//                    } else {
//                        slider.left = node;
//                        return;
//                    }
//                } else {
//                    if (slider.right != null) {
//                        slider = slider.right;
//                    } else {
//                        slider.right = node;
//                        return;
//                    }
//                }
//            }
//        }

        root = ins(root, element);
    }

    private Node<E> ins(Node<E> node, E key) {

        final Node<E> newOne = new Node<>(key);

        if (node == null) {
            return newOne;
        }

        if (key.compareTo(node.element) < 0) {
            node.left = ins(node.left, key);
        } else {
            node.right = ins(node.right, key);
        }

        return node;
    }

    @Override
    public void delete(E element) {

        root = del(root, element);
    }

    private Node<E> del(Node<E> node, E key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.element) < 0) {
            node.left = del(node.left, key);

            return node;
        }

        if (key.compareTo(node.element) > 0) {
            node.right = del(node.right, key);

            return node;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.left != null && node.right != null) {

            final E min = minInSubtree(node);
            node.element = min;
            node.left = del(node.left, min);

            return node;
        }

        if (node.left == null) {
            return node.right;
        } else {
            return node.left;
        }
    }

    private E minInSubtree(Node<E> node) {

        Node<E> slider = node;
        while (slider.left != null) {
            slider = slider.left;
        }

        return slider.element;
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
