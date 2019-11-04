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
    private Employee jinks;
    private Employee pixie;
    private Employee dixie;
    private Employee felix;
    private Employee pluto;

    @Before
    public void setUp() throws Exception {

        hashTable = getHashTable();

        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);
        pluto = new Employee("Pluto", "Dog", 7);
    }

    protected abstract HashTable<String, Employee> getHashTable();
}