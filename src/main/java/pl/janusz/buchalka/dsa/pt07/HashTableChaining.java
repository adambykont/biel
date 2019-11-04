package pl.janusz.buchalka.dsa.pt07;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class HashTableChaining<K, V> implements HashTable<K, V> {

    private List<Entry<K, V>>[] array;

    private double LOAD_FACTOR = 0.75;
    private int INITIAL_CAPACITY = 4;
    private int size;

    public HashTableChaining() {

        array = new List[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {

        int slot = hashKey(key);

        if (array[slot] == null) {
            array[slot] = new LinkedList<>();
        }

        array[slot].add(new Entry<>(key, value));

        size++;
    }

    @Override
    public V get(K key) {

        return null;
    }

    @Override
    public V remove(K key) {

        return null;
    }

    @Override
    public int size() {

        return size;
    }

    private int hashKey(K key) {

        return ((String) key).length() % array.length;
    }

    private class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {

            this.key = key;
            this.value = value;
        }
    }
}
