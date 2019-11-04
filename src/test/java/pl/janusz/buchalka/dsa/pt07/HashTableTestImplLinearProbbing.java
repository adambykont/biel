package pl.janusz.buchalka.dsa.pt07;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class HashTableTestImplLinearProbbing extends HashTableTest {

    @Override
    protected HashTable<String, Employee> getHashTable() {

        return new LinearProbbingHashTable<>();
    }

    @Test
    public void putPixieDixie() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);

        Employee employee;
        employee = hashTable.get(pixie.getFirstName());
        assertThat(employee, is(pixie));
        employee = hashTable.get(dixie.getFirstName());
        assertThat(employee, is(dixie));
    }
}
