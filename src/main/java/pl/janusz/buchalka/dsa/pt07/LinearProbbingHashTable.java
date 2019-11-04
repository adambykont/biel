package pl.janusz.buchalka.dsa.pt07;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class LinearProbbingHashTable<K, V> implements HashTable<K, V> {

    private static final int INITIAL_CAPACITY = 4;
    private Entry<K, V>[] hashtable;

    public LinearProbbingHashTable() {

        hashtable = new Entry[INITIAL_CAPACITY];
    }

    private int hashKey(K key) {

        return ((String) key).length() % hashtable.length;
    }

    @Override

    public void put(K key, V value) {

        int hashedKey = getFirstAvailableSlotForKey(key);

        hashtable[hashedKey] = new Entry<>(key, value);
    }

    private int getFirstAvailableSlotForKey(K key) {

        int hashKey = hashKey(key);
        int stopSlot = hashKey;

        if (hashtable[hashKey] != null) {
            hashKey = (hashKey + 1) % hashtable.length;

            while (hashKey != stopSlot && hashtable[hashKey] != null) {
                hashKey = (hashKey + 1) % hashtable.length;
            }

            if (hashKey == stopSlot) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        return hashKey;
    }

    @Override
    public V get(K key) {

        int hashedKey = findSlotOccupiedByKey(key);

        V value = null;
        if (hashedKey != -1) {
            value = hashtable[hashedKey].value;
        }

        return value;
    }

    @Override
    public V remove(K key) {

        int hashedKey = findSlotOccupiedByKey(key);

        V v = null;

        if (hashedKey != -1) {
            v = hashtable[hashedKey].value;
            hashtable[hashedKey] = null;
        }

        return v;
    }

    private int findSlotOccupiedByKey(K key) {

        int hashkey = hashKey(key);
        int stopSlot = hashkey;

        if (hashtable[hashkey] == null || !key.equals(hashtable[hashkey].key)) {
            hashkey = (hashkey + 1) % hashtable.length;
            boolean shouldContinuesearch = true;
            while (hashkey != stopSlot && shouldContinuesearch) {
                if (hashtable[hashkey] == null || !key.equals(hashtable[hashkey].key)) {
                    hashkey = (hashkey + 1) % hashtable.length;
                } else {
                    shouldContinuesearch = false;
                }
            }

            if (hashkey == stopSlot) {
                hashkey = -1;
            }
        }

        return hashkey;
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
