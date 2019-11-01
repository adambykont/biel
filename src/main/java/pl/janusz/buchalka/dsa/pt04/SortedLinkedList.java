package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public class SortedLinkedList {

    private Node head;
    private int size;

    public void insert(Integer value) {

        final Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            if (value <= head.element) {
                node.next = head;
                head = node;
            } else {
                Node slider = head;
                while (slider.next != null && value >= slider.next.element) {
                    slider = slider.next;
                }
                node.next = slider.next;
                slider.next = node;
            }
        }
        size++;
    }

    public int getSize() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public Integer getFirst() {

        if (head == null) {
            return null;
        }

        Node node = head;
        head = node.next;
        size--;

        return node.element;
    }

    private class Node {

        private Integer element;
        private Node next;

        public Node(Integer element) {

            this.element = element;
        }
    }
}
