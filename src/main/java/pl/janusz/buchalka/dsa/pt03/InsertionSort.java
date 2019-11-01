package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class InsertionSort {

    public static void sort(Integer[] array) {

        int slider;
        Integer buffer = null;

        for (int i = 1; i < array.length; i++) {
            buffer = array[i];
            slider = i;
            while (slider > 0 && buffer < array[slider - 1]) {
                array[slider] = array[slider - 1];
                slider--;
            }
            array[slider] = buffer;
        }
    }
}
