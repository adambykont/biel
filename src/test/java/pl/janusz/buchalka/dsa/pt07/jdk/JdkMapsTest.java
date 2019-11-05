package pl.janusz.buchalka.dsa.pt07.jdk;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class JdkMapsTest {

    @Test
    public void hashMapIterator() {

        Map<String, Integer> map = new HashMap<>(2);

        Integer a;
        a = map.put("A", 1);
        assertThat(a, is(nullValue()));
        a = map.put("A", 1);
        assertThat(a, is(1));
        map.put("B", 2);
        map.put("C", 3);

        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        Iterator<String> keyIterator = map.keySet().iterator();
        Iterator<Integer> valuesIterator = map.values().iterator();

        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        final Set<String> keySet = map.keySet();
        final Collection<Integer> values = map.values();

        assertThat(keySet, hasItem("A"));
        assertThat(keySet, hasItems("C", "B"));
        final String[] strings = {"A", "B", "C"};
        assertThat(keySet, containsInAnyOrder(strings));
        assertThat(keySet, contains(strings));
    }
}