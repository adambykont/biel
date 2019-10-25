package pl.janusz.buchalka.dsa.pt03;

import java.util.Arrays;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class JDKParellelSort {

    public static void sort(Integer[] array) {

        Arrays.parallelSort(array);
    }
}
