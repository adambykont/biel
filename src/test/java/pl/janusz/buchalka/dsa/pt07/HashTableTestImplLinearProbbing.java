package pl.janusz.buchalka.dsa.pt07;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class HashTableTestImplLinearProbbing extends HashTableTest {

    @Override
    protected HashTable<String, Employee> getHashTable() {

        return new LinearProbbingHashTable<>();
    }


}
