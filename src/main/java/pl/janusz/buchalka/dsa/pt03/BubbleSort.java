package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class BubbleSort {

    public static void sort(Integer[] array) {

        int sortedIdx = array.length;
        boolean shouldSortRunAgain = true;

        while (sortedIdx > 0 && shouldSortRunAgain) {
            shouldSortRunAgain = false;
            for (int i = 0; i < sortedIdx - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    shouldSortRunAgain = true;
                }
            }
            sortedIdx--;
        }
    }
}
