package pl.janusz.buchalka.dsa.pt07;

import org.junit.Before;
import org.junit.Ignore;
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
    public void putTwoElements() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);

        Employee employee;
        employee = hashTable.get(pixie.getFirstName());
        assertThat(employee, is(pixie));
        employee = hashTable.get(dixie.getFirstName());
        assertThat(employee, is(dixie));
    }

    @Test
    public void putFourElements() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);
        hashTable.put(felix.getFirstName(), felix);
        hashTable.put(jinks.getFirstName(), jinks);

        assertThat(hashTable.get(felix.getFirstName()), is(felix));
        assertThat(hashTable.get(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.get(jinks.getFirstName()), is(jinks));
        assertThat(hashTable.get(dixie.getFirstName()), is(dixie));
    }

    @Test
    public void addFourElementsRemoveFourelementsRepeatedTwice() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);
        hashTable.put(jinks.getFirstName(), jinks);
        hashTable.put(felix.getFirstName(), felix);
        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.remove(dixie.getFirstName()), is(dixie));
        assertThat(hashTable.remove(felix.getFirstName()), is(felix));
        assertThat(hashTable.remove(jinks.getFirstName()), is(jinks));

        hashTable.put(pluto.getFirstName(), pluto);
        hashTable.put(tom.getFirstName(), tom);
        hashTable.put(jerry.getFirstName(), jerry);
        hashTable.put(dino.getFirstName(), dino);
        assertThat(hashTable.remove(dino.getFirstName()), is(dino));
        assertThat(hashTable.remove(tom.getFirstName()), is(tom));
        assertThat(hashTable.remove(pluto.getFirstName()), is(pluto));
        assertThat(hashTable.remove(jerry.getFirstName()), is(jerry));
    }
}
