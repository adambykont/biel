package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public abstract class EmployeeLinkedBasicTest {
    protected EmployeeLinkedList employees;
    protected Employee jinks;
    protected Employee pixie;
    protected Employee dixie;
    protected Employee felix;

    @Before
    public void setUp() throws Exception {

        employees = new EmployeeLinkedList();
        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);

        employees.addToFront(jinks);
        employees.addToFront(pixie);
        employees.addToFront(dixie);
        employees.addToFront(felix);
    }

    @Test
    public void sizeShouldBeFour() {

        final int size = employees.getSize();
        assertThat(size, is(4));

        assertThat(employees.isEmpty(), is(false));
    }
}