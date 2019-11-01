package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode prev;

    public EmployeeNode(Employee employee) {

        this.employee = employee;
    }

    public EmployeeNode getPrev() {

        return prev;
    }

    public void setPrev(EmployeeNode prev) {

        this.prev = prev;
    }

    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee(Employee employee) {

        this.employee = employee;
    }

    public EmployeeNode getNext() {

        return next;
    }

    public void setNext(EmployeeNode next) {

        this.next = next;
    }

    @Override
    public String toString() {

        return employee.toString();
    }
}
