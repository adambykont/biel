package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarysearchTreeObjective<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

        if (root == null) {
            root = new Node<>(element);
        } else {
            root.insert(element);
        }
    }

    @Override
    public void delete(E element) {

        if (root == null) {
            return;
        }

        root = root.delete(element);
    }

    @Override
    public boolean contains(E element) {

        if (root == null) {
            return false;
        }

        return root.contains(element);
    }

    @Override
    public E min() {

        if (root == null) {
            return null;
        }

        return root.min();
    }

    @Override
    public E max() {

        if (root == null) {
            return null;
        }

        return root.max();
    }

    private class Node<E extends Comparable<? super E>> {

        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node(E element) {

            this.element = element;
        }

        private void insert(E element) {

            if (element.compareTo(this.element) == 0) {
                return;
            }

            final Node<E> node = new Node<>(element);

            if (element.compareTo(this.element) < 0) {
                if (left != null) {
                    left.insert(element);
                } else {
                    left = node;
                }
            } else {
                if (right != null) {
                    right.insert(element);
                } else {
                    right = node;
                }
            }
        }

        public boolean contains(E element) {

            if (element.compareTo(this.element) == 0) {
                return true;
            }

            if (element.compareTo(this.element) < 0) {
                if (left != null) {
                    return left.contains(element);
                } else {
                    return false;
                }
            } else {
                if (right != null) {
                    return right.contains(element);
                } else {
                    return false;
                }
            }
        }

        public E min() {

            if (left == null) {
                return element;
            }

            return left.min();
        }

        public E max() {

            if (right == null) {
                return element;
            }

            return right.max();
        }

        public Node<E> delete(E key) {

            if (key.compareTo(this.element) < 0) {
                if (left != null) {
                    left = left.delete(key);
                }

                return this;
            }

            if (key.compareTo(this.element) > 0) {
                if (right != null) {
                    right = right.delete(key);
                }

                return this;
            }

            if (left == null && right == null) {
                return null;
            }

            if (left != null && right != null) {
                final E max = left.max();
                this.element = max;
                left = left.delete(max);

                return this;
            }

            if (left == null) {
                return right;
            } else {
                return left;
            }
        }
    }
}
