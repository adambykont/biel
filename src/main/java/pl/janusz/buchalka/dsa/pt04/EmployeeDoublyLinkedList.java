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

    }

    @Override
    public void printList() {

    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public EmployeeNode removeFromFront() {

        return null;
    }
}
