package pl.janusz.buchalka.dsa.pt07;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class SimpleHashTable<K, V> implements HashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private V[] hashtable;

    public SimpleHashTable() {

        hashtable = (V[]) new Object[INITIAL_CAPACITY];
    }

    private int hashKey(K key) {

        return ((String) key).length() % hashtable.length;
    }

    @Override

    public void put(K key, V value) {

        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        hashtable[hashedKey] = value;
    }

    @Override
    public V get(K key) {

        int hashedKey = hashKey(key);

        return hashtable[hashedKey];
    }
}
