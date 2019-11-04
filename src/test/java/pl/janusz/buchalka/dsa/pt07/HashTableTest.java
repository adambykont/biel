package pl.janusz.buchalka.dsa.pt07;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public abstract class HashTableTest {

    protected HashTable<String, Employee> hashTable;
    protected Employee jinks;
    protected Employee pixie;
    protected Employee dixie;
    protected Employee felix;
    protected Employee pluto;
    protected Employee tom;
    protected Employee jerry;

    @Before
    public void setUp() throws Exception {

        hashTable = getHashTable();

        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);
        pluto = new Employee("Pluto", "Dog", 7);
        tom = new Employee("Tom", "Cat", 7);
        jerry = new Employee("Jerry", "Mouse", 7);
    }

    protected abstract HashTable<String, Employee> getHashTable();

    @Test
    public void putGetOneElementToEmptyHashTable() {

        hashTable.put(jinks.getFirstName(), jinks);
        final Employee employee = hashTable.get(jinks.getFirstName());
        assertThat(employee, is(jinks));
    }

    @Test
    public void putGetTwoElementsToEmptyHashTable() {

        hashTable.put(jinks.getFirstName(), jinks);
        hashTable.put(tom.getFirstName(), tom);
        Employee employee;
        employee = hashTable.get(jinks.getFirstName());
        assertThat(employee, is(jinks));
        employee = hashTable.get(tom.getFirstName());
        assertThat(employee, is(tom));
    }
}