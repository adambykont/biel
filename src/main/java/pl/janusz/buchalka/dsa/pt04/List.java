package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 30/10/2019. Project; bielmarcus
 */
public interface List {

    int getSize();

    void addToFront(Employee employee);

    void printList();

    boolean isEmpty();

    EmployeeNode removeFromFront();
}
