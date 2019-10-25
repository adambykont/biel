package pl.janusz.buchalka.dsa.pt03;

import java.util.Arrays;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class CountingSort {

    public static void sort(Integer[] array, Integer min, Integer max) {

        Integer[] count = new Integer[max - min + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < array.length; i++) {
            final int position = array[i] - min;
            count[position]++;
        }

        int slider = 0;
        for (int i = 0; i < count.length; i++) {
            int counted = count[i];
            Integer value = i + min;

            while (counted > 0) {
                array[slider] = value;
                counted--;
                slider++;
            }
        }
    }
}
