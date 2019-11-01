package pl.janusz.buchalka.dsa.pt04.jdk;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.InstanceOf;
import pl.janusz.buchalka.dsa.pt04.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 31/10/2019. Project; bielmarcus
 */
public abstract class JKDImplementationsTest {

    protected List<Employee> employees;

    protected Employee jinks;
    protected Employee pixie;
    protected Employee dixie;
    protected Employee felix;

    @Before
    public void setUp() throws Exception {

        employees = getImplementation();
        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);

        employees.add(jinks);
        employees.add(pixie);
        employees.add(dixie);
        employees.add(felix);
    }

    protected abstract List<Employee> getImplementation();

    @Test
    public void addRemoveFromBeginning() {

        assertThat(employees.size(), is(4));
        assertThat(employees.isEmpty(), is(false));
        assertThat(employees.remove(0), hasProperty("firstName", is(equalTo("Jinks"))));
        assertThat(employees.size(), is(3));
        assertThat(employees.isEmpty(), is(false));

        assertThat(employees.remove(0), hasProperty("firstName", is(equalTo("Pixie"))));
        assertThat(employees.size(), is(2));
        assertThat(employees.isEmpty(), is(false));

        assertThat(employees.remove(0), hasProperty("firstName", is(equalTo("Dixie"))));
        assertThat(employees.size(), is(1));
        assertThat(employees.isEmpty(), is(false));

        assertThat(employees.remove(0), hasProperty("firstName", is(equalTo("Felix"))));
        assertThat(employees.size(), is(0));
        assertThat(employees.isEmpty(), is(true));
    }

    @Test
    public void iterate() {

        final Iterator<Employee> iterator = employees.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(jinks));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(pixie));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(dixie));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(felix));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iterateOverListThrowsException() {

        employees.clear();
        final Iterator<Employee> iterator = employees.iterator();
        assertThat(iterator.hasNext(), is(false));
        try {
            iterator.next();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void removeWhenEmptyThrowsexception() {

        employees.clear();
        assertThat(employees.isEmpty(), is(true));
        assertThat(employees.size(), is(0));

        try {
            employees.remove(0);
            fail();
        } catch (Exception e) {
            assertThat(e, is(instanceOf(IndexOutOfBoundsException.class)));
        }
    }

    @Test
    public void iteratorRemoves() {

        final Iterator<Employee> iterator = employees.iterator();
        Employee next;
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        iterator.remove();
        assertThat(next, is(jinks));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        iterator.remove();
        assertThat(next, is(pixie));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        iterator.remove();
        assertThat(next, is(dixie));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        iterator.remove();
        assertThat(next, is(felix));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void addToEnd() {

        employees.clear();
        employees.add(employees.size(), jinks);
        employees.add(employees.size(), pixie);
        employees.add(employees.size(), dixie);
        employees.add(employees.size(), felix);
        assertThat(employees, hasSize(4));

        Employee remove;
        remove = employees.remove(employees.size() - 1);
        assertThat(remove, is(felix));
        assertThat(employees, hasSize(3));
        remove = employees.remove(employees.size() - 1);
        assertThat(remove, is(dixie));
        assertThat(employees, hasSize(2));
        remove = employees.remove(employees.size() - 1);
        assertThat(remove, is(pixie));
        assertThat(employees, hasSize(1));
        remove = employees.remove(employees.size() - 1);
        assertThat(remove, is(jinks));
        assertThat(employees, hasSize(0));
    }
}

