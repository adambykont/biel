package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class SelectionSort {

    public static void sort(Integer[] array) {

        Integer maxSoFar = null;
        int sortedIdx = array.length;

        while (sortedIdx > 0) {
            maxSoFar = 0;
            for (int i = 1; i < sortedIdx; i++) {
                if (array[i] > array[maxSoFar]) {
                    maxSoFar = i;
                }
            }
            Integer temp = array[maxSoFar];
            array[maxSoFar] = array[sortedIdx - 1];
            array[sortedIdx - 1] = temp;
            sortedIdx--;
        }
    }
}
