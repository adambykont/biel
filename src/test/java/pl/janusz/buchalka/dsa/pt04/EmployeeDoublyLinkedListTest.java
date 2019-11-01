package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 27/10/2019. Project; bielmarcus
 */
public class EmployeeDoublyLinkedListTest extends EmployeeLinkedBasicTest {

    @Override
    protected List getImplementation() {

        return new EmployeeDoublyLinkedList();
    }

    @Test
    public void shouldAddFourEmployeesToEnd() {

        EmployeeDoublyLinkedList employees = new EmployeeDoublyLinkedList();
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.getSize(), is(0));
        employees.addToEnd(jinks);
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(1));
        employees.addToEnd(pixie);
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(2));
        employees.addToEnd(dixie);
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(3));
        employees.addToEnd(felix);
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(4));

        EmployeeNode node;
        node = employees.removeFromEnd();
        assertThat(node, hasProperty("employee", is(felix)));
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(3));
        node = employees.removeFromEnd();
        assertThat(node, hasProperty("employee", is(dixie)));
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(2));
        node = employees.removeFromEnd();
        assertThat(node, hasProperty("employee", is(pixie)));
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.getSize(), is(1));
        node = employees.removeFromEnd();
        assertThat(node, hasProperty("employee", is(jinks)));
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.getSize(), is(0));
        node = employees.removeFromEnd();
        assertThat(node, is(nullValue()));
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.getSize(), is(0));
        node = employees.removeFromEnd();
        assertThat(node, is(nullValue()));
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.getSize(), is(0));
    }
}