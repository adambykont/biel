package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class InsertionSortRecursive {

    public static void sort(Integer[] array) {

        recursiveSort(array, array.length - 1);
    }

    private static void recursiveSort(Integer[] array, int idx) {

        if (idx == 0) {
            return;
        }

        recursiveSort(array, idx - 1);

        putElementToaAlreadySorted(array, idx);
    }

    private static void putElementToaAlreadySorted(Integer[] array, int idx) {

        Integer buffer = array[idx];

        int slider = idx;

        while (slider > 0 && buffer < array[slider - 1]) {
            array[slider] = array[slider - 1];
            slider--;
        }

        array[slider] = buffer;
    }
}
