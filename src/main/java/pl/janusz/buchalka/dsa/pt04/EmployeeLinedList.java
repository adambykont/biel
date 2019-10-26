package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeLinedList {

    private EmployeeNode head;
    private int size;

    public int getSize() {

        return size;
    }

    public void addToFront(Employee employee) {

        final EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public void printList() {

        EmployeeNode slider = head;
        while (slider != null) {
            System.out.println(slider);
            slider = slider.getNext();
        }
    }

    public boolean isEmpty() {

        return head == null;
    }

    public EmployeeNode removeFromFront() {

        final EmployeeNode node = head;
        head = node.getNext();
        size--;
        node.setNext(null);
        
        return node;
    }
}
