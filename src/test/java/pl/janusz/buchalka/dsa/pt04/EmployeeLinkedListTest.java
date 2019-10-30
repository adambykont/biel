package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeLinkedListTest extends EmployeeLinkedBasicTest {

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