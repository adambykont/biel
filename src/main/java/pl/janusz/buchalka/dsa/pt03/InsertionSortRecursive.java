package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class InsertionSortRecursive {

    public static void sort(Integer[] array) {

        for (int i = 1; i < array.length; i++) {

            putElementToaAlreadySorted(array, i);
        }
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
