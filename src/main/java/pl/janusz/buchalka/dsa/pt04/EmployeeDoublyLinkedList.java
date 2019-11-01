package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeDoublyLinkedList implements List {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public void addToFront(Employee employee) {

        final EmployeeNode node = new EmployeeNode(employee);
        if (head == null) {
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {

        final EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    @Override
    public void printList() {

        EmployeeNode slider = head;
        while (slider != null) {
            System.out.println(slider);
        }
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public EmployeeNode removeFromFront() {

        EmployeeNode node = head;
        if (head != null) {
            head = node.getNext();
            if (size == 1) {
                tail = null;
            } else {
                node.getNext().setPrev(null);
            }
            node.setNext(null);
            size--;
        }

        return node;
    }

    public EmployeeNode removeFromEnd() {

        EmployeeNode node = tail;

        if (tail != null) {
            if (size == 1) {
                head = tail = null;
            } else {
                tail.getPrev().setNext(null);
                tail = tail.getPrev();
            }
            node.setPrev(null);
            size--;
        }

        return node;
    }

    public void addBefore(Employee employee, Employee before) {

        EmployeeNode position = findNode(before);
        if (position == null) {
            return;
        }

        if (position.getPrev() == null) {
            addToFront(employee);
        } else {
            final EmployeeNode node = new EmployeeNode(employee);
            position.getPrev().setNext(node);
            node.setPrev(position.getPrev());
            node.setNext(position);
            position.setPrev(node);
            size++;
        }
    }

    private EmployeeNode findNode(Employee lookup) {

        EmployeeNode slider = head;

        while (slider != null && !lookup.equals(slider.getEmployee())) {
            slider = slider.getNext();
        }

        return slider;
    }
}
