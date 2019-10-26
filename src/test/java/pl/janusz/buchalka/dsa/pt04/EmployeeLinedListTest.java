package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeLinedListTest {

    private EmployeeLinedList employees;
    private Employee jinks;
    private Employee pixie;
    private Employee dixie;
    private Employee felix;

    @Before
    public void setUp() throws Exception {

        employees = new EmployeeLinedList();
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

    @Test
    public void shouldRemoveFirst() {

        assertThat(employees.getSize(), is(4));
        EmployeeNode node = employees.removeFromFront();
        assertThat(node, hasProperty("employee", is(felix)));

        assertThat(employees.getSize(), is(3));
    }

    @Test
    public void shouldRemoveAllOneByOne() {

        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(4));
        assertThat(employees.removeFromFront(), hasProperty("employee", is(felix)));
        assertThat(employees.getSize(), is(3));
        assertThat(employees.removeFromFront(), hasProperty("employee", is(dixie)));
        assertThat(employees.getSize(), is(2));
        assertThat(employees.removeFromFront(), hasProperty("employee", is(pixie)));
        assertThat(employees.getSize(), is(1));
        assertThat(employees.removeFromFront(), hasProperty("employee", is(jinks)));
        assertThat(employees.getSize(), is(0));
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.getSize(), is(0));
        assertThat(employees.isEmpty(), is(true));
    }
}