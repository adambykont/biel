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
        node.setPrev(null);
        node.setNext(head);
        head = node;
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
        head = node.getNext();
        node.setNext(null);
        size--;

        return node;
    }
}
